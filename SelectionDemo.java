


public class SelectionDemo {

static void SelectionSort(int a[], int n) {

int global, temp;

for (int i = 0; i < n; i++) {
      global = i;
      for (int j = i+1; j < n; j++) {
            if (a[j] < a[global])
                   global = j;
      }

      temp = a[global];
      a[global] = a[i];
      a[i] = temp;
      
}
}
  

        public static void main(String[] args) {
                 
                int a[] = {1,-3, 4, 2, 6, 3, 1, 0};
                
                for(int ele : a) {
                System.out.println("The elements in a are: " + ele); }
                SelectionSort(a,a.length);
                for(int ele: a) {
                System.out.println("Now the elements are: " + ele); }

}
}
