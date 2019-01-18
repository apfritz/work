package de.ig.textausgabe.contents;

import de.ig.textausgabe.BallerSpass;
import de.ig.textausgabe.Main;

public class Schusswaffe extends Waffe {

	public Integer kugelAnzahl = 6;
	
	public Integer magazinGroesse = 6;
	
	public Integer automatikSchussMenge = 1; 

	//elternSpiel angelegt um auf verschwendeteKugeln zuzugreifen
	public BallerSpass elternSpiel;
	
	
	public String beschreibung() {
	
		String text2 = " Du hast noch ";
		
		String text3 = " Schuss im Magazin.";
		
		return  super.beschreibung().concat(text2).concat(kugelAnzahl.toString()).concat(text3);
	}
	//Konstruktor
	public Schusswaffe(BallerSpass elternSpiel, String typ, Integer kugelAnzahl, Integer automatikSchussMenge, String geraeusch, String praefixGeraeusch, String suffixGeraeusch, Schaden schussSchaden, Integer schussGeschwindigkeit, Float trefferQuote) {
		//this ist die Variable die sich auf das aktuelle Objekt bezieht das aus der Klasse erstellt wurde
		super.typ = typ;
		
		this.kugelAnzahl = kugelAnzahl;	
		
		this.magazinGroesse = kugelAnzahl;
		
		this.automatikSchussMenge = automatikSchussMenge; 
		
		super.geraeusch = geraeusch;
		
		super.praefixGeraeusch = praefixGeraeusch;
		
		super.suffixGeraeusch = suffixGeraeusch; 
		
		this.elternSpiel = elternSpiel;		
		
		super.schaden = schussSchaden;
		
		super.angriffsGeschwindigkeit = schussGeschwindigkeit;
		
		super.trefferQuote = trefferQuote;
		
	}
	//Konstruktor
	public Schusswaffe(BallerSpass elternSpiel) {
		
		this.elternSpiel = elternSpiel;
		
		super.schaden = new Schaden(25, 0, 0, 0, 0, 0);
		}
	
	private Schaden schiessen(Boolean praefixSuffix) {
		
			Integer schussDauer = 1000;
		
			if (kugelAnzahl > 0) {
			kugelAnzahl = kugelAnzahl - 1;
			
			elternSpiel.verschwendeteKugeln = elternSpiel.verschwendeteKugeln + 1;
			
			schussDauer = schussDauer - super.angriffsGeschwindigkeit;
			try {
				Thread.sleep(schussDauer);
			}catch (Exception e){ 
				Main.textAusgabe(e.getMessage());
			}
			
			if (praefixSuffix) {
				Main.textAusgabe(super.praefixGeraeusch, false);
			}
			Main.textAusgabe(super.geraeusch, false);
			if (praefixSuffix) {
				Main.textAusgabe(super.suffixGeraeusch, false);
			}
			
			return super.schaden.trefferSchaden(super.trefferQuote);
			
		} else {
			
			if (praefixSuffix) {
				Main.textAusgabe(Main.ZEILENUMBRUCH);
			}
			Main.textAusgabe("CLACK ", false);
			if (praefixSuffix) {
				Main.textAusgabe(Main.ZEILENUMBRUCH);
			}
		}
			
			return new Schaden();
	}
	
	private Schaden schiessen() {
		
		return schiessen(true);
	}
	
	private Schaden schiessen(Integer kugelAnzahl, Boolean praefixSuffix) {
		
		Schaden schaden = new Schaden();
		
		for(int i = 1; i <= kugelAnzahl; i = i + 1) {
		
			Schaden schiessenSchaden = schiessen(praefixSuffix);
			
			schaden.schadenAddition(schiessenSchaden);
		}
		
		return schaden;
	}
	
	private Schaden schiessen(Integer kugelAnzahl) {
		
		return schiessen(kugelAnzahl, true);
		
	}
	
	private Schaden automatik() {
		
		int startKugelAnzahl = kugelAnzahl;
		
		Schaden schaden;
		
		if (startKugelAnzahl > 0) {
		Main.textAusgabe(super.praefixGeraeusch, false);
		}
		else {
			Main.textAusgabe(Main.ZEILENUMBRUCH);
		}
		schaden = this.schiessen(this.automatikSchussMenge, false);
		if (startKugelAnzahl > 0) {
			Main.textAusgabe(super.suffixGeraeusch, false);
		}
		else {
			Main.textAusgabe(Main.ZEILENUMBRUCH);
		}
		
		return schaden;
	}
	
	public void nachladen() {
		
		kugelAnzahl = magazinGroesse;
		
		Main.textAusgabe(Main.ZEILENUMBRUCH);
		Main.textAusgabe(Main.ZEILENUMBRUCH);
		Main.textAusgabe("CLICK", false);
		Main.textAusgabe(Main.ZEILENUMBRUCH);
		Main.textAusgabe(Main.ZEILENUMBRUCH);
	}
	
	@Override
	public Schaden angriff() {
		
		return this.schiessen();
	}
	
	@Override
	public Schaden alternativAngriff() {
		
		return this.automatik();
	}
}