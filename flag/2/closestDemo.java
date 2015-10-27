class closestDemo {





static int binary_closest(int a[], int size, int target) {

    int start = 0;
    int end = size - 1;
    while (start < end - 1) {
      int mid = start + (end - start)/2;
      if (target == a[mid]) {
          return mid;
}     else if (target < a[mid]) {
          end = mid;
}     else {
          start = mid;
}
}

    int ldif = Math.abs(target - a[start]);
    int rdif = Math.abs(target - a[end]);
    if (ldif < rdif) {
        return start;
}   else {
        return end;
}
}

public static void main(String[] args) {

      int a[] = {1,2,3,8,9,21};
      int size = a.length;
      int target = 7;
      int result = binary_closest(a,size,target);
      System.out.println("The closest element in the array to the target number has index: "+result);
}
}

    