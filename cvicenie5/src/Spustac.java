
public class Spustac {

	public static void main(String[] args) {
		PrioritnyRad p = new PrioritnyRad(5);
		for (int j = 0; j < 5; j++) {
			int a = (int) (Math.random() * 1000);
			System.out.println("vkladam cislo: " + a);
			p.offer(a);

		}
		System.out.println("-----------------");
		for (int i = 0; i < 5; i++) 
			System.out.println("vyberam cislo: "+p.poll());
			
		
	}

}
