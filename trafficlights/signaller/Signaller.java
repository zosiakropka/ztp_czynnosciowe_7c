package trafficlights.signaller;

import trafficlights.signaller.light.Light;
import trafficlights.signaller.light.Color;

/**
 *
 * @author Zofia Sobocinska
 */
public class Signaller {

	SignallerConfig config;
	
	public Signaller (SignallerConfig config) {
		this.config = config;
	}
	
	Light red = new Light(Color.RED);
	Light yellow = new Light(Color.YELLOW);
	Light green = new Light(Color.GREEN);

	public Light red() {
		return red;
	}
	public Light yellow() {
		return yellow;
	}
	public Light green() {
		return green;
	}
	
	@Override
	public String toString() {
		return config+":"+red+yellow+green;
	}
}
