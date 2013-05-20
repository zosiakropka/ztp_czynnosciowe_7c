package trafficlights.state;

import trafficlights.signaller.Signaller;

/**
 *
 * @author Zofia Sobocinska
 */
public abstract class State {

	Signaller signaller;

	public abstract String execute();

	public State(Signaller signaller) {
		this.signaller = signaller;
	}
	
	public String lightsString() {
		return ""+signaller;
	}
}
