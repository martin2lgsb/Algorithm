/**
 * Created by m2lgsb on 2018/9/25 11:57
 */
public class BinarySearch {

    /**
     * title:commonBinarySearch
     * @param arr 有序数组
     * @param key 待查找关键字
     * @return 关键字位置
     */
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }


    /**
     * title:recursionBinarySearch
     * @param arr 有序数组
     * @param key 待查找关键字
     * @return 关键字位置
     */
    public static int recursionBinarySearch(int[] arr, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        if (arr[middle] > key) {
            return recursionBinarySearch(arr, key, low, middle -1);
        } else if (arr[middle] < key) {
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }
    }


    public static void main(String[] args) {
        int[] arr = { 6, 12, 33, 87, 88, 90, 97, 108, 561};
        System.out.println("循环查找：" + (commonBinarySearch(arr, 12)));
        System.out.println("递归查找：" + (recursionBinarySearch(arr, 12, 0, arr.length -1)));
    }

}
