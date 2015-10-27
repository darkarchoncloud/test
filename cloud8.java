public class cloud8 {

  
  
  public int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (array[middle] == target) {
        return middle;
      } else if (array[middle] < target) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    
    	return -1;

    }
    
  


  public static void main(String[] args) {
  	cloud8 newcloud = new cloud8();
  	int[] array = new int[]{1, 2, 2, 2, 3, 4, 8};
  	int target = 5;
  	int index = newcloud.binarySearch(array, target);


  	System.out.println(index);
  }
}
