class kthclosestDemo {



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



static int binary_kthclosest(int a[], int size, int k, int target) {

    int start = 0;
    int end = size - 1;
    int result = binary_closest(a, size, target);
    if (k == 0) {
        return -1;
}   else if (k > size) {    
        return -2;
}   else if (k == 1) {
        return result;
}

    int left, right, dis1, dis2, tmpk;
    left = result - 1;
    right = result + 1;
    tmpk = k - 1;

    while (tmpk > 0 && left >= 0 && right <= size - 1) {
      dis1 = Math.abs(target - a[left]);
      dis2 = Math.abs(target - a[right]);
      if (dis1 < dis2) {
         left = left - 1;
           if (left >= -1) {
             result = left + 1;
}
}     else {
         right = right + 1;
           if (right <= size) {
                result = right - 1;
}
}
         

      tmpk--;
}


   if (tmpk == 0) {
      return result;
}  else if (left < 0) {
          return right + tmpk - 1;
}  else {
          return left - tmpk + 1;
}

}
      

public static void main(String[] args) {

    int a[] = {1,2,4,7,9,21,30,47,69,101};
    int size = a.length;
    int target = 25;
    for (int k = 0; k <= a.length + 1; k++)   {

       int result = binary_kthclosest(a, size, k, target);
       if (result == -1) {
          System.out.println("Invalid input! k can not be zero! ");
}      else if (result == -2) {
          System.out.println("There are only " + size + " elements in the array!");
}      else {
          System.out.println("The "+ k +"th closest element to " + target + " has index: " + result);
}
}
}
}
    





    