package ua.training.model.service;

import ua.training.model.entities.Target;
import ua.training.model.entities.TargetCredit;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCreditService implements CreditService {
    private List<TargetCredit> credits;
    public InMemoryCreditService() {
        credits = new ArrayList<>();
        init();
    }

    private void init() {
        credits.add(new TargetCredit("aliance.bank",1, 1560, 24, false, true, 1000000, Target.MORTGAGE));
        credits.add(new TargetCredit("aliance.bank", 2, 1240, 24, false, false, 100000, Target.STUDY));
        credits.add(new TargetCredit("aliance.bank", 3, 1940, 12, true, true, 500000, Target.CAR));
        credits.add(new TargetCredit("aliance.bank", 4, 800, 6, true, true, 10000, Target.RENOVATION));
        credits.add(new TargetCredit("oschad.bank", 5, 1500, 24, false, true, 100000, Target.STUDY));
        credits.add(new TargetCredit("oschad.bank", 6, 1280, 12, false, false, 500000, Target.CAR));
        credits.add(new TargetCredit("oschad.bank", 7, 1240, 4, true, false, 10000, Target.RENOVATION));
        credits.add(new TargetCredit("privat.bank", 8, 1350, 120, true, true, 1000000, Target.MORTGAGE));
        credits.add(new TargetCredit("privat.bank", 9, 1150, 24, true, false, 500000, Target.CAR));
        credits.add(new TargetCredit("privat.bank", 10, 1240, 24, true, false, 500000, Target.STUDY));
        credits.add(new TargetCredit("privat.bank", 11, 1270, 3, true, true, 10000, Target.RENOVATION));
    }

    @Override
    public TargetCredit getCreditById(int creditId) {
        for (TargetCredit credit : credits) {
            if (credit.getId() == creditId) {
                return credit;
            }
        }
        throw new RuntimeException();
    }

    @Override
    public List<TargetCredit> getCreditsByParameters(String bankName, Target target, boolean isEarlyRepayment,
                                                     boolean isIncreaseAble) {

        ArrayList<TargetCredit> result = new ArrayList<>();

        for (TargetCredit credit : credits) {
            if (!bankName.isEmpty() && !bankName.equals(credit.getBankName())) {
                continue;
            }
            if (!target.equals(Target.ANY) && !credit.getTarget().equals(target)) {
                continue;
            }
            if (!((isEarlyRepayment && !credit.isEarlyCreditRepayment()) || (isIncreaseAble && !credit.isIncreaseCreditLine()))) {
                result.add(credit);
            }
        }
        return result;
    }
}
