package de.ig.textausgabe.contents;

import java.util.Random;

public class Schaden {
	
	public Integer physischerSchaden = 0;
	
	public Integer feuerSchaden = 0;
	
	public Integer giftSchaden = 0;
	
	public Integer niedlichkeitsSchaden = 0;
	
	public Integer kaelteSchaden = 0;
	
	public Integer wasserSchaden = 0;
	
	public Schaden schadenAddition(Schaden schaden) {
		
		this.physischerSchaden = this.physischerSchaden + schaden.physischerSchaden;
		
		this.feuerSchaden = this.feuerSchaden + schaden.feuerSchaden;
		
		this.giftSchaden = this.giftSchaden + schaden.giftSchaden;
		
		this.niedlichkeitsSchaden = this.niedlichkeitsSchaden + schaden.niedlichkeitsSchaden;
		
		this.kaelteSchaden = this.kaelteSchaden + schaden.kaelteSchaden;
		
		this.wasserSchaden = this.wasserSchaden + schaden.wasserSchaden;
		
		return this;
	}
	
	public String beschreibung() {
		
		String text1 = "Ermittelter Waffenschaden:  ";
		
		return text1.concat(new Integer(physischerSchaden + feuerSchaden + giftSchaden + niedlichkeitsSchaden + kaelteSchaden + wasserSchaden).toString());	
	}
	
	public Schaden(Integer physischerSchaden, Integer feuerSchaden, Integer giftSchaden, Integer niedlichkeitsSchaden, Integer kaelteSchaden, Integer wasserSchaden) {
		
		this.physischerSchaden = physischerSchaden;
		
		this.feuerSchaden = feuerSchaden;
		
		this.giftSchaden = giftSchaden;
		
		this.niedlichkeitsSchaden = niedlichkeitsSchaden;
		
		this.kaelteSchaden = kaelteSchaden;
		
		this.wasserSchaden = wasserSchaden;
		
	}
	
	public Schaden() {
		
	}
	
	public Schaden trefferSchaden(Float trefferQuote) {
		
		Schaden trefferSchaden = new Schaden();
		
		Random zufallsGen = new Random();
		
		Float zufallsZahl = zufallsGen.nextFloat();
		//Ausführung wenn nicht getroffen
		if (zufallsZahl < (1 - trefferQuote)) {
			
			return trefferSchaden;
		}
		//Ausführung wenn getroffen
		
		Float schadensModifikation = (zufallsZahl - (1 - trefferQuote)) / (trefferQuote); 
		
		trefferSchaden.physischerSchaden = Math.round(new Float(new Float(this.physischerSchaden) * schadensModifikation));

		trefferSchaden.feuerSchaden = Math.round(new Float(new Float(this.feuerSchaden) * schadensModifikation));

		trefferSchaden.giftSchaden = Math.round(new Float(new Float(this.giftSchaden) * schadensModifikation));

		trefferSchaden.kaelteSchaden = Math.round(new Float(new Float(this.kaelteSchaden) * schadensModifikation));

		trefferSchaden.wasserSchaden = Math.round(new Float(new Float(this.wasserSchaden) * schadensModifikation));

		
		return trefferSchaden;
	}
}
	
