
public class Launcher2 {

	public static void main(String[] args) {
		TicketBox box = new TicketBox();
		Visitor janko = new Visitor(box);
		Visitor jozko = new Visitor(box);
		
		janko.start();
		jozko.start();
	}

}
