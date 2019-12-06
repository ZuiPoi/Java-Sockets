package vilainFactory;

import vilainTypes.FlyVillain;
import vilainTypes.Villain;

public class FlyVillainFactory implements Villain {
	FlyVillain vil1 = new FlyVillain("The Fly","Evil Flight", "7");
	
	public FlyVillain getVilain() {
		return vil1;
	}
}
