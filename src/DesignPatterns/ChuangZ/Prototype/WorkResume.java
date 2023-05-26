package DesignPatterns.ChuangZ.Prototype;

class WorkExperience implements Cloneable { // (1) 工作经历
    private String workDate;
    private String company;

    public Object Clone() {
        WorkExperience obj = new WorkExperience(); // (2)
        obj.workDate = this.workDate;
        obj.company = this.company;
        return obj;
    }
    // 其余代码省略
}

class Resume implements Cloneable { // (3) 简历
    private String name;
    private String sex;
    private String age;
    private final WorkExperience work;

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }

    private Resume(WorkExperience work) {
        this.work = (WorkExperience) work.Clone(); // (4)
    }

    public void SetPersonInfo(String sex, String age) { /* 代码略 */ }

    public void SetWorkExperience(String workDate, String company) {/* 代码略 */}

    public Object Clone() {
        Resume obj = new Resume(this.work); // (5)
        // 其余代码省略
        return obj;
    }
}

class WorkResume {
    public static void main(String[] args) {
        Resume a = new Resume("张三");
        a.SetPersonInfo("男", "29");
        a.SetWorkExperience("1998-2000", "XXX公司");
        Resume b = (Resume) a.Clone(); // (6)
        b.SetWorkExperience("2001-2006", "YYY公司");
    }
}