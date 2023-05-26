package DesignPatterns.XingW.Strategy;

import static DesignPatterns.XingW.Strategy.TYPE.CASH_DISCOUNT;

enum TYPE {NORMAL, CASH_DISCOUNT, CASH_RETURN};

interface CashSuper {
    public double acceptCash(double money); // (1)
}

class CashNormal implements CashSuper { // 正常收费子类
    public double acceptCash(double money) {
        return money;
    }
}


class CashDiscount implements CashSuper {
    private final double moneyDiscount; // 折扣率

    public CashDiscount(double moneyDiscount) {
        this.moneyDiscount = moneyDiscount;
    }

    public double acceptCash(double money) {
        return money * moneyDiscount;
    }
}

class CashReturn implements CashSuper { // 满额返利
    private final double moneyCondition;
    private final double moneyReturn;

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition; // 满额数额
        this.moneyReturn = moneyReturn; // 返利数额
    }

    public double acceptCash(double money) {
        double result = money;
        if (money >= moneyCondition) {
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}

class CashContext {
    private CashSuper cs;
    private TYPE t;

    public CashContext(TYPE t) {
        switch (t) {
            case NORMAL: // 正常收费
                cs = new CashNormal(); // (2)
                break;
            case CASH_DISCOUNT: // 打8折
                cs = new CashDiscount(0.8); // (3)
                break;
            case CASH_RETURN: // 满300返100
                cs = new CashReturn(300, 100); // (4)
                break;
        }
    }

    public double GetResult(double money) {
        return cs.acceptCash(money); // (5)
    }
}

public class Client2 {
    public static void main(String[] args) {
        CashContext cashContext = new CashContext(CASH_DISCOUNT);
        System.out.println(cashContext.GetResult(500));
    }
}