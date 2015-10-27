//和binary search想法基本一样，区别：
//1.跳出循环条件不一样，要求LR指针相邻
//2.LR指针只能设成mid，因为mid可能就是那个元素，怕漏过去
//3.就算target=a[mid]了， 还要继续循环找左边
//4.跳出循环后比较相邻LR哪个等于target，要先看L


class firstoccurDemo {


static int binary_first_occur(int a[], int size, int target) {

     int start = 0;
     int end = size - 1;
     while (start < end - 1) {
       int mid = start + (end - start)/2;
       if (target == a[mid]) {
          end = mid;
}      else if (target < a[mid]) {
          end = mid - 1;
}      else {
          start = mid + 1;
}

}

     if (target == a[start]) {
        return start;
}    if (target == a[end]) {
        return end;
}

     return -1;
}


public static void main(String[] args) {

     int a[] = {2,4,5,5,5,5,10,32};
     int size = a.length;
     int target = 10;
     int result = binary_first_occur(a, size, target);
     if (result == -1) {
        System.out.println("Not found!");
}    else {
        System.out.println("Element found! The first occurance of the element is at index: "+result);
}
}
}
