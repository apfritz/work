package de.ig.textausgabe;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import de.ig.textausgabe.contents.Achilles;
import de.ig.textausgabe.contents.Gegenstand;
import de.ig.textausgabe.contents.Medikament;
import de.ig.textausgabe.contents.Schaden;
import de.ig.textausgabe.contents.Schusswaffe;
import de.ig.textausgabe.contents.Waffe;
import de.ig.textausgabe.contents.Ziel;
import de.ig.textausgabe.exceptions.InvalidAchillesZieltypException;

public class BallerSpass {
	
	public Integer verschwendeteKugeln = 0;
	
	public void derTest() {
		
		
		
		List<Schusswaffe> waffenGuertel = new ArrayList<Schusswaffe>();
		
		waffenGuertel.add(new Schusswaffe(this));
		waffenGuertel.add(new Schusswaffe(this, "Gewehr", 24, 4, "PENG", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(15, 0, 0, 0, 0, 0), 900, new Float(0.8)));
		waffenGuertel.add(new Schusswaffe(this, "Granatwerfer", 5, 1, "BUMM", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(70, 30, 0, 0, 0, 0), 700, new Float(0.3)));
		
		for(Schusswaffe akuelleSchusswaffe : waffenGuertel) { 
		
			Main.textAusgabe(akuelleSchusswaffe.beschreibung());
			
			//auf Variable schaden wird schadensHoehe aufgerufen um "Verursachter Schaden" auszugeben
			Schaden schaden = akuelleSchusswaffe.alternativAngriff();
			Main.textAusgabe(akuelleSchusswaffe.beschreibung());
			Main.textAusgabe(schaden.beschreibung());
		
			akuelleSchusswaffe.nachladen();
			Main.textAusgabe(akuelleSchusswaffe.beschreibung());
			
		}
	}
	
