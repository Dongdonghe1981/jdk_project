package dto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> getEmployee(){
        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1001,"张三",24));
        list.add(new Employee(1002,"张四",25));
        list.add(new Employee(1003,"张五",26));
        list.add(new Employee(1004,"张六",27));
        list.add(new Employee(1005,"张七",28));
        return list;

    }
}
