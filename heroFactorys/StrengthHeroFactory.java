package heroFactorys;

import heroTypes.Herro;
import heroTypes.StrengthHero;

public class StrengthHeroFactory implements Herro {
	static StrengthHero herSt = new StrengthHero("SuperMan", "Super Strength", "10");
	
public StrengthHero getHero() {
	
	return herSt;
}

}


