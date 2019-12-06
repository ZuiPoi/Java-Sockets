package model;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import sockets.Client;
import sockets.Server;

import java.nio.file.StandardWatchEventKinds;

public class Watcher implements Runnable {
	private Server s;

	
	public Watcher(Server sv) {
		this.s = sv;
		
	}
	
	public static void watchRunner(Server s) {
		System.out.println("Watch service active");
        try {
            // Creates a instance of WatchService.
            WatchService watcher = FileSystems.getDefault().newWatchService();

            // Registers the myDir below with a watch service.
            Path MyDir = Paths.get("C:\\Users\\poi\\Documents\\Eclipse\\sys_prog_y3_l2\\src\\shared\\");
            	MyDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

            //generate a watch Key
            WatchKey key = watcher.take();
            

            do {
                for (WatchEvent<?> event : key.pollEvents()) {

                    if (event.kind() ==	StandardWatchEventKinds.ENTRY_CREATE) {

                        WatchEvent<Path> ev = (WatchEvent<Path>)(event);
                        Path filename = ev.context();
                        System.out.printf("A new file %s was created.%n",filename.getFileName());
                    	Thread.sleep(2000);
                        String name = (filename.getFileName().toString());
                        s.BoolaUp(name);
                        
                    } else if (event.kind() ==	StandardWatchEventKinds.ENTRY_MODIFY) {
                        //System.out.println("Entry was modified on log dir.");
                    } else if (event.kind() ==	StandardWatchEventKinds.ENTRY_DELETE) {
                       // System.out.println("Entry was deleted from log dir.");
                    }
                }
            }while(key.reset());
            
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        
	}
	public void run() {
		this.watchRunner(s);
	}
	public static void main(String[] args) throws InterruptedException {
	
	}


		
	
}
