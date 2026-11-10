import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateDetection {

    static class Transaction {
        String account, merchant;
        int amount;
        long time;

        Transaction(String account, int amount,
                    String merchant, long time) {
            this.account = account;
            this.amount = amount;
            this.merchant = merchant;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Transaction> map = new HashMap<>();

        int comparisons = 0;
        int duplicates = 0;

        for (int i = 0; i < n; i++) {
            String account = sc.next();
            int amount = sc.nextInt();
            String merchant = sc.next();
            long time = sc.nextLong();

            String key = account + "|" + amount + "|" + merchant;

            comparisons++; 

            if (map.containsKey(key)) {
                Transaction previous = map.get(key);

                comparisons++; // Compare timestamps

                if (Math.abs(time - previous.time) <= 60) {
                    System.out.println("Duplicate transaction: "
                                       + account + " " + amount
                                       + " " + merchant);
                    duplicates++;
                }
            }

           
            if (!map.containsKey(key) ||
                time > map.get(key).time) {
                map.put(key,
                    new Transaction(account, amount, merchant, time));
            }
        }

        System.out.println("Total duplicates: " + duplicates);
        System.out.println("Comparisons: " + comparisons);

        sc.close();
    }
}