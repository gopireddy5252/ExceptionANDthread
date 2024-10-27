package Thread1;

import java.util.Scanner;

/*
 *to Achive the multiThreading in two ways 
 *		1. extends Therad class
 *		2. implements Runnable interface
 */

class SingleRun implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        if (name.equals("Add")) {
            add();
        } else if (name.equals("Alphabet")) {
            alphabet();
        }
    }

    void add() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter first number: ");
            int a = sc.nextInt();
            System.out.println("Enter second number: ");
            int b = sc.nextInt();
            System.out.println("Sum: " + (a + b));
        }
    }

    void alphabet() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + " ");
        }
        System.out.println();  // To move to the next line after printing all alphabets
    }
}

public class SingleClass {
    public static void main(String[] args) {
        SingleRun sr = new SingleRun();
        
        Thread t1 = new Thread(sr);
        Thread t2 = new Thread(sr);
        
        t1.setName("Add");
        t2.setName("Alphabet");
        
        t1.start();
        t2.start();
    }
}
