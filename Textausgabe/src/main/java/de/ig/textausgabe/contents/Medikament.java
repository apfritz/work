package de.ig.textausgabe.contents;

public class Medikament extends Gegenstand {
	
	public Integer heilung = 25;
	
	public Float feuerResistenz = new Float(0.0);
	
	public Float kaelteResistenz = new Float (0.0);
	
	public Float giftResistenz = new Float(0.1);
	
	public Float niedlichkeitsResistenz = new Float(0.0);
	
	
	
	public Medikament (String typ, Boolean verbrauchbar, Integer heilung, Integer menge, Float niedlichkeitsResistenz, Float giftResistenz, Float kaelteResistenz, Float feuerResistenz) {
		
		super.typ = typ;
		
		super.menge = menge;
		
		super.verbrauchbar = verbrauchbar;
		
		this.heilung = heilung;
		
		this.niedlichkeitsResistenz = niedlichkeitsResistenz;
		
		this.giftResistenz = giftResistenz;
		
		this.kaelteResistenz = kaelteResistenz;
		
		this.feuerResistenz = feuerResistenz;
	}
	
	public String beschreibung () {
		
		String text1 = " Das Item bringt ";
		
		String text2 = " Heilung.";
		
		return super.beschreibung().concat(text1.concat(heilung.toString()).concat(text2));
	}
}