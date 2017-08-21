public class searchNumber {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            int oriNum = Integer.parseInt(args[0]);
            searchNumber(oriNum);
         } else {
        //guessHero(2);
        }
    }
    public static void searchNumber(int i) {
        int j;
		//System.out.println(i);
        for(j = 1; j < i; j++){
			if(j%15 == 0){
				System.out.println("input ="+ i + " 其中 " + j + " 是 15 的倍数");
			}else if(j % 3 == 0 && j % 5 != 0){
				System.out.println("input ="+ i + " 其中 " + j + " 是 3 的倍数");
			}else if(j % 5 == 0 && j % 3 != 0){
				System.out.println("input ="+ i + " 其中 " + j + " 是 5 的倍数");
			}
				
			
		

        }
	
    }
}