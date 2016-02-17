
public class Vypisovac extends Thread {

	private String hlaska;

	public Vypisovac(String hlaska) {
		this.hlaska = hlaska;
	}

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				System.out.println(hlaska);
				Thread.sleep(500);
			}
		} catch (InterruptedException ignore) {

		}
	}

}
