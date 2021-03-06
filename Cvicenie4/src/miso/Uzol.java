package miso;

/**
 * Trieda reprezentujuca uzol binarneho stromu
 */
public class Uzol {
	/**
	 * Hodnota ulozena v uzle stromu
	 */
	private int hodnota;

	/**
	 * Referencia na laveho syna uzla (koren laveho podstromu)
	 */
	private Uzol lavy;

	/**
	 * Referencia na praveho syna uzla (koren praveho podstromu)
	 */
	private Uzol pravy;

	/**
	 * Konstruktor uzla binarneho stromu
	 * 
	 * @param hodnota
	 * @param lavy
	 * @param pravy
	 */
	public Uzol(int hodnota, Uzol lavy, Uzol pravy) {
		this.hodnota = hodnota;
		this.lavy = lavy;
		this.pravy = pravy;
	}

	/**
	 * Vypise obsah uzlov stromu, ktoreho korenom je tento vrchol. Realizuje
	 * preorder prechod.
	 */
	public void vypis() {
		// Vypiseme hodnotu
		System.out.println(hodnota);

		// Ak je lavy syn, poziadame ho o vypis hodnot laveho podstromu
		if (lavy != null)
			lavy.vypis();

		// Ak je pravy syn, poziadame ho o vypis hodnot praveho podstromu
		if (pravy != null)
			pravy.vypis();
	}

	/**
	 * Vrati maximum v strome, ktoreho je tento uzol korenom
	 */
	public int maximum() {
		// Predpokladame, ze maximum je hodnota v tomto uzle
		int vysledok = hodnota;

		// Ak je lavy syn, vyberieme bud maximum z laveho podstromu
		// alebo hodnotu v tomto uzle - podla toho, co je vacsie
		if (lavy != null)
			vysledok = Math.max(vysledok, lavy.maximum());

		// Ak je pravy syn, skusime, ci maximum v pravom podstrome nie je
		// vacsie
		if (pravy != null)
			vysledok = Math.max(vysledok, pravy.maximum());

		return vysledok;
	}

	/**
	 * Zisti, ci sa zadana hodnota nachadza v strome, ktoreho je tento uzol
	 * korenom
	 * 
	 * @param hladany
	 *            hladana hodnota
	 */
	public boolean obsahuje(int hladany) {
		// Ak je hladana hodnota v tomto uzle, koncime ihned
		if (hodnota == hladany)
			return true;

		// Ak je lavy syn, skusime, ci hladana hodnota nie je v podstrome,
		// ktoreho je lavy syn korenom
		if (lavy != null)
			if (lavy.obsahuje(hladany))
				return true;

		// Ak je pravy syn, skusime, ci hladana hodnota nie je v podstrome,
		// ktoreho je pravy syn korenom
		if (pravy != null)
			if (pravy.obsahuje(hladany))
				return true;

		return false;
	}

	public static Uzol stromZRetazca(String opisStromu) {

		if (opisStromu.equals(""))
			return null;

		System.out.println(opisStromu);

		int zatvorky = 0;

		int index = 0;

		for (int i = 0; i < opisStromu.length(); i++) {

			char c = opisStromu.charAt(i);

			if (c == ' ')
				continue;

			if (c == '(')
				zatvorky++;

			if (c == ')')
				zatvorky--;

			if (zatvorky == 0) {
				index = i + 1;
				break;
			}
		}

		String lavyOpisStromu = null;

		if (index > 1)
			lavyOpisStromu = opisStromu.substring(1, index - 1);

		StringBuilder sb = new StringBuilder();

		while (index < opisStromu.length()) {

			char c = opisStromu.charAt(index);

			if (c == ' ') {
				index++;
				continue;
			}

			if (c < '0' || c > '9')
				break;

			sb.append(c);
			index++;
		}

		String pravyOpisStromu = null;

		if (index != opisStromu.length())
			pravyOpisStromu = opisStromu.substring(index + 1, opisStromu.length() - 1);

		int koren = Integer.parseInt(sb.toString().trim());

		return new Uzol(koren, stromZRetazca(lavyOpisStromu.trim()), stromZRetazca(pravyOpisStromu.trim()));

	}

	public int getHodnota() {
		return hodnota;
	}

	public void setHodnota(int hodnota) {
		this.hodnota = hodnota;
	}

	public static void main(String[] args) {
		// Uzol koren = new Uzol(5, new Uzol(2, new Uzol(8, null, null), null),
		// new Uzol(9, null, null));
		// koren.vypis();
		Uzol novyUzol = stromZRetazca("((2) 7 ((5) 6 (11))) 2 (5 ((4) 9))");
		novyUzol.vypis();
		// System.out.println("Maximum je " + koren.maximum());
	}
}