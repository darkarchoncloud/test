public class test7 {
  public void quickSort(int[] array) {
    // Write your solution here
    if (array == null) {
      return;
    }
    quickSort(array, 0, array.length - 1);
  }
  
  public void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int pivotIndex = partition(array, left, right);
    quickSort(array, left, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, right);
   
    
  }
  
  public int partition(int[] array, int left, int right) {
    
    int pivotIndex = pivotFind(left, right);
    int pivot = array[pivotIndex];
    
    swap(array, pivotIndex, right);


    
    int i = left, j = right - 1;
    
    while (i <= j) {
      if (array[i] < pivot) {
        i++;
      } else {
        swap(array, i, j--);
      }
    }
    swap(array, i, right);
    return i;
  }
  
  public int pivotFind(int left, int right) {
    return left + (int)(Math.random() * (right - left + 1));
  }
  
  private void swap(int[] array, int left, int right) {
    int temp;
    temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

  public static void main(String[] args) {
  	test7 newtest = new test7();
  	int[] array = new int[] { 5,1,3,2,4};
  	newtest.quickSort(array);
  	for (int i : array) {
  		System.out.println(i);
  	}
  }
  
  
}