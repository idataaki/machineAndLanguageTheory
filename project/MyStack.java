public class MyStack {

    static final int MAX = 1000;
    int top;

    int a[] = new int[MAX]; // Maximum size of Stack

    MyStack() {
        top = 0;
        a[top] = -1;
    }

    boolean isEmpty() {
        return (a[top] == -1);
    }

    boolean push(int x) {
        if (top >= (MAX - 1)) {
            return false;
        }
        else {
            a[++top] = x;
            return true;
        }
    }

    int pop() {
        if (top < 1) {
            return -1;
        }
        else {
            int x = a[top--];
            return x;
        }
    }

}
