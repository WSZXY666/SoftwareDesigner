package DesignPatterns.ChuangZ.AbstractFactory;

import java.util.*;

class Department { /*代码省略*/
    int id;

    public Department(int id) {
        this.id = id;
    }
}

interface IDepartment {
    void Insert(Department department); // (1)

    Department GetDepartment(int id); // (2)
}

class SqlserverDepartment implements IDepartment { // (3)
    public void Insert(Department department) {
        System.out.println("Insert a record into Department in SQL Server!");
        // 其余代码省略
    }

    public Department GetDepartment(int id) {
        /*代码省略*/
        return new Department(id);
    }
}

class AccessDepartment implements IDepartment { // (4)
    public void Insert(Department department) {
        System.out.println("Insert a record into Department in ACCESS!");
        // 其余代码省略
    }

    public Department GetDepartment(int id) {
        /* 代码省略 */
        return new Department(id);
    }
}

interface IFactory { // (5)
    IDepartment CreateDepartment(); // (6)
}

class SqlServerFactory implements IFactory {
    public IDepartment CreateDepartment() {
        return new SqlserverDepartment();
    }
    // 其余代码省略
}

class AccessFactory implements IFactory {
    public IDepartment CreateDepartment() {
        return new AccessDepartment();
    }
    // 其余代码省略
}


public class Client2 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
