package de.ig.textausgabe.contents;

public class Gegenstand {
	
	public String typ = "Buntstift";

	public Integer menge = 1;
	
	public Boolean verbrauchbar = false;
	
	
	public Gegenstand (String typ, Integer menge, Boolean verbrauchbar) {
		
		this.typ = typ;

		this.menge = menge;
		
		this.verbrauchbar = verbrauchbar;
		
	}
	
	public Gegenstand () {
		
	}

	public String beschreibung() {
		
		String text1 = "Dies ist ein(e) ";
		
		String text2 = ".";
		
		String text3 = text1.concat(typ).concat(text2);
		
		if (verbrauchbar) {
		
			String text4 = " Du hast noch ";
			
			String text5 = " zur Verfügung.";
			
			text3 = text3.concat(text4).concat(menge.toString()).concat(text5);
		}
	
		return text3;
	}
}