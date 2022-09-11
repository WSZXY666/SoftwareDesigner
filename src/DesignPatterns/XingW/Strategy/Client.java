package DesignPatterns.XingW.Strategy;
//策略模式

public class Client {
    public static void main(String[] args) {
        AddStrategy add = new AddStrategy();
        SubtractionStrategy subtraction = new SubtractionStrategy();
        MultiplyStrategy multiply = new MultiplyStrategy();

        OperationContext context = new OperationContext(add);
        System.out.print("两数相加：");
        context.Operation(2022,528);

        context = new OperationContext(subtraction);
        System.out.print("两数相减：");
        context.Operation(2022,528);

        context = new OperationContext(multiply);
        System.out.print("两数相乘：");
        context.Operation(2022,528);
    }
}

class OperationContext{
    private Strategy strategy;

    public OperationContext(Strategy strategy){
        this.strategy = strategy;
    }

    public void Operation(int a,int b){
        strategy.TwoNumberOperation(a,b);
    }
}

interface Strategy{
    public void TwoNumberOperation(int a,int b);
}

class AddStrategy implements Strategy{

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a + b);
    }
}

class SubtractionStrategy implements Strategy{

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a - b);
    }
}

class MultiplyStrategy implements Strategy{

    @Override
    public void TwoNumberOperation(int a, int b) {
        System.out.println(a * b);
    }
}
