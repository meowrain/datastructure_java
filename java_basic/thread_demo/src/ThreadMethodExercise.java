public class ThreadMethodExercise {
    public static void main(String[] args) {
        for(int i = 0;i<10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i == 5) {
                ThreadExercise test = new ThreadExercise();
                Thread test1 = new Thread(test);
                test1.start();
                try {
                    test1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("hi");
        }
    }
}
class ThreadExercise implements Runnable {
    @Override
    public void run() {
        for(int i =0;i<10;i++) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
