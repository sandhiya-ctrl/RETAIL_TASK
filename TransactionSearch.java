
import java.util.Scanner;

public class TransactionSearch {

    static int linearSearch(int[] a, int key) {
        int comparisons = 0;

        for (int i = 0; i < a.length; i++) {
            comparisons++;

            if (a[i] == key) {
                System.out.println("Linear comparisons: " + comparisons);
                return i;
            }
        }

        System.out.println("Linear comparisons: " + comparisons);
        return -1;
    }

    static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;

            if (a[mid] == key) {
                System.out.println("Binary comparisons: " + comparisons);
                return mid;
            }

            if (a[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        System.out.println("Binary comparisons: " + comparisons);
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ids = new int[n];

        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        System.out.println("Linear index: " + linearSearch(ids, key));
        System.out.println("Binary index: " + binarySearch(ids, key));

        sc.close();
    }
}
