import java.util.Scanner;

public class ReviewQueue {
    static int[] queue = new int[5];
    static int front = 0, rear = -1;
    static int operations = 0;

    static void enqueue(int value) {
        operations++;

        if (rear == queue.length - 1) {
            System.out.println("Queue is full");
            return;
        }

        queue[++rear] = value;
        System.out.println("Added: " + value);
    }

    static void dequeue() {
        operations++;

        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Reviewed: " + queue[front++]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        enqueue(sc.nextInt());
        enqueue(sc.nextInt());
        enqueue(sc.nextInt());

        dequeue();
        dequeue();

        System.out.println("Operations: " + operations);

        sc.close();
    }
}