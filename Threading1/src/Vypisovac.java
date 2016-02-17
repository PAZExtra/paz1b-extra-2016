/**
 * Vypisovacie vlakno.
 */
public class Vypisovac extends Thread {

	/**
	 * Sprava, ktoru vypisujeme.
	 */
	private String hlaska;

	/**
	 * Perioda v milisekundach s akou vypisujeme.
	 */
	private long interval;

	/**
	 * Konstruktor
	 */
	public Vypisovac(String message, long interval) {
		this.hlaska = message;
		this.interval = interval;
	}

	@Override
	public void run() {
		// Kym niekto nenastavil priznak poziadavky na prerusenie behu vlakna,
		// tak vypisujeme.
		while (!isInterrupted()) {
			System.out.println(hlaska);
			// Ak prerusime vlakno cez interrupt metodu, ked "spi" (je
			// blokovanie), tak sa hodi vynimka.

			// POZOR: Vyhodenie InterruptedException resetuje priznak poziadavky
			// na prerusenie. Preto stale treba kontrolovat isInterrupted aj
			// vynimky. Len jedno nestaci.
			try {
				Thread.sleep(interval);
			} catch (InterruptedException ignore) {
				// Ak prislo prerusenie breakneme cyklus.
				break;
			}
		}
	}

}
