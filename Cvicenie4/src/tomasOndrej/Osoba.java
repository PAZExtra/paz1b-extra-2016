package tomasOndrej;

import java.util.ArrayList;
import java.util.List;

public class Osoba {
	private String meno;
	private List<Osoba> deti = new ArrayList<Osoba>();

	public Osoba(String meno) {
		this.meno = meno;
	}

	public void pridajDieta(Osoba dieta) {
		deti.add(dieta);
	}

	public void vypisMeno() {
		System.out.println(meno);
	}

	public int sirkaStromu(int u) {
		int vysledok = 0;

		if (u == 0) 
			return 1;
			
		for (Osoba dieta : deti) 		
			vysledok += dieta.sirkaStromu(u - 1);
		
		return vysledok;

	}

	public int pocetGeneracii() {
		int maxGeneracii = 0;
		
		for (Osoba dieta : deti)
			maxGeneracii = Math.max(maxGeneracii, dieta.pocetGeneracii() + 1);
		
		return maxGeneracii;
	}

	public void pridajDoZoznamu(List<Osoba> zoznam) {
		zoznam.add(this);

		for (Osoba dieta : deti) {
			dieta.pridajDoZoznamu(zoznam);
		}
	}

	public static Uzol stromZRetazca(String opisStromu) {
		int pocitadlo = 0, index = 0, stred = 0, zpi = 0;
		
		for (int i = 0; i < opisStromu.length(); i++) {
			if (opisStromu.charAt(i) == '(')
				pocitadlo++;
			
			if (opisStromu.charAt(i) == ')')
				pocitadlo--;
			
			if (pocitadlo == 0)
				index = i + 1;
			
			if (pocitadlo == 0 && opisStromu.charAt(i) == '(' || i == opisStromu.length() - 1) {
				stred = Integer.parseInt(opisStromu.substring(index, i - 1));
				zpi = i;
			}		
		}

		String lavy = opisStromu.substring(0, index - 1);
		String pravy = opisStromu.substring(zpi, opisStromu.length());
		return new Uzol(stred, stromZRetazca(lavy), stromZRetazca(pravy));
	}

}