public class Decision {
    public static void main(String[] args) {
        // if (args != null && args.length > 0) {
        //     int heroNum = Integer.parseInt(args[0]);
        //     guessHero(heroNum);
        // } else {
        guessHero(2);
        // }
    }
    public static void guessHero(int i) {
            if (i == 1) {
                System.out.println("我是钢铁侠");
            } else if (i == 2) {
                System.out.println("我是美国队长");
            } else if (i == 3) {
                System.out.println("我是浩克");
            } else {
                System.out.println("我也不知道我是谁");
            }
    }
}