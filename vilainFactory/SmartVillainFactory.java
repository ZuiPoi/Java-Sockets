package vilainFactory;


import vilainTypes.SmartVillain;
import vilainTypes.Villain;

public class SmartVillainFactory implements Villain {
	SmartVillain vil1 = new SmartVillain("The BrainCase","Evil Intelligence", "10");
	
	public SmartVillain getVilain() {
		return vil1;
	}
}

