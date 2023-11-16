public class Thread_State {
    public static void main(String[] args) {
        TestThread thread = new TestThread();
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        while (thread.getState() != Thread.State.TERMINATED) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(thread.getState());
        }
    }
}

class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}