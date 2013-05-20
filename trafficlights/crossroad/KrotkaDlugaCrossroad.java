package trafficlights.crossroad;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import trafficlights.signaller.Signaller;
import trafficlights.signaller.SignallerConfig;

/**
 *
 * @author Zofia Sobocinska
 */
public class KrotkaDlugaCrossroad extends Crossroad<Direction> {

	Thread handler;

	public KrotkaDlugaCrossroad() {
		add(Direction.KROTKA, new Signaller(new SignallerConfig("\033[1;34mkrotka\033[m")));
		add(Direction.DLUGA, new Signaller(new SignallerConfig("\033[1;35m dluga\033[m")));

		handler = new HandleThread(drivers);
	}

	@Override
	public void start() {
		handler.start();
	}

	@Override
	public void stop() {
		handler.interrupt();
	}
}

class HandleThread extends Thread {

	HashMap<Direction, Crossroad.Driver> drivers;

	public HandleThread(HashMap<Direction, Crossroad.Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public void run() {
		String dluga, krotka;
		int s=1000;
		int stableTime = 7*s;
		int shitfTime = 1*s;
		int prepareTime = 3*s;
		try {
			do {
				dluga = drivers.get(Direction.DLUGA).stopState.execute();
				print(dluga);
				sleep(shitfTime);
				krotka = drivers.get(Direction.KROTKA).goState.execute();
				print(krotka);
				sleep(stableTime);

				krotka = drivers.get(Direction.KROTKA).haltState.execute();
				print(krotka);
				dluga = drivers.get(Direction.DLUGA).readyState.execute();
				print(dluga);
				sleep(prepareTime);

				krotka = drivers.get(Direction.KROTKA).stopState.execute();
				print(krotka);
				sleep(shitfTime);
				dluga = drivers.get(Direction.DLUGA).goState.execute();
				print(dluga);
				sleep(stableTime);

				dluga = drivers.get(Direction.DLUGA).haltState.execute();
				print(dluga);
				krotka = drivers.get(Direction.KROTKA).readyState.execute();
				print(krotka);
				sleep(prepareTime);

			} while (!isInterrupted());
		} catch (InterruptedException ex) {
			Logger.getLogger(HandleThread.class.getName()).log(Level.SEVERE, null, ex);
			interrupt();
		}
	}

	public void print(String street) {
		System.out.println(street);
		System.out.flush();
	}

	public void print(String[] streets) {
		for (String street : streets) {
			System.out.println(street);
		}
		System.out.flush();
	}
}

enum Direction {

	KROTKA, DLUGA
}