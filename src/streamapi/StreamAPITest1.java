package streamapi;

import dto.Employee;
import dto.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPITest1 {
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployee();
        employees.stream().filter(e -> e.getAge()>26).forEach(System.out::println);
        System.out.println("===============");
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println("===============");
        employees.stream().skip(2).forEach(System.out::println);
        System.out.println("===============");

        employees.addAll(EmployeeData.getEmployee());
        employees.stream().distinct().forEach(System.out::println);
        System.out.println("===============");
    }

    @Test
    public void test2(){
        //ma(Function f)
        List<String> list = Arrays.asList("aa","bb","cc","dd");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        List<Employee> emptiest = EmployeeData.getEmployee();
        emptiest.stream().map(e -> e.getName().length() > 3).forEach(System.out::println);
        emptiest.stream().filter(e -> e.getName().length() > 3).forEach(System.out::println);

        //flatMap
        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);

    }
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1,3,2,4,6,5);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> emptiest = EmployeeData.getEmployee();
        emptiest.stream().sorted((e1,e2) ->
        {
            int ageValue = Integer.compare(e1.getAge(),e2.getAge());
            if (ageValue !=0 ){
                return Double.compare(e1.getId(),e2.getId());
            }else{
                return ageValue;
            }
        }).forEach(System.out::println);
    }
}
