import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		// Vytvorime objekty vlakien
		Vypisovac v1 = new Vypisovac("Ahoj", 500);
		Vypisovac v2 = new Vypisovac("Java", 300);

		// Nastartujeme vlakna
		v1.start();
		v2.start();

		// Cakame na Enter v konzole (tym sa zablokuje vlakno, v ktorom bezi
		// main)
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		System.out.println("Koniec");

		// Poziadamie vypisovacie vlakna o ukoncenie
		v1.interrupt();
		v2.interrupt();
	}

}
