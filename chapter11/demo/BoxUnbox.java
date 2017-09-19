public class BoxUnbox {
    public static void main(String[] args){
        Integer i = 10; //装箱
        int index = i;  //拆箱
    }
}

//javap -c BoxUnbox.class






















/*
从反编译得到的字节码内容可以看出，在装箱的时候自动调用的是Integer的valueOf(int)方法。而在拆箱的时候自动调用的是Integer的intValue方法。

装箱过程是通过调用包装器的valueOf方法实现的，而拆箱过程是通过调用包装器的xxxValue方法实现的。（xxx代表对应的基本数据类型）。
*/