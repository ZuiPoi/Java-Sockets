package vilainTypes;

import model.Person;

/**
 * @author Joshua Desmond
 *
 */
public class Vilain extends Person{
	private String Evil;
	
	
	
	/**
	 * Constructor of Hero class-> inherits from Person Class
	 * 3 Parameters;
	 * @param a
	 * @param b
	 * @param c
	 */
	public Vilain(String a, String b, String c) {
		super(a, b);
		this.Evil = c;

	}

	/**
	 * Getter-> Returns Evil
	 */
	public String getEvil() {
		return Evil;
	}
	
	/**
	 * Setter-> Sets Heroic
	 */
	public void setEvil(String evil) {
		Evil = evil;
	}

}
