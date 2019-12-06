package vilainFactory;


import vilainTypes.StrengthVillain;
import vilainTypes.Villain;

public class StrengthVillainFactory implements Villain{
	StrengthVillain vil1 = new StrengthVillain("The Strongman","Evil Strength", "7");
	
	public StrengthVillain getVilain() {
		return vil1;
	}
}
