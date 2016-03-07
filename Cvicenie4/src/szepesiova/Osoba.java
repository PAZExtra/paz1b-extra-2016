package szepesiova;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Vypise rodostrom osoby
	 */
	public void vypisRodostrom() {
		System.out.println(meno);
		for (Osoba dieta : deti)
			dieta.vypisRodostrom();
	}

	public int pocetGeneracii() {
		int vysledok = 0;

		for (Osoba dieta : deti) {
			vysledok = Math.max(vysledok, dieta.pocetGeneracii() + 1);
		}

		return vysledok;
	}

	public int pocetNaUrovni(int uroven) {
		int pocet = 0;
		if (uroven == 0) {
			return 1;
		}

		for (Osoba dieta : deti) {
			pocet += dieta.pocetNaUrovni(uroven - 1);
		}

		return pocet;
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
		janko.vypisRodostrom();
		System.out.println(janko.pocetNaUrovni(2));
	}
}