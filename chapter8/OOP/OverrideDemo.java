class Animal {
    public void move() {
        System.out.println("动物可以走");
    }
}

class Dog extends Animal {
    public void move() {
        //super.move(); // 应用super类的方法
        System.out.println("狗可以走和跑");
    }

    public void bark(){
       System.out.println("狗可以吠叫");
    }
}

public class OverrideDemo {

    public static void main(String args[]) {
        Animal a = new Animal();
        Animal b = new Dog();

        a.move();
        b.move();
        //b.bark();
    }
}