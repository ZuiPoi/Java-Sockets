package model;
//main to be used for testing purposes

import java.util.concurrent.ThreadLocalRandom;

public class Main implements Runnable {

	@Override
	public void run() {
		//EDIT MAX i to generate MORE villains
		for(int i = 1; i<6; i++) {
		try {
        	int n = ThreadLocalRandom.current().nextInt(1, 3 + 1);
    		Thread t1 = new Thread(new VillainGenerator());
    		t1.start();
    		t1.interrupt();
        }catch(Exception f) {
        	System.out.println("Error in villain generation");
        }
		
		}
	}

	
		
		
}

