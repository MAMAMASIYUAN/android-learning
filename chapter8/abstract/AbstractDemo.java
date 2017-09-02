public class AbstractDemo {
    // public static void main(String[] args) {
    //     /* 以下是不允许的，会引发错误 */
    //     Employee e = new Employee("George W.", "Houston, TX", 43);

    //     System.out.println("\n Call mailCheck using Employee reference--");
    //     e.mailCheck();
    // }

    public static void main(String[] args) {
        Salary s = new Salary("王二", "长沙", 3, 360000.00);
        Employee e = new Salary("李四", "张家口", 2, 240000.00);

        System.out.println("2. 调用Salary类型的mailCheck方法");
        s.mailCheck();

        System.out.println("3. 调用Employee类型的mailCheck方法");
        e.mailCheck();
    }
}

class Salary extends Employee {
    // 年薪
    private double salary; 

    public Salary(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }
    public void mailCheck() {
        System.out.println("4. Salary类的mailCheck方法");
        System.out.println("5. 邮寄支票给" + getName() +
            "，年薪是" + salary);
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }
    public double computePay() {
        System.out.println("6. 计算" + getName() + "的周工资");
        return salary / 52;
    }
}


abstract class Employee {
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number) {
        System.out.println("1. 构造Employee类");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public double computePay() {
        System.out.println("Employee类的computePay");
        return 0.0;
    }
    public void mailCheck() {
        System.out.println("邮寄支票给" + this.name +
            "， 地址是" + this.address);
    }
    public String toString() {
        return name + " " + address + " " + number;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String newAddress) {
        address = newAddress;
    }
    public int getNumber() {
        return number;
    }
}