1. 定义
    //常量数组int[][][] arrs = new int[3][2][1];
    val arrs = Array(3) { Array(2) { IntArray(1) } }
    //空安全变量
    var str: String = "hello"
    var str1 = "word"
    //可为空字符串变量
    var str2: String? = null

2. 条件
    // 测试值 x = 0, -1, 1, 2, 3, 6, 10
    var x = 10
    when (x) {
        //常量
        2 -> println("等于2")
        //数值表达式
        if (x > 0) 1 else -1 -> println("大于0并等于1，或小于0并等于-1")
        //Boolean类型表达式
        in 1..5 -> println("范围匹配1-5")
        !in 6..9 -> println("不是6-9")
        is Int -> println("类型判断")
        else -> println("else")
    }
    // 代替if...else if
    when{
        x > 6 && x <= 10  ->  println("大于6小于等于10")
        x < 6 -> println("小于6")
        else -> println("else")
    }

3). 循环
    val list = arrayListOf("aa", "bb", "cc")
    //递增for (int i = 0; i < list.size(); i++)
    for (i in list.indices) {
        print(list[i])
    }
    //递增for (int i = 2; i < list.size(); i++)
    for (i in 2..list.size-1) {
        print(list[i])
    }
    for (int i = 0; i < list.size(); i++) {
        ...
    }
    //递减for (int i = list.size() - 1; i >= 0; i--)
    for (i in list.size - 1 downTo 0) {
        print(list[i])
    }
    //操作列表内的对象
    for (item in list) {
        print(item)
    }
    //加强版
    for（（i， item） in list.witnIndex()） {
        print(list[i])
        print(item)
    }
    //变种版
    list.forEach {
        print(it)
    }

    list.forEachIndexed { i, s ->
        print(list[i])
        print(s)
    }

    list.forEachIndexed(object :(Int,String) -> Unit{
        override fun invoke(i: Int, s: String) {
            print(list[i])
            print(s)
        }
    })

4. 冒号
    //val表示常量var表示变量声明
    val name: String = "Kotlin" 
    //省略类型说明
    var age = "23"
    //fun表示函数
    fun getName(): String{
        return "Kotlin"
    }
    //类继承
    class UserList<E>(): ArrayList<E>() {
        //...
    }

    val intent = Intent(this, MainActivity::class.java)


5. ...