import java.util.Scanner;

public class TransactionMinMax {

    static int comparisons = 0;

   
    static void bruteForce(int[] a) {
        int min = a[0];
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            comparisons++;
            if (a[i] < min) {
                min = a[i];
            }

            comparisons++;
            if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Brute Force Min: " + min);
        System.out.println("Brute Force Max: " + max);
        System.out.println("Brute Force Comparisons: " + comparisons);
    }

    
    static int[] divideAndConquer(int[] a, int low, int high) {
        if (low == high) {
            return new int[]{a[low], a[low]};
        }

        if (high == low + 1) {
            comparisons++;

            if (a[low] < a[high]) {
                return new int[]{a[low], a[high]};
            } else {
                return new int[]{a[high], a[low]};
            }
        }

        int mid = low + (high - low) / 2;

        int[] left = divideAndConquer(a, low, mid);
        int[] right = divideAndConquer(a, mid + 1, high);

        comparisons++;
        int min = Math.min(left[0], right[0]);

        comparisons++;
        int max = Math.max(left[1], right[1]);

        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid size");
            sc.close();
            return;
        }

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        comparisons = 0;
        bruteForce(a);

        comparisons = 0;
        int[] result = divideAndConquer(a, 0, n - 1);

        System.out.println("Divide and Conquer Min: " + result[0]);
        System.out.println("Divide and Conquer Max: " + result[1]);
        System.out.println("Divide and Conquer Comparisons: " + comparisons);

        sc.close();
    }
}
