package ua.training.model.service;

import ua.training.model.entities.Target;
import ua.training.model.entities.TargetCredit;

import java.util.List;

public interface CreditService {
    TargetCredit getCreditById(int creditId);
    List<TargetCredit> getCreditsByParameters(String bankName, Target target, boolean isEarlyRepayment,
                                              boolean isIncreaseAble);
}
