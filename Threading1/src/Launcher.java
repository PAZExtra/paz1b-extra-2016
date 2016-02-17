import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		Vypisovac v = new Vypisovac("Ahoj");
		Vypisovac v2 = new Vypisovac("Java");
		v.start();
		v2.start();
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.out.println("Koniec");
		v.interrupt();
		v2.interrupt();
		
	}

}
