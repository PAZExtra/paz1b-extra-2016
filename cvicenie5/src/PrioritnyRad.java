import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrioritnyRad {
	public int[] pole;
	private int pocetPrvkov = 0;

	public PrioritnyRad(int kapacita) {
		pole = new int[kapacita];
	}

	public boolean offer(int cislo) {
		if (pocetPrvkov > pole.length)
			return false;

		pole[pocetPrvkov] = cislo;
		uhaldujSpat(pocetPrvkov);
		pocetPrvkov++;
		return true;
	}

	void uhaldujSpat(int poslednyIdx) {
		int aktualny = poslednyIdx;

		while (aktualny > 0) {

			int rodic = (aktualny - 1) / 2;

			if ((pole[rodic] < pole[aktualny]))
				vymen(rodic, aktualny);
			else
				break;

			aktualny = rodic;
		}

	}

	public int poll() {
		if (pocetPrvkov == 0) {
			return -1;
		}
		int max = pole[0];
		pocetPrvkov--;
		vymen(pocetPrvkov, 0);

		uhalduj(pole, 0, pocetPrvkov - 1);
		return max;
	}

	public boolean isEmpty() {
		return pocetPrvkov == 0;
	}

	void uhalduj(int[] p, int narusitelIdx, int poslednyIdx) {
		while (true) {
			int najvacsiIdx = narusitelIdx;
			int lavySynIdx = narusitelIdx * 2 + 1;
			int pravySynIdx = narusitelIdx * 2 + 2;
			if ((lavySynIdx <= poslednyIdx) && (p[lavySynIdx] > p[najvacsiIdx]))
				najvacsiIdx = lavySynIdx;
			if ((pravySynIdx <= poslednyIdx) && (p[pravySynIdx] > p[najvacsiIdx]))
				najvacsiIdx = pravySynIdx;
			if (najvacsiIdx == narusitelIdx)
				break;
			vymen(narusitelIdx, najvacsiIdx);
			narusitelIdx = najvacsiIdx;
		}
	}

	void vytvorHaldu(int[] p) {
		for (int korenIdx = p.length - 1; korenIdx >= 0; korenIdx--)
			uhalduj(p, korenIdx, p.length - 1);
	}

	void vymen(int a, int b) {
		int d = pole[a];
		pole[a] = pole[b];
		pole[b] = d;

	}
}