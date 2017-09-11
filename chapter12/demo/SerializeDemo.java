import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person("张三", 24, Gender.MALE, 8000);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = -23098098347887096L;
    private String name = null;
    private Integer age = null;

    private Gender gender = null;
    //private Integer salary;
    private transient Integer salary;

    public Person() {
        System.out.println("无参数构造函数");
    }

    public Person(String name, Integer age, Gender gender, Integer salary) {
        System.out.println("有参数构造函数");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + ", " + salary + "]";
    }
}

enum Gender {
    MALE,
    FEMALE
}