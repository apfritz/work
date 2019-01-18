package de.ig.textausgabe.contents;

import java.util.List;

import de.ig.textausgabe.exceptions.InvalidAchillesZieltypException;

public class Achilles extends Gegenstand {
	
	public List<String> typen;
	
	

	public Achilles(String typ, Integer menge, Boolean verbrauchbar, List<String> typen)
			throws InvalidAchillesZieltypException {
		
		super.typ = typ;
		
		super.menge = menge;
		
		super.verbrauchbar = verbrauchbar;

		if (typen == null || typen.isEmpty()) {
			
			throw new InvalidAchillesZieltypException ("Ungültiges Achillesobjekt. Achillesobjekt muss mindestens einen Zieltyp spezifiezeren gegen den es wirksam ist.", typ);
			
		}else {
			this.typen = typen;
		
		}
	}
	
}