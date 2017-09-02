public class Polymorphism {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Cat();
        animals[1] = new Dog();
        // show(new Cat()); // 以 Cat 对象调用 show 方法
        // show(new Dog()); // 以 Dog 对象调用 show 方法
        for (Animal a : animals) {
            a.eat();
            a.work();
        }
        Animal a = new Cat(); // 向上转型  
        a.eat(); // 调用的是 Cat 的 eat
        Cat c = (Cat) a; // 向下转型  
        c.work(); // 调用的是 Cat 的 work

        // 如果？
        Dog d = (Dog) a;
        d.work();
    }

    public static void show(Animal a) {
        a.eat();
        // 类型判断
        if (a instanceof Cat) { // 猫做的事情 
            Cat c = (Cat) a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情 
            Dog c = (Dog) a;
            c.work();
        }
    }
}

abstract class Animal {
    abstract void eat();
    abstract void work();
}

class Cat extends Animal {
    public void eat() {
        System.out.println("Cat吃鱼");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("Dog吃骨头");
    }
    public void work() {
        System.out.println("Dog看家");
    }
}