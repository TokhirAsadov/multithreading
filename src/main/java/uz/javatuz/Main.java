package uz.javatuz;



class MyThreadWithName3 extends Thread{
    public MyThreadWithName3(String name) {
        setName(name);
    }

    @Override
    public void run() {
        System.out.println("Thread name: "+getName());
    }
}

class MyThread extends Thread{

    @Override
    public void run() {
//        throw new RuntimeException("Thread exception");
        System.out.println(Thread.currentThread().getName()+" ishga tushdi");
//        for (int i = 0; i < 3; i++) {
//            System.out.println("Thread ishga tushdi: "+i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException("Thread interrupted");
//            }
//        }

    }
}

class MyNotDaemonThread extends Thread{

    @Override
    public void run() {
        while (true){
            System.out.println("Mening daemon bulmagan threadim ishlayapdi");
        }
    }
}





public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler((t,e) -> {

            System.out.println(t.getName()+" default ushlandi "+e.getMessage());
        });

        UncaughtExceptionThread runnable = new UncaughtExceptionThread();
        UncaughtExceptionThread runnable2 = new UncaughtExceptionThread();

        Thread thread1 = new Thread(runnable,"UncaughtExceptionThreadByDefault");
        Thread thread2 = new Thread(runnable,"UncaughtExceptionThread");

        thread2.setUncaughtExceptionHandler((t,e) -> {
            System.out.println(t.getName()+" shu threadda xatolik bor "+e.getMessage());
        });


        thread1.start();
        thread2.start();

//        MyRunnableThreadForNaming runnableThreadForNaming = new MyRunnableThreadForNaming();
//        MyRunnableThreadForNaming runnableThreadForNaming2 = new MyRunnableThreadForNaming();
//
//        Thread thread = new Thread(runnableThreadForNaming,"AuthThread");
//        Thread thread2 = new Thread(runnableThreadForNaming2,"OrderServiceThread");
//
//        thread.start();
//        thread2.start();
//
//        Thread.sleep(1000);
//        thread.interrupt();


//        Runnable runnable = () -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().getName()+" ishga tushdi: " + i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    System.out.println("Thread interrupted");
//                }
//            }
//        };
//
//        Thread thread = new Thread(runnable,"NameOfRunnable");
//        Thread thread2 = new Thread(runnable,"NameOfRunnable");
//
//        thread.start();
//        thread2.start();

//        MyThreadWithName3 thread1 = new MyThreadWithName3("LoaderThread");
//        MyThreadWithName3 thread2 = new MyThreadWithName3("LoggingThread");

//        MyThread thread1 = new MyThread();
//        MyThread thread2 = new MyThread();
//        MyThread thread3 = new MyThread();
//        MyThread thread4 = new MyThread();
//        MyThread thread5 = new MyThread();
//
//        thread1.setName("yangi nome berildi");
//        thread2.setName("yangi nome berildi2");
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();






//        MyNotDaemonThread myNotDaemonThread = new MyNotDaemonThread();
//        myNotDaemonThread.setDaemon(true);
//        myNotDaemonThread.start();


//        Thread.sleep(10);
//        System.out.println("Main thread tuxtadi.");


//
//        Thread.sleep(2000);
//        thread.interrupt();
//        thread.stop();









//        Thread thread = new Thread();
//        System.out.println("Thread state: "+thread.getState());
//        thread.start();
//        System.out.println("Thread state: "+thread.getState());
//
//        Thread.sleep(1000);
//        System.out.println("Thread state: "+thread.getState());


//        Thread current = Thread.currentThread();
//        System.out.println("Main thread name: "+current.getName());
//        MyThreadWithRunnable runnable = new MyThreadWithRunnable();
//        Thread thread1 = new Thread(runnable);
//        MyThreadWithRunnable runnable2 = new MyThreadWithRunnable();
//        Thread thread2 = new Thread(runnable2);
//
//        thread1.start();
//        thread2.start();





        // getName() and setName()
//        MyThreadWithRunnable runnable = new MyThreadWithRunnable();
//        Thread thread1 = new Thread(runnable);
//        thread1.setName("Azizbekning threadiman");
//        MyThreadWithRunnable runnable2 = new MyThreadWithRunnable();
//        Thread thread2 = new Thread(runnable2);
//        thread2.setName("qandaydir thread");
//
//        thread1.start();
//        thread2.start();
//
//        System.out.println("thread1 -> "+thread1.getName());
//        thread1.interrupt();
//
//        System.out.println("Thread name ^^^: "+Thread.currentThread().getName());







        // isAlive()
//        Thread.sleep(500);
//        System.out.println("Thread1 isAlive: "+thread1.isAlive());
//
//        Thread.sleep(2000);
//        System.out.println("Thread2 isAlive: "+thread2.isAlive());


        // setPriority() 1 - 10 oralig'ida bo'ladi
        // getPriority()
//        thread1.setPriority(10);
//
//        System.out.println("1 -> "+thread1.getPriority());
//        System.out.println("2-> "+thread2.getPriority());



        // join() methodi threadni tugatishini kuting
//        thread1.join();
//        thread2.join();

//        System.out.println("Main thread ishlayapdi");

// interrupt()
//        thread.interrupt();
//        System.out.println(thread.isInterrupted());



//        MyThreadWith myThreadWith1 = new MyThreadWith();
//        MyThreadWith myThreadWith2 = new MyThreadWith();
//        myThreadWith1.start();
//        myThreadWith2.start();

//        MyThreadWithRunnable runnable = new MyThreadWithRunnable();
//        Thread thread = new Thread(runnable);
//        thread.start();

        // 3.1-variant
//        Thread threadWithLambda = new Thread(()->{
//            System.out.println("Lambda Thread ishga tushdi");
//        });
//        threadWithLambda.start();

        // 3.2-variant
//        Runnable runnable = ()->{
//            System.out.println("Lambda Thread ishga tushdi runnable");
//        };
//        Thread thread = new Thread(runnable);
//        thread.start();








    }
}


class MyThreadWithName2 extends Thread{

    MyThreadWithName2(String name){
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        System.out.println("Thread2 name:"+ Thread.currentThread());
    }
}

class MyThreadWithName implements Runnable{

    MyThreadWithName(String name){
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        System.out.println("Thread name:"+ Thread.currentThread().getName());
    }
}


// 2-variant
class MyThreadWithRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" ishga tushdi: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//                Thread.interrupted();
                System.out.println("Thread interrupted");
            }
        }
    }

}













// 1-variant tavsiya etilmagan
class MyThreadWith extends Thread {

    static void increment(){
        for (int i=0; i<10; i++) {
            System.out.println("Thread ishga tushdi: " + i);
        }
    }

    @Override
    public void run() {
        // barcha logika yoziladi thread bajarishi kerak bulgan
       increment();
    }

}