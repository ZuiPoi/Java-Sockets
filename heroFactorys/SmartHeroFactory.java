package heroFactorys;

import heroTypes.SmartHero;
import heroTypes.StrengthHero;


public class SmartHeroFactory {
	SmartHero HerSm = new SmartHero("DR Spoon","Intelligence", "10");
	
	public  SmartHero getHero() {
		
		return HerSm;
	}
}
