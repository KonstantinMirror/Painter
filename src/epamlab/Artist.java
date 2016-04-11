package epamlab;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Artist {

	public void peintAndErase() {
		Lock desk = new ReentrantLock();
		System.out.println("Start");
		Thread eraser = new Thread(new Eraser(desk));
		Thread pencil = new Thread(new Pencil(desk));
		eraser.start();
		pencil.start();
		try {
			eraser.join();
			pencil.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
