package DesignPatterns.XingW.Interpreter;
//解释器模式

import java.util.*;

public class Client {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();

        Context context = new Context();

        context.check("A区的开发人员");
        context.check("B区的调试人员");
        context.check("C区的测试人员");

        System.out.println("==========");

        context.check("D区的程序员");
        context.check("D区的测试员");
        context.check("A区的程序员");

        Long end = System.currentTimeMillis();
        Long elapsed = end - start;
        System.out.println("该段总共耗时：" + elapsed + "ms");
    }
}

class Context {
    private String[] regions = {"A区", "B区", "C区"};
    private String[] persons = {"开发人员", "测试人员", "调试人员"};

    private NonterminalExprssion nonterminal;

    public Context() {
        TerminalExpression region = new TerminalExpression(regions);
        TerminalExpression person = new TerminalExpression(persons);
        nonterminal = new NonterminalExprssion(region, person);
    }

    public void check(String info) {
        boolean bool = nonterminal.Interpret(info);
        if (bool) {
            System.out.println("识别成功");
        } else {
            System.out.println("识别失败");
        }
    }
}

//解释器
interface Expression {
    boolean Interpret(String info);
}

//非终止符解释器
class NonterminalExprssion implements Expression {
    private TerminalExpression region; //地区终结符集
    private TerminalExpression person; //人员终结符集

    public NonterminalExprssion(TerminalExpression region, TerminalExpression person) {
        this.region = region;
        this.person = person;
    }

    @Override
    public boolean Interpret(String info) {
        String[] str = info.split("的"); // B区的调试人员 --> str = {"B区", "调试人员"}

        return region.Interpret(str[0]) && person.Interpret(str[1]);
    }
}

//终止符解释器
class TerminalExpression implements Expression {
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        //for (遍历对象类型 对象名 : 遍历对象)
        for (String str : data) { // 将符号存入终结符集
            set.add(str);
        }
    }

    @Override
    public boolean Interpret(String info) {
        return set.contains(info); //判断某符号是否包含于终结符集内
    }
}
