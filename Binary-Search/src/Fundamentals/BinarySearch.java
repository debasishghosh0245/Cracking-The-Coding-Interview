package Fundamentals;

class BinarySearch {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    int target = 4;
    System.out.println(search(arr, target, 0, arr.length - 1));
  }

  public static int search(int[] arr, int target, int left, int right) {
    if (arr == null || arr.length == 0)
      return -1;
    if (left > right)
      return -1;
    int mid = left + (right - left) / 2; 
    if (arr[mid] == target)
      return mid; 
    if (arr[mid] > target) { 
      return search(arr, target, left, mid - 1);
    } else {
      return search(arr, target, mid + 1, right); 
    }
  }
}
