# java8新特性
## default关键字
* 默认方法，接口方法的默认实现
* 静态方法，接口里可以定义静态方法

`public interface Animal {

    void run();
    void eat();
    default void breath(){
        System.out.println("使用氧气呼吸");
    }
    static void test(){
        System.out.println("测试方法");
    }
}

使用场景，接口里面定义公用的业务逻辑，抽取出来，每个子类都必须具备
base64加解密API
什么是base64编码
是网络上最常见的用于传输8bit字节码的编码方式之一，是一种基于64个可打印字符（A-Z,a-z,0-9,+,/）来表示二进制数据的方法，
Java8之前使用sun.misc下的BASE64Encoder和BASE64Decoder两个类。效率低
Java8之后新增了java.util.Base64的类
  Base64.Encoder encoder = Base64.getEncoder();
  Base64.Decoder decoder = Base64.getDecoder();
时间日期处理类
Java8之前：Java.util.Date是非线程安全的。
Java8之后
A.	新增了很多常见的api，如日期时间的比较、加减、格式化等。
B.	包所在的位置java.time
C.	核心类
LocalDate：不包含具体时间的日期
LocalTime：不含日期的时间
LocalDateTime：包含了日期和时间
日期格式化
Java8之前：SimpleDateFormat不是线程安全的
Java8之后：DateTimeFormatter 是线程安全的
 LocalDate today = LocalDate.parse("2019-12-01");
 DateTimeFormatter dftDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 dftDate.format(today);

 LocalDateTime time = LocalDateTime.of(2019,12,11,14,12,11);
 DateTimeFormatter dftTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 dftTime.format(time);

Lambda表达式
例子：(o1,o2) -> Integer.compare(o1,o2)
格式：-> :Lambda操作符
	  ->左边：Lambda形参列表（接口中的抽象方法的形参列表）
	  ->右边：Lambda体（重写的抽象方法的方法体）
Lambda表达式的本质：创建函数式接口（@FunctionInterface）的实例，所以lambda表达式左边的方法名可以省略，只要保留参数名和方法体
函数式接口：如果一个接口只声明了一个抽象方法，则该接口就称为函数式接口。
Lambda表达式的使用：分6种情况
1.	无参，无返回值
Runnable r = () -> System.out.println(””);
2.	需要一个参数，但无返回值
Consumer<String> con = (String s) -> System.out.println(s);
3.	数据类型可以省略，因为可以由编译器推断出，称为“类型推断”
	Consumer<String> con = (s) -> System.out.println(s);
4.	若只需要一个参数时，参数的小括号可以省略
Consumer<String> con = s-> System.out.println(s);
5.	需要两个或两个以上参数，多条执行语句，并且可以有返回值
Comparator<Integer> com = (x,y) ->{
System.out.println(“”);
Return Integer.compare(x,y);
}
6.	只有一条语句时，return与大括号可以省略
Comparator<Integer> com = (x,y) -> Integer.compare(x,y);
总结：->左边：Lambda形参的参数类型可以省略，只有一个参数的时候，()括号可以省略
->右边：Lambda体应该使用一对{}，只有一条语句的话(可能是return语句)，可以省略{}和return关键字。

函数式接口
Java不但支持OOP（面向对象），还可以支持OOF（面向函数式）
以前使用匿名实现类表示的，现在都可以用Lambda表达式来写
Java内置的函数式接口
Consumer<T>消费型接口 void accept(T t)
Supplier<T> 供给型接口 T get()
Function<T,R>  函数型接口 R apply(T t)
Predicate<T>  断定型接口 boolean test（T t）

    @Test
    public void test(){
        happyTime(500.0,aDouble -> System.out.println("consume money:"+aDouble));
    }
    public void happyTime (Double money, Consumer<Double> con){
        con.accept(money);
    }
方法引用
1.	使用场景
当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
2.	方法引用
本质上就是Lambda表达式，而Lambda表达式创建函数式接口的实例，所以方法引用也是函数式接口的实例。
3.	方法引用的使用要求
要求接口中的抽象方法的形参列表和返回值类型，与方法引用的形参列表和返回值类型相同。
4.	使用格式
类（或对象）：：方法名
1)	对象：：非静态方法
Consumer<String> con = str -> System.out.println(str);
con.accept("lambda");

Consumer<String> con2 = System.out :: println;
    con2.accept("method ref");
2)	类：：静态方法
Comparator<Integer> com = (i1,i2) -> Integer.compare(i1,i2);
System.out.println(com.compare(1,2));

Comparator<Integer> com2 = Integer::compare;
    System.out.println(com2.compare(1,2));
3)	类：：非静态方法
Comparator<String> com = (s1,s2) -> s1.compareTo(s2);
System.out.println(com.compare("ab","ac"));

Comparator<String> com2 = String::compareTo;
System.out.println(com2.compare("ad","ac"));

构造器引用
Stream API
使用StreamAPI对集合数据进行操作，类似于用SQL对数据库进行查询。
Collection集合是存储数据，Stream是计算数据。
Collection是与内存交互，Stream与CPU交互。
注意
1.	Stream不存储数据
2.	Stream不改变源对象，会返回一个持有结果的新Stream
3.	Stream操作是延迟执行的，这意味着要等到需要结果的时候才执行。
Stream操作的三个步骤
1.	创建对象
一个数据源（集合、数组），获取一个流
2.	中间操作
一个中间操作链，对数据源的数据进行处理（过滤、映射。。。）
3.	终止操作（终端操作）
一旦执行终止操作，就执行中间操作链，并产生结果，之后不会再被使用





Stream创建对象方式
1.	通过集合
List<Employee> employees = EmployeeData.getEmployee();
//串行流 default Stream<E> stream()
Stream<Employee> stream = employees.stream();
//并行流 default Stream<E> parallelStream()
Stream<Employee> employeeStream = employees.parallelStream();
2.	通过数组
Arrays的静态方法stream()，可以获取数组流
static<T> Stream<T> stream(T[] array)：返回一个流
Employee[] employees = (Employee[]) EmployeeData.getEmployee().toArray();
Stream<Employee> stream = Arrays.stream(employees);
3.	通过Stream的of()
Stream<List<Employee>> employee = Stream.of(EmployeeData.getEmployee());
4.	创建无限流 Stream.iterate()、Stream.generate()
//遍历前10个偶数
Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);
//生成10个随机数
Stream.generate(Math::random).limit(10).forEach(System.out::println);

Stream的中间操作
1.	筛选与切片
1)	filter(Predicate p) 接收Lambda，从流中排除某些元素
List<Employee> employees = EmployeeData.getEmployee();
employees.stream().filter(e -> e.getAge()>26).forEach(System.out::println);
2)	limit(n) 截断流，使其元素不超过给定数量
employees.stream().limit(3).forEach(System.out::println);
3)	skip(n) 跳过元素，返回一个去掉前n个元素的流，若流中元素不足n个，返回null
employees.stream().skip(2).forEach(System.out::println);
4)	distinct() 筛选，通过流所生成的hashCode()和equals()去除重复元素
employees.stream().distinct().forEach(System.out::println);
2.	映射
1)	map接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
List<String> list = Arrays.asList("aa","bb","cc","dd");
list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

2)	flatmap接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
3.	排序
1)	sorted产生一个新的流，其中按照自然顺序排序
List<Integer> list = Arrays.asList(1,3,2,4,6,5);
    list.stream().sorted().forEach(System.out::println);
2)	sorted(Comparator com) 产生一个新的流，其中按照比较器顺序排序
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
4.	匹配与查找
1)	allMatch(Predicate p) 查找是否匹配所有元素
boolean b = emptiest.stream().allMatch(e -> e.getAge() > 24);

2)	anyMatch(Predicate p) 查找是否至少匹配一个元素
3)	noneMatch(Predicate p) 查找是否没有匹配所有元素
4)	findFirst() 返回第一个元素
5)	findAny() 返回当前流中的任意元素
6)	count() 返回流中元素总数
emptiest.stream().filter(e -> e.getAge() > 24).count();
7)	max(Comparator c) 返回流中最大值
Stream<Integer> integerStream = emptiest.stream().map(e -> e.getAge());
System.out.println(integerStream.max(Integer::compareTo));
8)	min(Comparator c) 返回流中最小值
Optional<Employee> min = emptiest.stream().min((e1, e2) 
-> Integer.compare(e1.getAge(), e2.getAge()));
9)	forEach(Consumer c)
5.	规约
1)	reduce(T iden,BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回T，第一个参数是初始值
List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
list.stream().reduce(0,Integer::sum);
2)	reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值，返回Optional<T>
6.	收集
collect(Collector c) 
将流转换为其他形式（List、Map等），接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
List<Employee> emptiest = EmployeeData.getEmployee();
List<Employee> list = emptiest.stream().filter(e -> e.getAge() > 25)
.collect(Collectors.toList());
 
 
Optional类
为了避免空指针异常，java8引入Optional类
Optional类是一个容器类，
ofNullable(T t)
orElse(T t)
