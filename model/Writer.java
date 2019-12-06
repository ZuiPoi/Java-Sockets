package model;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import heroTypes.Hero;
import vilainTypes.FlyVillain;
import vilainTypes.SmartVillain;
import vilainTypes.StrengthVillain;
import vilainTypes.Villain;



;

public class Writer {

	
	public static  void serialize(Object Spoon) throws InterruptedException {
		String pathLoc = "C:\\Users\\poi\\Documents\\Eclipse\\sys_prog_y3_l2\\src\\shared\\battlezone";
		String extension = ".ser";
		int incVal = 1;
		File battleZone = new File(pathLoc+incVal+extension);
		while(battleZone.exists()) {
			incVal = incVal+1;
			battleZone =new File(pathLoc+incVal+extension);
		}
		try {
	         FileOutputStream fileOut = new FileOutputStream(pathLoc+incVal+extension);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	            out.writeObject(Spoon);
	            out.close();
	            fileOut.close();
	        // System.out.println("Serialized data is saved in battlezone"+incVal);


	      } catch (IOException i) {
	    	  System.out.println("error during Villain serialization");
	          i.printStackTrace();
	          return;
	      
	      }

		
	}
	
	public static void finalSerialize(Object x) throws IOException {
  
		String outPathLoc = "C:\\Users\\poi\\Documents\\Eclipse\\sys_prog_y3_l2\\src\\SavedTheWorldAgain\\battlezone";
		String extension = ".ser";
		int incVal = 1;
		File battleZone = new File(outPathLoc+incVal+extension);
		while(battleZone.exists()) {
			incVal = incVal+1;
			battleZone =new File(outPathLoc+incVal+extension);
		}
		try {
			
	         FileOutputStream fileOut = new FileOutputStream(outPathLoc+incVal+extension);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         
	            out.writeObject(x);
	            out.close();
	            fileOut.close();
	      //   System.out.printf("Serialized data is saved in", bZone);
	         
	      } catch (IOException i) {
	    	  System.out.println("error during hero serialization");
	          i.printStackTrace();
	          return;
	      
	      }
	}

	public static String checkVillainType(String bZone) throws IOException, ClassNotFoundException {

	    String first = "first";
	    String second = "second";
	    
		String pathLoc = "C:\\Users\\poi\\Documents\\Eclipse\\sys_prog_y3_l2\\src\\shared\\";

		
		ObjectInputStream objectinputstream = null;
		    FileInputStream streamIn = new FileInputStream(pathLoc+bZone);
		    objectinputstream = new ObjectInputStream(streamIn);
		    Object a =  objectinputstream.readObject();
		    String p = "";

		    
		    if(a.getClass() == StrengthVillain.class) {

			    streamIn.close();
			    p = "Strength";
			    return p;
			}
		    
		    else if(a.getClass() == FlyVillain.class) {

			    streamIn.close();
			    p = "Fly";
			    return p;
			}
				
			else if(a.getClass() == SmartVillain.class) {
			    streamIn.close();
			    p = "Smart";
			    return p;
			}		
				
			else {
			    streamIn.close();
				return null;
			}

	}
	
	public static Hero checkVilType(Object a1) throws IOException {
	    if(a1.getClass() == StrengthVillain.class) {
		    Hero h = HeroGenerator.generateHero(1);
		    return h;
		}
	    
	    else if(a1.getClass() == FlyVillain.class) {
		    Hero h =  HeroGenerator.generateHero(2);
		    return h;
		}
			
		else if(a1.getClass() == SmartVillain.class) {
		    Hero h = HeroGenerator.generateHero(3);
		    return h;
		}
		else {
			return null;
		}

	}
	
	public static void cleanDirectory() {
		File dir = new File("C:\\Users\\poi\\Documents\\Eclipse\\sys_prog_y3_l1\\src\\shared\\");
	    for (File file: dir.listFiles()) {
	        if (file.isDirectory())
	            cleanDirectory();
	        file.delete();
	    }
	}
}
