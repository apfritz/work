package de.ig.textausgabe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static final String ZEILENUMBRUCH = "\n";
	
	public static void main(String[] args) throws Exception{
		
		// System.in = Standardeingabequelle von Java für zB Texteingaben auf Konsole
		// BufferedReader ermöglicht Eingabe in Form einer Zeile nach Eingabe zu lesen
		BufferedReader eingabenZugriff = new BufferedReader(new InputStreamReader(System.in));
		
		BallerSpass ballerSpass = new BallerSpass();
		//System.out = Standardausgabe von Java zB Textausgabe auf Konsole
		Main.textAusgabe("Bitte Modus wählen: ", false);
		//Variablenzuweisung Stringobjekt um Methode equals in jedem Fall später aufrufen zu können
		String eingabe = new String();
		//leitet Anweisungsblock ein der zu erwartbaren Fehlern führen könnte 
		try {
			eingabe = eingabenZugriff.readLine();
		} 
		//erlaubt den erwartbaren Fehler aus try aufzufangen und einen A-Block auszuführen wenn Fehler eintritt
		catch (Exception error) {
		}
		
		if (eingabe.equals("Test")) {
			ballerSpass.derTest();
		} else if (eingabe.equals("Interaktiv")) {
			ballerSpass.dasSpiel(eingabenZugriff);
			
		} else {
			Main.textAusgabe("Modi verfügbar: Test und Interaktiv");
		}
	}
	
	public static void textAusgabe (String text) {
		
		Main.textAusgabe(text, true);
	}
	
	public static void textAusgabe (String text, boolean zeilenumbruch) {
		
		System.out.print(text);
		
		if (zeilenumbruch) {
			System.out.print(ZEILENUMBRUCH);
		}
	}
}

