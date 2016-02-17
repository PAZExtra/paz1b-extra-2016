/**
 * Navstevnik pytajuci si cisla.
 */
public class Visitor extends Thread {

	/**
	 * Generator cisel, ktore pouziva navstevnik
	 */
	private TicketBox box;

	/**
	 * Konstruktor s referenciou na pouzivany ticket generator.
	 * 
	 * @param box
	 *            generator tiketov s cislami.
	 */
	public Visitor(TicketBox box) {
		this.box = box;
	}

	@Override
	public void run() {
		/**
		 * V slucke si pytame cisla.
		 */
		while (true) {
			int numberOfTicket = box.nextNumber();
			System.out.println(numberOfTicket);
		}
	}

}
