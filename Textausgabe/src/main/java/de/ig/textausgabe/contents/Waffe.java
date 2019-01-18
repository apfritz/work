package de.ig.textausgabe.contents;

import de.ig.textausgabe.Main;

public class Waffe {
	
	public String typ = "Pistole";
	
	public String geraeusch = "PENG";
	
	public String praefixGeraeusch = Main.ZEILENUMBRUCH;
	
	public String suffixGeraeusch = Main.ZEILENUMBRUCH;
	
	public Schaden schaden;
	
	public Integer angriffsGeschwindigkeit = 900; 
	
	public Float trefferQuote = new Float(0.99);
	
	
	public Waffe (String typ, String geraeusch, String praefixGeraeusch, String suffixGeraeusch, Schaden schaden, Integer angriffsGeschwindigkeit, Float trefferQuote) {
		
		this.typ = typ;
		
		this.geraeusch = geraeusch;
		
		this.praefixGeraeusch = praefixGeraeusch;
		
		this.suffixGeraeusch = suffixGeraeusch;
		
		this.schaden = schaden;
		
		this.angriffsGeschwindigkeit = angriffsGeschwindigkeit;
		
		this.trefferQuote = trefferQuote;
	}
	
	public Waffe() {
		
	}
	
	public Schaden angriff() {
		
		Integer schlagDauer = 1000;
		
		schlagDauer = schlagDauer - this.angriffsGeschwindigkeit;
		try {
			Thread.sleep(schlagDauer);
		}catch (Exception e){ 
			Main.textAusgabe(e.getMessage());
		}
		
		Main.textAusgabe(this.praefixGeraeusch, false);

		Main.textAusgabe(this.geraeusch, false);
		
		Main.textAusgabe(this.suffixGeraeusch, false);
		
		
		return this.schaden.trefferSchaden(this.trefferQuote);
	}
	
	public Schaden alternativAngriff() {
		
		return this.angriff();
	}
	
	public String beschreibung() {
		
		String text1 = "Die Waffe in deinen Händen ist ein(e) ";
		
		return text1.concat(this.typ).concat(".");
	}
}