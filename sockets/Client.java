package sockets;

import java.net.*;
import java.util.*;
import heroTypes.Hero;
import model.Person;
import model.Watcher;
import model.Writer;
import vilainTypes.Vilain;
import java.lang.System;

import java.io.*;

public class Client implements Runnable{
	public static final int PORT = 4999;
	 String host = "localhost";
	 
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		new Client().createClient();
		
	}
	
	
	public void createClient() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		//create socket
		int poll =1;
		String Dnt = "K";
		
	    System.out.println("socket created");
		Socket cs = new Socket(host, PORT);
        ObjectInputStream input = new ObjectInputStream(cs.getInputStream());
		ObjectOutputStream out2 = new ObjectOutputStream(cs.getOutputStream());
		while (true){
		//	System.out.println("sloop");

		if (Dnt.equals("K")) {
			System.out.println("Polled");
			out2.writeObject(poll);

		}
		Object RO = input.readObject();

		if (RO instanceof String) {
			System.out.println("Recieved Boola");
			String k =(String)RO;

			String check = "a";
			
			if (k.equals(check)) {
				System.out.println("The boola was null");
				try {
					Thread.sleep(5000);


				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else if(k!=check){
				System.out.println("Boola indicates villain");
				Thread.sleep(5000);
				Dnt = "R";
				Request RC= new Request(k);
			    System.out.println("Request made");
			    out2.writeObject(RC);
			    System.out.println("Request sent");
			    System.out.println("");


			    
			}
		}
		else if (RO instanceof Person){

        Serializable p = (Serializable) RO;
		System.out.println("");
		System.out.println("Request returned");
		Object a1 =(Object) p;
		Hero h = Writer.checkVilType(a1);
		System.out.println("Hero created");
		ArrayList<Serializable> list = new ArrayList<Serializable>();
		list.add(h);
		list.add(p);
//	System.out.println(list);
		System.out.println("List matched");
		out2.writeObject(list);
		System.out.println("Final list sent to server");
		System.out.println("");
		System.out.println("Contents of final list:");
		System.out.println(list);
		System.out.println("");
		Dnt = "K";
		}
	else {
		System.out.println("PX");
	}
		out2.reset();

		}

    }
	public void run() {
		try {
			try {
				try {
					main(null);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
