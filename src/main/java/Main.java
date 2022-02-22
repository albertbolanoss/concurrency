public class Main {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;

        int result = sum(x, y);
    }

    public static int sum(int a, int b) {
        int result = a + b;
        return result;
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n * factorial(n-1);
        }
    }

//    public static void main(String[] args){
//        System.out.println("Main method started");
//        int result = Main.factorial(-1);
//        System.out.println("Factorial ==>"+result);
//        System.out.println("Main method ended");
//    }
}
