import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bludisko {

	public static void najdiTrasu(File f) {

		Queue<Integer> rad = new LinkedList<Integer>();
		Scanner sc = null;
		int[][] smery = { { 0, 1, 0, -1 }, { 1, 0, -1, 0 } };

		try {
			sc = new Scanner(f);

			// zo suboru nacita rozmery pola
			int sirka = sc.nextInt();
			int vyska = sc.nextInt();

			// suradnice koncoveho policka
			int endX = 0;
			int endY = 0;

			int[][] pole = new int[vyska + 2][sirka + 2];

			// cele pole sa vyplni -2 ("bariera")
			for (int i = 0; i < vyska + 2; i++) {
				for (int j = 0; j < sirka + 2; j++) {
					pole[i][j] = -2;
				}
			}

			// vyplnia sa policka podla suboru: volne policka -1(vratane
			// koncoveho policka), zaciatocne policko = 0
			for (int i = 1; i < vyska + 1; i++) {
				String riadok = sc.next();
				for (int j = 1; j < sirka + 1; j++) {
					if (riadok.charAt(j - 1) == '.') {
						pole[i][j] = -1;
					}
					if (riadok.charAt(j - 1) == 'K') {
						pole[i][j] = -1;
						// pamatam si na akych suradniciach je koncove policko
						endX = i;
						endY = j;
					}
					if (riadok.charAt(j - 1) == 'Z') {
						pole[i][j] = 0;
						// suranice zaciatocneho policka sa "napchaju" do radu(v
						// poradi x,y)
						rad.add(i);
						rad.add(j);
					}
				}

			}

			//
			while (!rad.isEmpty()) {
				// vyberiem prve suradnice v poradi x,y
				int x = rad.poll();
				int y = rad.poll();

				// testuju sa 4 susedne policka
				for (int i = 0; i < 4; i++) {
					int susedX = x + smery[0][i];
					int susedY = y + smery[1][i];

					// ak je policko prechodne(-1), napcham jeho suradnice do
					// radu, jeho hodnota bude o 1 vacsia ako hodnota policka,
					// ktoreho je susedom
					if (pole[susedX][susedY] == -1) {
						rad.add(susedX);
						rad.add(susedY);
						pole[susedX][susedY] = pole[x][y] + 1;
					}
				}
			}

			// vypise hodnotu na koncovom policku = co je vzdialenost od
			// zaciatocneho policka
			System.out.println(pole[endX][endY]);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (sc != null)
				sc.close();
		}

	}

}
