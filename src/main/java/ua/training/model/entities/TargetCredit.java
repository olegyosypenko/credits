package ua.training.model.entities;


import java.util.ResourceBundle;

public class TargetCredit {


    private int id;
    private int interestRate;
    private int creditTerm;
    private boolean increaseCreditLine;
    private boolean earlyCreditRepayment;
    private int creditLine;
    private Target target;
    private String bankNameCode;

    public TargetCredit(String bankName, int id, int interestRate, int creditTerm, boolean increaseCreditLine,
                        boolean earlyCreditRepayment, int creditLine, Target target) {
        this.bankNameCode = bankName;
        this.id = id;
        this.interestRate = interestRate;
        this.creditTerm = creditTerm;
        this.increaseCreditLine = increaseCreditLine;
        this.earlyCreditRepayment = earlyCreditRepayment;
        this.creditLine = creditLine;
        this.target = target;
    }
    public String getBankName() {
        ResourceBundle bundle = ResourceBundle.getBundle("labels");
        return bundle.getString(bankNameCode);
    }
    public int getId() {
        return id;
    }
    public double getInterestRate() {
        return interestRate / 100.0;
    }
    
    public int getIntRate() {
        return interestRate;
    }
            
    public int getCreditTerm() {
        return creditTerm;
    }

    public boolean isIncreaseCreditLine() {
        return increaseCreditLine;
    }

    public boolean isEarlyCreditRepayment() {
        return earlyCreditRepayment;
    }

    public int getCreditLine() {
        return creditLine;
    }

    public Target getTarget() {
        return target;
    }
}
