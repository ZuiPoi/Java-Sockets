package heroFactorys;

import heroTypes.FlyHero;


public class FlyHeroFactory {
	FlyHero herF = new FlyHero("FlyerMan", "Super Flight", "10");
	
	
	public FlyHero getHero() {
		
		return herF;
	}
}