	private List<Waffe> waffenLaden(){
		
		List<Waffe> waffenGuertel = new ArrayList<Waffe>();
		
		// Reihenfolge Waffenattribute Konstruktor: Waffe, Magazingröße, Automatik, Geräusch, Zeilenumbruch, Schaden physisch/feuer/gift/niedlichkeit/kälte/Wasser, Schussdauer, Trefferquote
		waffenGuertel.add(new Schusswaffe(this));
		waffenGuertel.add(new Schusswaffe(this, "Gewehr", 24, 4, "PENG ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(40, 0, 0, 0, 0, 0), 900, new Float(0.8)));
		waffenGuertel.add(new Schusswaffe(this, "Granatwerfer", 6, 2,"BUMM ",Main.ZEILENUMBRUCH + "{{{ ", " }}}" + Main.ZEILENUMBRUCH, new Schaden(100, 30, 0, 0, 0, 0), 700, new Float (0.4)));
		waffenGuertel.add(new Schusswaffe(this, "Laserkanone", 1000, 20, "ZISCH ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(90, 150, 0, 0, 0, 0), 1000, new Float(0.9)));
		waffenGuertel.add(new Schusswaffe(this, "Schrotflinte", 1, 1, "KNALL", Main.ZEILENUMBRUCH + "[[ ", " ]]" + Main.ZEILENUMBRUCH, new Schaden(60, 0, 0, 0, 0, 0), 800, new Float(0.98)));
		waffenGuertel.add(new Schusswaffe(this, "Kaetzchenkanone", 2, 1, "MIAU", Main.ZEILENUMBRUCH + "/ ", " \\" + Main.ZEILENUMBRUCH, new Schaden(10, 0, 0, 100, 0, 0), 100, new Float(0.98)));
		waffenGuertel.add(new Schusswaffe(this, "Automatikarmbrust", 12, 3, "ZACK ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(25, 0, 70, 0, 0, 0), 600, new Float(0.6)));
		waffenGuertel.add(new Schusswaffe(this, "Seifenblasenpistole", 100, 10, "BLOBB ",  Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(1, 0, 7, 3, 0, 4), 50, new Float(0.1)));
		waffenGuertel.add(new Schusswaffe(this, "Flammenwerfer", 1000, 25, "FLACKER ", Main.ZEILENUMBRUCH + "~~ ", " ~~" + Main.ZEILENUMBRUCH, new Schaden(10, 50, 0, 0, 0, 0), 900, new Float(0.8)));
		waffenGuertel.add(new Schusswaffe(this, "Eiswuerfelschleuder", 50, 5, "KLONK ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(20, 0, 0, 0, 80, 10), 500, new Float(0.5)));
		waffenGuertel.add(new Schusswaffe(this, "Regenbogengewehr", 1000, 40, "KLING ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(30, 0, 0, 200, 50, 0),  1000, new Float(0.99)));
		waffenGuertel.add(new Schusswaffe(this, "Eisstrahler", 500, 20, "KALT ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(20, 0, 0, 0, 100, 20), 900, new Float(0.8)));
		waffenGuertel.add(new Schusswaffe(this, "Wasserpistole", 250, 15, "WASSER ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(10, 0, 0, 10, 10, 80), 700, new Float(0.5)));
	
		return waffenGuertel;
	}
	
	private List<Ziel> zielLaden() {
		 
		List<Ziel> dieGegner = new ArrayList<Ziel>();

		Ziel lastkraftwagen = new Ziel("Lastkraftwagen", 300, new Float(0.9), new Float(0.5), new Float(1.0), new Float(0.7), new Float (1.0), new Float (0.8));                
		List<Waffe> lkwWaffen = new ArrayList<Waffe>();
		lkwWaffen.add(new Waffe("Ueberfahren", " BRUMM ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(20, 0, 0, 0, 0, 0), 400, new Float(0.3)));
		lastkraftwagen.waffenUebergabe(lkwWaffen);
		
		Ziel akazie = new Ziel("Akazie", 200, new Float(0.8), new Float(0.1), new Float(0.4), new Float(1.0), new Float(0.8), new Float(0.2));
		List<Waffe> akazienWaffen = new ArrayList<Waffe>();
		akazienWaffen.add(new Waffe("Ausschlagen", " RASCHEL ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(0, 0, 20, 0, 0, 0), 400, new Float(0.8)));
		akazie.waffenUebergabe(akazienWaffen);
		
		Ziel bienenstock = new Ziel("Bienenstock", 50, new Float(0.6), new Float(0.2), new Float(0.7), new Float(0.9), new Float(0.7), new Float(0.4));
		List<Waffe> bienenWaffen = new ArrayList<Waffe>();
		bienenWaffen.add(new Waffe("Stechen", "SUMM ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(10, 0, 5, 0, 0, 0), 800, new Float(0.6)));
		bienenstock.waffenUebergabe(bienenWaffen);
		
		Ziel steinbrocken = new Ziel("Steinbrocken", 700, new Float(0.4), new Float(0.9), new Float(1.0), new Float(1.0), new Float(1.0), new Float(0.9));
		
		Ziel mosasaurus = new Ziel("Mosasaurus", 1000, new Float(0.6), new Float(0.3), new Float(0.6), new Float(0.7), new Float(1.0), new Float(1.0));
		List<Waffe> mosaWaffen = new ArrayList<Waffe>();
		mosaWaffen.add(new Waffe("Beißen", "SCHNAPP ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(30, 0, 0, 0, 0, 10), 700, new Float(0.6)));
		mosasaurus.waffenUebergabe(mosaWaffen);
		
		Ziel laptop = new Ziel("Laptop", 50, new Float(0.2), new Float(0.3), new Float(1.0), new Float(1.0), new Float(1.0), new Float(0.1));
		
		Ziel oger = new Ziel("Oger", 500, new Float(0.4), new Float(0.7), new Float(0.5), new Float(0.1), new Float(0.8), new Float(0.5));
		List<Waffe> ogerWaffen = new ArrayList<Waffe>();
		ogerWaffen.add(new Waffe("Keule", "BOINK ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(20, 0, 0, 0, 0, 0), 700, new Float(0.8)));
		oger.waffenUebergabe(ogerWaffen);
		
		Ziel komet = new Ziel("Komet", 1700, new Float(0.5), new Float(1.0), new Float(1.0), new Float(1.0), new Float(0.9), new Float(0.9));
		List<Waffe> kometWaffen = new ArrayList<Waffe>();
		kometWaffen.add(new Schusswaffe(this, "Steinschauer", 800, 5, "KNALL ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(30, 30, 0, 0, 0, 0), 600, new Float(0.2)));
		komet.waffenUebergabe(kometWaffen);
		
		Ziel eisdrache = new Ziel("Eisdrache", 2000, new Float(0.7), new Float(1.0), new Float(0.8), new Float(0.2), new Float(0.2), new Float(0.5));
		List<Waffe> drachenWaffen = new ArrayList<Waffe>();
		drachenWaffen.add(new Waffe("Feueratem", "FLACKER ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(90, 0, 0, 5, 20, 0), 900, new Float(0.8)));
		eisdrache.waffenUebergabe(drachenWaffen);
		
		Ziel yeti = new Ziel("Yeti", 750, new Float(0.8), new Float(0.3), new Float(0.7), new Float(0.6), new Float(0.9), new Float(0.6));
		List<Waffe> yetiWaffen = new ArrayList<Waffe>();
		yetiWaffen.add(new Schusswaffe(this, "Schneeball", 991, 2, "KALT ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(30, 0, 0, 0, 3, 0),500, new Float(0.8)));
		yetiWaffen.add(new Waffe("Faust", "KLATSCH", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(20, 0, 0, 0, 10, 0), 800, new Float(0.6)));
		yeti.waffenUebergabe(yetiWaffen);
		
		Ziel lehmgolem = new Ziel("Lehmgolem", 500, new Float(0.7), new Float(0.4), new Float(0.9), new Float(0.8), new Float(0.8), new Float(0.4));
		List<Waffe> golemWaffen = new ArrayList<Waffe>();
		golemWaffen.add(new Schusswaffe(this, "Lehmbrocken", 3, 1, "FLOPP ", Main.ZEILENUMBRUCH, Main.ZEILENUMBRUCH, new Schaden(40, 0, 10, 0, 0, 0), 500, new Float(0.7)));
		lehmgolem.waffenUebergabe(golemWaffen);

		dieGegner.add(lastkraftwagen);
		dieGegner.add(akazie);
		dieGegner.add(bienenstock);
		dieGegner.add(steinbrocken);
		dieGegner.add(mosasaurus);
		dieGegner.add(laptop);
		dieGegner.add(oger);
		dieGegner.add(komet);
		dieGegner.add(eisdrache);
		dieGegner.add(yeti);
		dieGegner.add(lehmgolem);
		return dieGegner;
	}
		
	private List<Gegenstand> itemLaden() throws Exception{
		
		List<Gegenstand> items = new ArrayList<Gegenstand>();
		
		
		items.add(new Gegenstand());
		items.add(new Medikament("Heiltrank", true, 25, 2, new Float(0.0), new Float(0.1), new Float(0.0), new Float(0.0)));
		items.add(new Medikament("Pflaster", true, 5, 10, new Float(0.0), new Float(0.0), new Float(0.05), new Float(0.0)));
		items.add(new Medikament("Wasserflasche", true, 10, 3, new Float(0.0), new Float(0.0), new Float(0.0), new Float(0.1)));
		items.add(new Medikament("Hormonspritze", true, 1, 5, new Float(0.06), new Float(0.0), new Float(0.0), new Float(0.0)));
		List<String> laptopListe = new ArrayList<String>();
		laptopListe.add("Laptop");
		List<String> lkwListe = new ArrayList<String>();
		lkwListe.add("Lastkraftwagen");
		List<String> ogerListe = new ArrayList<String>();
		ogerListe.add("Oger");
		List<String> akazienListe = new ArrayList<String>();
		akazienListe.add("Akazie");
		List<String> drachenListe = new ArrayList<String>();
		drachenListe.add("Eisdrache");
		
		
		try {
			items.add(new Achilles("WindowsXP-CD", 3, true, laptopListe));
			items.add(new Achilles("Nagelrolle", 1, false, lkwListe));
			items.add(new Achilles("Esel", 1, false, ogerListe));
			items.add(new Achilles("Axt", 2, true, akazienListe));
			items.add(new Achilles("Wollknaeul", 1, true, drachenListe));
	
		}catch (InvalidAchillesZieltypException error) {
			Main.textAusgabe("Ein Achillesobjekt konnte nicht angelegt werden: " + error.achillesTyp);
			
		}
			return items;
	}
	
	public void dasSpiel(BufferedReader eingabenZugriff) throws Exception {
		
		Ziel spieler = new Ziel(); 
		
		spieler.waffenUebergabe(this.waffenLaden());
		
		spieler.itemUebergabe(this.itemLaden());
		
		Boolean exit = false;
		
		Ziel gewaehltesZiel = null;
		
		List<Ziel> dieGegner = this.zielLaden();
		
		Waffe gewaehlteWaffe = spieler.waffenGuertel.get(0);
		
		while(!exit) {
			String eingabe = new String();
		
			Main.textAusgabe(gewaehlteWaffe.beschreibung());
			Main.textAusgabe("Bitte Aktion eingeben: ", false);
			
			try {
				eingabe = eingabenZugriff.readLine();
			} catch (Exception error) {
			}
			
			if (eingabe.equals("exit")) {
				
				Main.textAusgabe("Danke fürs Spielen! Du hast " + verschwendeteKugeln.toString() + " Munition verschwendet." +  Main.ZEILENUMBRUCH, false);
				
				exit = true;
				
			} else if (eingabe.equals("angriff") || eingabe.equals("automatik") ) {
				
				Schaden schaden = new Schaden();
		
				if (eingabe.equals("angriff")) {
				
					schaden = gewaehlteWaffe.angriff();
				} else if (eingabe.equals("automatik")){
				
					schaden = gewaehlteWaffe.alternativAngriff();
				}
				
				Ziel zielZustand = this.zielTreffen(schaden, gewaehltesZiel, dieGegner);
				
			
				gewaehltesZiel = zielZustand;
				Main.textAusgabe(schaden.beschreibung());
				
				if (gewaehltesZiel != null) {
					Main.textAusgabe(gewaehltesZiel.beschreibung());
				}
				
				if (gewaehltesZiel != null) {
					
					Ziel spielerZustand = spieler;
					
					if (gewaehltesZiel.waffenGuertel != null && !gewaehltesZiel.waffenGuertel.isEmpty()) {
						
							Waffe zufallsWaffe = gewaehltesZiel.zufallsWaffe(); 
							if (zufallsWaffe != null) {
							spielerZustand = this.zielTreffen(zufallsWaffe.alternativAngriff(), spieler, dieGegner);
							}
					}
					Main.textAusgabe(Main.ZEILENUMBRUCH);
					Main.textAusgabe(spieler.spielerBeschreibung());					
					spieler = spielerZustand;
				}
				
					
			} else if (eingabe.equals("nachladen")) {
				
				if(gewaehlteWaffe instanceof Schusswaffe) {
					
					Schusswaffe helferlein = (Schusswaffe) gewaehlteWaffe; 
					
					helferlein.nachladen();
					
				}

				if (gewaehltesZiel != null) {
					
					Ziel spielerZustand = spieler;
					
					if (gewaehltesZiel.waffenGuertel != null && !gewaehltesZiel.waffenGuertel.isEmpty()) {
						
						Waffe zufallsWaffe = gewaehltesZiel.zufallsWaffe(); 
						if (zufallsWaffe != null) {
						spielerZustand = this.zielTreffen(zufallsWaffe.alternativAngriff(), spieler, dieGegner);
						}
					}
				
					Main.textAusgabe(Main.ZEILENUMBRUCH);
					Main.textAusgabe(spieler.spielerBeschreibung());
					
					spieler = spielerZustand;
				}
			
			} else if (eingabe.equals("waffenwechsel")) {
				
				String waffenTyp = new String();
				
				String waffenListe = new String();
				
				for (Waffe aktuelleWaffe : spieler.waffenGuertel) {
					
					if (!waffenListe.isEmpty()) {
						
						waffenListe = waffenListe + ", " ;
						
					}
					waffenListe = waffenListe + aktuelleWaffe.typ;
					
					
				}
				Main.textAusgabe("Folgende Waffen stehen zur Auswahl: " + waffenListe);
				Main.textAusgabe("Bitte Waffe wählen: ", false);
				
				try {
					waffenTyp = eingabenZugriff.readLine();
				} catch (Exception error) {
				}
				
				for(Waffe aktuelleWaffe : spieler.waffenGuertel) {
					if (aktuelleWaffe.typ.equals(waffenTyp)) {
						gewaehlteWaffe = aktuelleWaffe;
					}
				}
			} else if (eingabe.equals("zielauswahl")) {
				
				String zielTyp = new String();
				
				String zielListe = new String();
				
				
				for (Ziel aktuellesZiel : dieGegner) {
					
					if (!zielListe.isEmpty()) {
						
						zielListe = zielListe + ", " ;
					}
					zielListe = zielListe + aktuellesZiel.typ;;
				}
				
				Main.textAusgabe("Folgende Ziele stehen zur Auswahl: " + zielListe);
				Main.textAusgabe("Bitte Ziel wählen: ", false);
				
				try {
					zielTyp = eingabenZugriff.readLine();
				} catch (Exception error) {
				}
				
				for(Ziel aktuellesZiel : dieGegner) {
					if (aktuellesZiel.typ.equals(zielTyp)) {
						gewaehltesZiel = aktuellesZiel;
					}
				}
				if (gewaehltesZiel != null) {
					//gibt Zielbeschreibung nach zielauswahl aus
				Main.textAusgabe(gewaehltesZiel.beschreibung());
				}
				
			} else if (eingabe.equals("itemwahl")) { 
				
				Gegenstand gewaehltesItem = null;
				
				String itemTyp = new String();
				
				String itemListe = new String();
				
					for (Gegenstand aktuellesItem : spieler.itemListe) {
					
						if (!itemListe.isEmpty()) {
						
						itemListe = itemListe + ", " ;
					}
					itemListe = itemListe + aktuellesItem.typ;;
				}
				
					Main.textAusgabe("Folgende Items stehen zur Auswahl: " + itemListe);
					Main.textAusgabe("Bitte Item wählen: ", false);
					
					try {
						itemTyp = eingabenZugriff.readLine();
					} catch (Exception error) {
					}
					
					for(Gegenstand aktuellesItem : spieler.itemListe) {
						if (aktuellesItem.typ.equals(itemTyp)) {
							gewaehltesItem = aktuellesItem;
						}
					}
					
					if (gewaehltesItem != null) {
						
						spieler = this.itemAnwenden(spieler, gewaehltesZiel, dieGegner, gewaehltesItem, spieler.itemListe);
						
						if (!dieGegner.contains(gewaehltesZiel)) {
							
							gewaehltesZiel = null;
						}
						
						//gibt Zielbeschreibung nach zielauswahl aus
						Main.textAusgabe(gewaehltesItem.beschreibung());
						
					} else {
						Main.textAusgabe("Keine gültiges Item.");
					}
		
					Main.textAusgabe(spieler.spielerBeschreibung());
					
			} else {
				Main.textAusgabe("Ungültig. Verfügbare Aktionen: angriff, automatik, nachladen, waffenwechsel, zielauswahl, itemwahl, exit");
			}
			
			if(spieler == null ) {
				
				Main.textAusgabe("Du bist tot." +  Main.ZEILENUMBRUCH + "Danke fürs Spielen! Du hast " + verschwendeteKugeln.toString() + " Kugeln verschwendet." +  Main.ZEILENUMBRUCH, false);
				
				exit = true;
			}
		}
	}
	
	private Ziel zielTreffen(Schaden schaden, Ziel ziel, List<Ziel> dieGegner) {
	
		if (ziel == null || schaden == null) {
			
			if (ziel == null) {
				Main.textAusgabe("Knapp daneben ist auch vorbei.");
			}
			return ziel;
		}
		ziel.trefferPunkte = ziel.trefferPunkte - this.resistenzSchaden(ziel.physischeResistenz, schaden.physischerSchaden);
		ziel.trefferPunkte = ziel.trefferPunkte - this.resistenzSchaden(ziel.feuerResistenz, schaden.feuerSchaden);
		ziel.trefferPunkte = ziel.trefferPunkte - this.resistenzSchaden(ziel.giftResistenz, schaden.giftSchaden);
		ziel.trefferPunkte = ziel.trefferPunkte - this.resistenzSchaden(ziel.niedlichkeitsResistenz, schaden.niedlichkeitsSchaden);
		ziel.trefferPunkte = ziel.trefferPunkte - this.resistenzSchaden(ziel.kaelteResistenz, schaden.kaelteSchaden);
		ziel.trefferPunkte = ziel.trefferPunkte - this.resistenzSchaden(ziel.wasserResistenz, schaden.wasserSchaden);
		
		if (ziel.trefferPunkte <= 0) {
	
			dieGegner.remove(ziel);
		
			Main.textAusgabe(ziel.typ + " wurde ausgelöscht.");
			
			return null;
		}
		return ziel;
	}
	
	private Ziel itemAnwenden(Ziel spieler, Ziel ziel, List<Ziel> dieGegner, Gegenstand item, List<Gegenstand> itemListe) {

		Ziel spielerZustand = spieler; 
		
		if (item instanceof Medikament) {
			
			spielerZustand = this.itemAnwenden(spielerZustand, (Medikament) item);
		}
		
		if (item instanceof Achilles) {
			
			Ziel zielZustand = this.itemAnwenden(ziel, (Achilles) item);
			
			if (zielZustand == null) {
				
				dieGegner.remove(ziel);
			}
		}
		
		if (item.verbrauchbar) {
		
			item.menge = item.menge - 1;
		
			if (item.menge <= 0) {
				
				itemListe.remove(item);
			}
		}
		return spielerZustand;
	}
	
	private Ziel itemAnwenden(Ziel ziel, Medikament item) {
		
		ziel.trefferPunkte = ziel.trefferPunkte + item.heilung;
		
		if (ziel.trefferPunkte > ziel.maximaleTrefferpunkte) {
			
		ziel.trefferPunkte =  ziel.maximaleTrefferpunkte;
		}
		if (item.feuerResistenz > 0.0) {
			ziel.feuerResistenz = ziel.feuerResistenz + item.feuerResistenz; 
		}
		if (item.giftResistenz > 0.0) {
			ziel.giftResistenz = ziel.giftResistenz + item.giftResistenz;
		}
		if (item.kaelteResistenz > 0.0) {
			ziel.kaelteResistenz = ziel.kaelteResistenz + item.kaelteResistenz;
		}
		if (item.niedlichkeitsResistenz > 0.0) {
			ziel.niedlichkeitsResistenz = ziel.niedlichkeitsResistenz + item.niedlichkeitsResistenz;
		}
		
		return ziel;
	}
		
	private Ziel itemAnwenden(Ziel ziel, Achilles item) {
		
		if (ziel != null) {
			
			for (String aktuellerTyp : item.typen) {
				
				if (aktuellerTyp.equals(ziel.typ)) {
					
					Main.textAusgabe(ziel.typ + " ist K.O.");
		
					return null;
				
				}
			}
		}
		
		return ziel;
	}
		
	
	
	private Integer resistenzSchaden(Float resistenz, Integer grundSchaden) {
		
		return Math.round(new Float((1 - resistenz) * new Float(grundSchaden)));
		
	}
	
}