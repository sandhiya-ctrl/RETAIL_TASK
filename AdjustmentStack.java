import java.util.Scanner;

public class AdjustmentStack {
    static int[] stack = new int[5];
    static int top = -1;
    static int operations = 0;

    static void push(int value) {
        operations++;

        if (top == stack.length - 1) {
            System.out.println("Stack is full");
            return;
        }

        stack[++top] = value;
        System.out.println("Pushed: " + value);
    }

    static void pop() {
        operations++;

        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Reversed adjustment: " + stack[top--]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        push(sc.nextInt());
        push(sc.nextInt());
        push(sc.nextInt());

        pop();
        pop();

        System.out.println("Operations: " + operations);

        sc.close();
    }
}