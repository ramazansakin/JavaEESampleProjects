package com.obss.ramazansakin;

import java.math.BigDecimal;

class Chat {
	boolean flag = false;

	public synchronized void Question(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(msg);
		flag = true;
		notify();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void Answer(String msg) {
		if (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println(msg);
		flag = false;
		notify();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class T1 implements Runnable {
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	public T1(Chat m1) {
		this.m = m1;
		new Thread(this, "Question").start();
	}

	public void run() {
		for (int i = 0; i < s1.length; i++) {
			m.Question(s1[i]);
		}
	}
}

class T2 implements Runnable {
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

	public T2(Chat m2) {
		this.m = m2;
		new Thread(this, "Answer").start();
	}

	public void run() {
		for (int i = 0; i < s2.length; i++) {
			m.Answer(s2[i]);
		}
	}
}

class TestInterruptingThread1 extends Thread {
	public void run() {
		try {
			System.out.println("task");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException("Thread interrupted..." + e);
		}

	}
}

class TestInterruptingThread2 extends Thread {
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("task");
		} catch (InterruptedException e) {
			System.out.println("Exception handled " + e);
		}
		System.out.println("thread is running...");
	}
}

class Reentrant {
	public synchronized void m() {
		n();
		System.out.println("this is m() method");
	}

	public synchronized void n() {
		System.out.println("this is n() method");
	}
}

/**
 * @author rmzns
 *
 */
public class TestThread {

	public static void main(String[] args) {

		// Chat m = new Chat();
		// new T1(m);
		// new T2(m);
		// }

		// // Unhandled Interupt Schenario
		// TestInterruptingThread1 t1 = new TestInterruptingThread1();
		// t1.start();
		// try {
		// t1.interrupt();
		// } catch (Exception e) {
		// System.out.println("Exception handled " + e);
		// }
		//
		// // Sample Interupt Handling
		// TestInterruptingThread2 t2 = new TestInterruptingThread2();
		// t2.start();
		//
		// t2.interrupt();

//		final Reentrant re = new Reentrant();
//
//		Thread t1 = new Thread() {
//			public void run() {
//				re.m();// calling method of Reentrant class
//			}
//		};
//		t1.start();
		
		// Wrapper Classes
		BigDecimal a = new BigDecimal(0);
		Integer b = new Integer(0);
		String c = new String();
		Double d = new Double(0.0);

	}
}
