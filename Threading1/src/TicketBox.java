
public class TicketBox {

	private int posledneCislo = 1; 
	
	public int dajCislo() {
		posledneCislo++;
		if (posledneCislo == 5) {
			posledneCislo = 1;
		}
		
		return posledneCislo;
	}
	
}
