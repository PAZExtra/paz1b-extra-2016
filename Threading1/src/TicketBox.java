
public class TicketBox {

	private int posledneCislo = 1;

	private final Object zamok = new Object();

	public int dajCislo() {
		synchronized (zamok) {
			posledneCislo++;
			if (posledneCislo >= 5) {
				posledneCislo = 1;
			}

			return posledneCislo;
		}
	}
	
	public synchronized int naposledyVratene() {
		return posledneCislo;
	}
	
	public int naposledyVratene2() {
		synchronized (this) {
			return posledneCislo;			
		}
	}


}
