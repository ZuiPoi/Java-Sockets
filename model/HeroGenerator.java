package model;

import java.io.IOException;

import heroFactorys.FlyHeroFactory;
import heroFactorys.SmartHeroFactory;
import heroFactorys.StrengthHeroFactory;
import heroTypes.FlyHero;
import heroTypes.Hero;
import heroTypes.SmartHero;
import heroTypes.StrengthHero;
import vilainTypes.FlyVillain;
import vilainTypes.SmartVillain;
import vilainTypes.StrengthVillain;


public class HeroGenerator {
	
	public static Hero generateHero(int n) throws IOException {
		
		
		if (n == 1) {
			StrengthHeroFactory SHF = new StrengthHeroFactory();
			StrengthHero v1= SHF.getHero();

			return v1;
			//Writer.heroSerialize(v3);
		}
		if (n == 2) {
			FlyHeroFactory FVF = new FlyHeroFactory();
			FlyHero v2 = FVF.getHero();
			
			return v2;
			//Writer.heroSerialize(v3);
		}
		
		if (n == 3) {
			SmartHeroFactory SVF2 = new SmartHeroFactory();
			SmartHero v3 = SVF2.getHero();
			
			return v3;
			//Writer.heroSerialize(v3);
		}
		
		else {
			System.out.println("no hero match found");
			return null;
		}
		
	}
	
	public static Hero MatchHero(Object a) throws IOException {
		int i = 0;
		if(a.getClass() == FlyVillain.class) {
			i = 1;	
			}
			else if(a.getClass() == SmartVillain.class) {
			i = 2;	
			}
			
			else if(a.getClass() == StrengthVillain.class) {
			i = 3;	
			}
		
		if (i == 1) {
			StrengthHeroFactory SHF = new StrengthHeroFactory();
			StrengthHero v1= SHF.getHero();

			return v1;
		}
		if (i == 2) {
			FlyHeroFactory FVF = new FlyHeroFactory();
			FlyHero v2 = FVF.getHero();
			
			return v2;
		}
		
		if (i == 3) {
			SmartHeroFactory SVF2 = new SmartHeroFactory();
			SmartHero v3 = SVF2.getHero();
			
			return v3;
		}
		
		else {
			System.out.println("no hero match found");
			return null;
		}
	}
	

	
}
