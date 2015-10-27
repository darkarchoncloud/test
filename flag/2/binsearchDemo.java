Time complexity: log(n)
Space complexity: log(1)


public class binsearchDemo {

static int binary_search(int a[], int size, int target) {

   int start = 0;
   int end = size - 1;
   while (start <= end) {
        int mid = start + (end - start)/2;
        if (target == a[mid]) {
            return mid;
}
        if (target < a[mid]) {
            end = mid - 1;
}
        else {
start = mid + 1;
}

}

return -1;

}



public static void main(String[] args) {

    int a[] = {1,4,5,7,9,21};
    int size = a.length;
    int target = 6;

    int result = binary_search(a, size, target);
    if (result == -1) {
       System.out.println("Not found!");
}   else {
       System.out.println("Found! the index of the element in the array is: "+result);
}
}
}
