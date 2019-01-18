package de.ig.textausgabe.contents;

import java.util.List;
import java.util.Random;

public class Ziel {
	
	public String typ = "Spieler";
	
	public Float physischeResistenz = new Float(0.0);
	
	public Float feuerResistenz = new Float(0.0);
	
	public Float giftResistenz = new Float(0.0);
	
	public Float niedlichkeitsResistenz = new Float(0.0);
	
	public Float kaelteResistenz = new Float (0.0);
	
	public Float wasserResistenz = new Float (0.0);
	
	public Integer trefferPunkte = 150;
	
	public Integer maximaleTrefferpunkte = 150;
	
	public List<Waffe> waffenGuertel;
	
	public List<Gegenstand> itemListe;
	
	public String beschreibung() {
		
		String text1 = "Dein gewaehltes Ziel ist ein(e) ";
	
		String text2 = ". Dein Ziel hat noch ";
		
		String text3 = " Trefferpunkte.";
		
		return text1.concat(typ).concat(text2).concat(trefferPunkte.toString()).concat(text3);
	}
	

	public String spielerBeschreibung() {
		
		String spielerText = "Du hast ";
		
		String spielerText2 = " Lebenspunkte.";
		
		String spielerText3 = " Deine Feuerresistenz: ";
		
		String spielerText4 = " Deine Kälteresistenz: ";
		
		String spielerText5 = " Deine Niedlichkeitsresistenz: ";
		
		String spielerText6 = " Deine Giftresistenz: ";
		
		return spielerText.concat(trefferPunkte.toString()).concat(spielerText2)
				.concat(spielerText3).concat(feuerResistenz.toString())
				.concat(spielerText4).concat(kaelteResistenz.toString())
				.concat(spielerText5).concat(niedlichkeitsResistenz.toString())
				.concat(spielerText6).concat(giftResistenz.toString());
	}
	
	public Ziel(String typ, Integer trefferPunkte, 
					Float physischeResistenz, Float feuerResistenz, Float giftResistenz, Float niedlichkeitsResistenz, Float kaelteResistenz, Float wasserResistenz)
	{
		
		this.typ = typ;
				
		this.trefferPunkte = trefferPunkte;
		
		this.physischeResistenz = physischeResistenz;
		
		this.feuerResistenz = feuerResistenz;
		
		this.giftResistenz = giftResistenz;
		
		this.niedlichkeitsResistenz = niedlichkeitsResistenz;
		
		this.kaelteResistenz = kaelteResistenz;
		
		this.wasserResistenz = wasserResistenz;
		
		this.maximaleTrefferpunkte = trefferPunkte;
	}
	
	
	public Ziel() {
		
	}
	
	public void waffenUebergabe(List<Waffe> waffenGuertel) {
		
		this.waffenGuertel = waffenGuertel;
		
	}
	
	public void itemUebergabe (List<Gegenstand> itemListe) {
		
		this.itemListe = itemListe;
	}
	
	public Waffe zufallsWaffe() {
		
		Random zufallsGen = new Random();
		Float zufallsZahl = zufallsGen.nextFloat();
		
		if (waffenGuertel != null && !waffenGuertel.isEmpty()) {
			Float zufallsWaffe = this.waffenGuertel.size() * zufallsZahl;
			
			Integer waffe = Math.round(zufallsWaffe);
			if(waffe >= 1) {
				waffe = waffe - 1;
			}
			return this.waffenGuertel.get(waffe);
		}
		return null;
	}
}