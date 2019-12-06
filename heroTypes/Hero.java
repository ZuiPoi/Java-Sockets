package heroTypes;

import model.Person;

/**
 * @author Joshua Desmond
 *
 */
public class Hero extends Person{
	private String Heroic;
	
	
	
	/**
	 * Constructor of Hero class-> inherits from Person Class
	 * 3 Parameters;
	 * @param a
	 * @param b
	 * @param c
	 */
	public Hero(String a, String b, String c) {
		super(a, b);
		this.Heroic = c;

	}

	/**
	 * Getter-> Returns Heroic
	 */
	public String getHeroic() {
		return Heroic;
	}
	
	/**
	 * Setter-> Sets Heroic
	 */
	public void setHeroic(String heroic) {
		Heroic = heroic;
	}

}
