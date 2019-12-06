package model;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import vilainFactory.FlyVillainFactory;
import vilainFactory.SmartVillainFactory;
import vilainFactory.StrengthVillainFactory;
import vilainTypes.FlyVillain;
import vilainTypes.SmartVillain;
import vilainTypes.StrengthVillain;
import vilainTypes.Vilain;
import vilainTypes.Villain;

public class VillainGenerator implements Runnable {


	//public static void generateVillain(int n) throws InterruptedException  {
	public void run() {
		int n = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		
	
		if (n == 1) {
			StrengthVillainFactory SHF = new StrengthVillainFactory();
			StrengthVillain v1= SHF.getVilain();

			try {
				Writer.serialize(v1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (n == 2) {
			FlyVillainFactory FVF = new FlyVillainFactory();
			FlyVillain v2 = FVF.getVilain();
			
			try {
				Writer.serialize(v2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (n == 3) {
			SmartVillainFactory SVF2 = new SmartVillainFactory();
			SmartVillain v3 = SVF2.getVilain();
			
			try {
				Writer.serialize(v3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static Serializable VillainGenerationTool() {
		int n = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		
		if (n == 1) {
			StrengthVillainFactory SHF = new StrengthVillainFactory();
			StrengthVillain v1= SHF.getVilain();
		}
		if (n == 2) {
			FlyVillainFactory FVF = new FlyVillainFactory();
			FlyVillain v2 = FVF.getVilain();
		}
		
		if (n == 3) {
			SmartVillainFactory SVF2 = new SmartVillainFactory();
			SmartVillain v3 = SVF2.getVilain();
			return v3;
		}
		
		else {
			return null;
		}
	}
}


	


