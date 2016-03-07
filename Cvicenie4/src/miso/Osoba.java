package miso;

import java.util.*;

public class Osoba {
	/**
	 * Meno osoby
	 */
	private String meno;
	/**
	 * Zoznam deti osoby
	 */
	private List<Osoba> deti = new ArrayList<Osoba>();

	/**
	 * Konstruktor osoby v strome potomkov
	 * 
	 * @param meno
	 *            meno osoby
	 */
	public Osoba(String meno) {
		this.meno = meno;
	}

	/**
	 * Prida osobe dieta
	 * 
	 * @param dieta
	 *            referencia na pridavane dieta
	 */
	public void pridajDieta(Osoba dieta) {
		deti.add(dieta);
	}

	/**
	 * Vrati celkovy pocet potomkov osoby
	 */
	public int pocetPotomkov() {
		int pocetPotomkovDeti = 0;
		for (Osoba dieta : deti)
			pocetPotomkovDeti += dieta.pocetPotomkov();

		return pocetPotomkovDeti + deti.size();
	}

	public int pocetGeneracii() {

		if (deti.isEmpty())
			return 0;

		int maximum = 0;

		for (Osoba osoba : deti) {

			int pocet = osoba.pocetGeneracii();

			if (pocet > maximum)
				maximum = pocet;
		}

		return maximum + 1;

	}

	public void pridajDoZoznamu(List<Osoba> zoznam) {
		
		zoznam.add(this);
		
		for (Osoba dieta : deti) {
			dieta.pridajDoZoznamu(zoznam);
		}

	}
	
	public int pocetNaUrovni(int uroven) {
				
		if (uroven == 0)
			return 1;
			
		int aktualnyPocet = 0;
		
		for (Osoba osoba : deti) 
			aktualnyPocet += osoba.pocetNaUrovni(uroven - 1);
		
		return aktualnyPocet;
	}

	/**
	 * Vypise rodostrom osoby
	 */
	public void vypisRodostrom() {
		System.out.println(meno);
		for (Osoba dieta : deti)
			dieta.vypisRodostrom();
	}
	
	@Override
	public String toString() {
		return meno;
	}

	/**
	 * Main s vytvorenim stromu potomkov pre Janka
	 */
	public static void main(String[] args) {
		Osoba janko = new Osoba("Janko");
		Osoba jozko = new Osoba("Jozko");
		Osoba maria = new Osoba("Maria");
		Osoba karol = new Osoba("Karol");
		Osoba lucia = new Osoba("Lucia");
		Osoba petra = new Osoba("Petra");
		janko.pridajDieta(jozko);
		janko.pridajDieta(maria);
		janko.pridajDieta(karol);
		karol.pridajDieta(lucia);
		karol.pridajDieta(petra);
		System.out.println(janko.pocetGeneracii());
		List<Osoba> zoznam = new ArrayList<>();
		janko.pridajDoZoznamu(zoznam);
		System.out.println(zoznam);
	}
}