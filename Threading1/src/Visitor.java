
public class Visitor extends Thread {

	private TicketBox box;
	
	public Visitor(TicketBox box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		while (true) {
			int cislo = box.dajCislo();
			System.out.println(cislo);
		}
	}
	
}
