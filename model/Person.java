package model;

import java.io.Serializable;

/**
 * @author Joshua Desmond
 *
 */
public class Person implements Serializable{
	private String Name;
	private String Power;

	

	/**
	 * Constructor of the Person Superclass, takes 2 parameters
	 * @param a
	 * @param b
	 */
	public Person(String a, String b) {
		this.Name = a;
		this.Power = b;

	}


	/**
	 * Getter-> Returns Person Name
	 */
	public String getName() {
		return Name;
	}


	/**
	 * Setter-> Sets String Name of person 
	 */

	public void setName(String name) {
		this.Name = name;
	}



	/**
	 * Getter-> Returns Power String of Person 
	 */
	public String getPower() {
		return Power;
	}


	/**
	 * Setter-> Sets Power String of Person
	 */
	public void setPower(String Power) {
		this.Power = Power;
	}





	public String toString() {
		return "Person [Name =" + Name + ", Power =" + Power + "]";
	}
	
	
}
