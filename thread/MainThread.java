package thread;

import model.Main;
import model.Watcher;
import sockets.Client;
import sockets.Server;
import view.GUI;

public class MainThread {


	public static void main(String[] args) throws InterruptedException {

		Thread t3 = new Thread(new GUI());//villain generator
		

        t3.start();  
        
		/*Thread t1 = new Thread(new Server ());
		Thread t2 = new Thread(new Client());
          t1.start();
         t2.start();*/
    }
}
