package de.ig.textausgabe.exceptions;

/**
 * Diese Fehlermeldung wird geworfen, wenn ein Achillesobjekt ohne gültigen Zielobjekttyp erstellt werden soll. 
 * @author pauline
 *
 *
 */
public class InvalidAchillesZieltypException extends Exception {
	
	public String achillesTyp;
	
	public InvalidAchillesZieltypException(String fehlerMeldung, String achillesTyp) {
		
		super(fehlerMeldung);
		
		this.achillesTyp = achillesTyp;
		
	}
	
}