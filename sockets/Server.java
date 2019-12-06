package sockets;

import java.net.*;
import java.util.ArrayList;

import model.Writer;
import vilainFactory.FlyVillainFactory;
import vilainFactory.StrengthVillainFactory;
import model.VillainGenerator;
import model.Watcher;
import vilainTypes.FlyVillain;
import vilainTypes.SmartVillain;
import vilainTypes.StrengthVillain;


import java.io.*;

public class Server implements Runnable {
	public static final int PORT = 4999;
	private static String Boola = "";
	public static void main(String[] args) throws IOException, ClassNotFoundException{
	Server S1 = new Server("a");
	Thread t1 = new Thread(new Watcher(S1));
	t1.start();

	S1.startServer();




	}
	
	public Server(String a){
		this.Boola = a ;
	}
	
	public String getBoola() {
		return Boola;
	}

	public void setBoola(String boola) {
		Boola = boola;
	}

	public void startServer() throws UnknownHostException, IOException, ClassNotFoundException{
		//create the server socket
		String trackerBolt = "a";
		ServerSocket serverSocket = new ServerSocket(PORT);
		
		//print to let know server is ready
		System.out.println("Server started, awaiting connections...");
		
		//accept client and notify of acception
		Socket s = serverSocket.accept();
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(s.getInputStream());
		while (true){
			System.out.println("");
			System.out.println("");

			Object RO = input.readObject();

			System.out.println("input read");
			if(RO instanceof Integer) {
				System.out.println("Poll Recieved");
		        System.out.println(this.getBoola());
		        if ((this.getBoola()).equals(trackerBolt)){
				    out.writeObject(this.getBoola());
				    System.out.println("Returned boola to client");
				    System.out.println("");
		        }
		        else {
			    out.writeObject(this.getBoola());
			    System.out.println("Returned boola to client and reset");
			    this.setBoola(trackerBolt);
			    
		        }
			    
			}
			
			else if(RO instanceof Request) {
				System.out.println("Request Recieved");
				Request IR = (Request)RO;
				String RC =IR.getContents();
				System.out.println("Villain Matched");
				//confirm what type of villain we got requested for
				String x =Writer.checkVillainType(RC);
				
				
		        //create our villain to match the one the client needs
		
				if(x == "Strength") {
					StrengthVillainFactory SF = new StrengthVillainFactory();
					StrengthVillain v = SF.getVilain();
					System.out.println("Villain created");
				    out.writeObject(v);
					System.out.println("Villain sent to client");
				}
				else if(x == "Fly") {
					FlyVillainFactory SF = new FlyVillainFactory();
					FlyVillain v = SF.getVilain();
					System.out.println("Villain created");
				    out.writeObject(v);
					System.out.println("Villain sent to client");
				}
				else if(x == "Smart") {
					FlyVillainFactory SF = new FlyVillainFactory();
					FlyVillain v = SF.getVilain();
					System.out.println("Villain created");
				    out.writeObject(v);
					System.out.println("Villain sent to client");
				}
				else {
					System.out.println("Request not created correctly");
				}
				System.out.println("");

			}
			
			else if (RO instanceof ArrayList ) {
				System.out.println("");
				System.out.println("List Recieved");
				ArrayList<Object> fList = (ArrayList<Object>)RO;
		        Writer.finalSerialize(fList);
		        System.out.println("");
		        System.out.println("Contents of final serialization:");
		        System.out.println(fList);
		        System.out.println("");
		        System.out.println("Final serialization complete");

			}
			
			else {  
				System.out.println("HMMM");
			}
			out.reset();

		}

        
	}

	public void BoolaUp(String a) throws IOException{
		this.setBoola(a);		
	}
	
	public Object MakeAVillain() {
    Object v = VillainGenerator.VillainGenerationTool();
    return v;
	}
	

	public void run() {
		try {
			main(null);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
