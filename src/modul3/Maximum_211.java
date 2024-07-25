package modul3;

public class Maximum_211 {
    public static void main(String[] args) {
        int[] arr = {0, 45, 78, 5, -2891, 3, 9, 4, 818, 616, 7, 0};
        int begin = 0;
        int end = arr.length-1;
        System.out.println("Maximum of the array: " + maxFromArray(arr, begin, end));
    }

    public static int maxFromArray(int[] arr, int begin, int end) {
        if (begin == end) {
            return arr[begin];
        }
        int mid = (begin+end)/2;
        int maxLeft = 0;
        int maxRight = 0;

        maxLeft = maxFromArray(arr, begin, mid);
        maxRight = maxFromArray(arr, mid+1, end);

        if (maxLeft < maxRight) {
            return maxRight;
        } else return maxLeft;
    }

}
