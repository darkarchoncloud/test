public class test3 {
  public void mergeSort(int[] array) {
    if (array == null || array.length == 0) {
      return;
    }
    int[] helper = new int[array.length];
    int left = 0;
    int right = array.length - 1;
    mergeSortHelp(array, helper,left, right);
  }

  public void copyArray(int[] source, int[] dest, int left, int right) {
    
    for (int i = left; i <= right; i++) {
      dest[i] = source[i];
    }
  }

  private void mergeSortHelp(int[] array, int[] helper, int left, int right) {
    
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSortHelp(array, helper, left, mid);
    mergeSortHelp(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }


  private void merge(int[] array, int[] helper, int left, int mid, int right) {
    copyArray(array, helper, left, right);
    int index1 = left;
    int index2 = mid + 1;
    int index = left;

    while (index1 <= mid && index2 <= right) {
      if (helper[index1] <= helper[index2]) {
        array[index++] = helper[index1++];
      }
      else {
        array[index++] = helper[index2++];
      }

    }

    while (index1 <= mid) {
      array[index++] = helper[index1++];
    }

    while(index2 <= right) {
      array[index++] = helper[index2++];
    }

  }



    




  public static void main(String[] args) {
    test3 newtest = new test3();
    int[] array = new int[]{ 2, 8, 1, 3, 7, 9, 0};
    newtest.mergeSort(array);
    for (int i : array) {
      System.out.println(i);
    }
  }
}