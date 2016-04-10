package epamlab;

import java.util.concurrent.locks.Lock;

public class Pencil implements Runnable {
	
	Lock desk;
	

	public Pencil(Lock desk) {
		this.desk = desk;
	}


	@Override
	public void run() {
		

		try {
			desk.lock();
			for (int i = 10; i > 0; i--) {
				Thread.sleep(500);
				System.out.println("draw...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}finally {
			desk.unlock();
		}
		

	}
}
