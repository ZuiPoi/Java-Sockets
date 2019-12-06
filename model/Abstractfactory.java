package model;

import heroFactorys.FlyHeroFactory;
import heroFactorys.SmartHeroFactory;
import heroFactorys.StrengthHeroFactory;
import vilainFactory.FlyVillainFactory;
import vilainFactory.SmartVillainFactory;
import vilainFactory.StrengthVillainFactory;

public abstract class Abstractfactory {

	 abstract StrengthHeroFactory getHerro(String s);
	 abstract SmartHeroFactory getHerro1(String s);
	 abstract FlyHeroFactory getHerro2(String s);
	 abstract StrengthVillainFactory getVillain(String s);
	 abstract FlyVillainFactory getVillain1(String s);
	 abstract SmartVillainFactory getVillain2(String s);	
}
