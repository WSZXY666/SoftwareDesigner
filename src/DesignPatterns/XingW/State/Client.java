package DesignPatterns.XingW.State;
//状态模式

/*public class main {
    public static void main(String[] args) {
        Context context = new Context();
        System.out.println(context.getState());
        System.out.println(context.getCount());

        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());

        System.out.println(context.getState());

        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
        context.Request();
        System.out.println(context.getCount());
    }
}
class Context{
    private int count;
    private State state;

    public Context(){
        count = 3;
        state = new StateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Request(){
        state.Hadle(this);
    }
}

interface State{
    public void Hadle(Context context);
}

class StateA implements State{  //有货

    @Override
    public void Hadle(Context context) {
        int count = context.getCount();

        if(count >= 1){
            System.out.println("购买成功！");
            context.setCount(count - 1);

            if (context.getCount() == 0){
                context.setState(new StateB());
            }
        }
    }
}

class StateB implements State{  //无货

    @Override
    public void Hadle(Context context) {
        int count = context.getCount();

        if (count == 0){
            System.out.println("库存不足，购买失败，等待补货！");

            context.setCount(5);
            System.out.println("补货成功，请重新购买！");
            context.setState(new StateA());
        }
    }
}*/
public class Client {
    public static void main(String[] args) {
        Context context = new Context(); // count：3

        context.Request(); // 购买一个饮料 count = 2
        context.Request(); // 购买一个饮料 count = 1
        context.Request(); // 购买一个饮料 count = 0

        context.Request(); // 无货 等待补货 补货成功 count = 5

        context.Request(); // 购买一个饮料 count = 4
        context.Request();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
    }
}

class Context { // 贩卖机
    private int count;

    private State state;

    public Context() {
        count = 3;
        state = new StateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Request() { // 购买一个饮料
        state.Handle(this);
    }

}

interface State {
    void Handle(Context context);
}

class StateA implements State { // 有货

    @Override
    public void Handle(Context context) {
        int count = context.getCount();

        if (count >= 1) {
            System.out.print("⚪有货 购买成功！\t");
            context.setCount(count - 1);
            System.out.println("剩余数量：" + count + "个");

            if (context.getCount() == 0) {
                context.setState(new StateB());
            }
        } else {
            System.out.println("购买失败！");
        }
    }
}

class StateB implements State { // 无货

    @Override
    public void Handle(Context context) {
        int count = context.getCount();

        System.out.println("\n⚠无货 购买失败！等待补货！");

        context.setCount(5);
        System.out.println("补货成功，请重新购买！ 剩余数量：" + count + "个\n");
        context.setState(new StateA());
    }
}