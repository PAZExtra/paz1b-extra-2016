/**
 * Generator cisel.
 */
public class TicketBox {

	// Privatna premenna uchovavajuca naposledy vygenerovane cislo.
	private int lastNumber = 1;

	/**
	 * Zamok kontrolujuci, ze s premennou number v jednom okamihu pracuje len
	 * jedno vlakno.
	 */
	private Object lock = new Object();

	/**
	 * Metoda, ktora vygeneruje cislo a vrati ho.
	 * 
	 * Poznamka: synchronized public int nextNumber je len skratka pre
	 * synchronized(this) { telo metody }
	 */
	public int nextNumber() {
		// Synchronized blok sa vykonava, len ked vlakno ziska zamok (monitor)
		// asociovany so zadanym objektom.
		synchronized (lock) {
			lastNumber++;
			if (lastNumber == 5) {
				lastNumber = 1;
			}

			return lastNumber;
		}
	}

	/**
	 * Vrati naposledy vygenerovane cislo.
	 */
	public int getLastNumber() {
		synchronized (lock) {
			return lastNumber;
		}
	}
}
