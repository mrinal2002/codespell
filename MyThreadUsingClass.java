class MyClass extends Thread {
    int sum;
    int start;
    int end;

    public void run() {
        for (int i = start; i <= end; i++) {
            sum += i;
        }
    }

    int getsum() {
        return this.sum;
    }

    MyClass(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MyThreadUsingClass {
    public static void main(String args[]) {
        MyClass t0 = new MyClass(1, 500);
        t0.start();
        MyClass t1 = new MyClass(501, 1000);
        t1.start();
        try {
            t0.join();
            t1.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(t0.getsum() + t1.getsum());
    }
}
