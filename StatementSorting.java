import java.util.Scanner;

public class StatementSorting {

    static class Transaction {
        String id, timestamp;

        Transaction(String id, String timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    static int comparisons = 0;

  
    static void insertionSort(Transaction[] a) {
        comparisons = 0;

        for (int i = 1; i < a.length; i++) {
            Transaction key = a[i];
            int j = i - 1;

            while (j >= 0) {
                comparisons++;

                if (a[j].timestamp.compareTo(key.timestamp) > 0) {
                    a[j + 1] = a[j];
                    j--;
                } else {
                    break;
                }
            }

            a[j + 1] = key;
        }
    }

  
    static void mergeSort(Transaction[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);

        Transaction[] temp = new Transaction[r - l + 1];
        int i = l, j = mid + 1, k = 0;

        while (i <= mid && j <= r) {
            comparisons++;

            if (a[i].timestamp.compareTo(a[j].timestamp) <= 0) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = a[i++];
        }

        while (j <= r) {
            temp[k++] = a[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            a[l + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Transaction[] a = new Transaction[n];

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String date = sc.next();
            String time = sc.next();

            a[i] = new Transaction(id, date + " " + time);
        }

        int choice = sc.nextInt(); 
        comparisons = 0;

        if (choice == 1) {
            insertionSort(a);
            System.out.println("Insertion Sort");
        } else if (choice == 2) {
            mergeSort(a, 0, n - 1);
            System.out.println("Merge Sort");
        } else {
            System.out.println("Invalid choice");
            sc.close();
            return;
        }

        System.out.println("Sorted transactions:");

        for (Transaction t : a) {
            System.out.println(t.id + " " + t.timestamp);
        }

        System.out.println("Comparisons: " + comparisons);

        sc.close();
    }
}