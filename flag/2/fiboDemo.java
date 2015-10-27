Time complexity: O(2^n)
Space complexity: O(n)


public class fiboDemo {


   static int fibo(int n) {


        if (n == 0) {
            return 0;
    }
        else if (n == 1) {
            return 1;
    } 
        return fibo(n-1) + fibo(n-2);
}





    public static void main(String[] args) {



     int n = 6;
     int result = fibo(n);
     System.out.println("The result is: "+result);

}


}         
