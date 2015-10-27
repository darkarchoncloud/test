//Time complexity O(logb)
//要是普通循环算一个一个乘是O(b)

public class apowbDemo {

    static int a_power_b(int a, int b) {

     if (b == 0) {
       return 1;
}    else if (b == 1) {
       return a;
}

     int half_result = a_power_b(a, b/2);

     if (b % 2 == 0) {
        return half_result * half_result;
}

     else {
        return half_result * half_result * a;
}

}

    public static void main(String[] args) {



       int a = 2;
       int b = 8;
int result = a_power_b(a,b);
System.out.println("The result is: " + result);
}

}


  