
public class Launcher2 {

	/**
	 * Demo kod ku generatoru cisel (ak nemame zamky a synchronized, sprava sa
	 * to vsetko divne).
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TicketBox box = new TicketBox();
		Visitor janko = new Visitor(box);
		Visitor jozko = new Visitor(box);

		janko.start();
		jozko.start();
	}

}
