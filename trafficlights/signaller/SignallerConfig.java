
package trafficlights.signaller;

/**
 *
 * @author Zofia Sobocinska
 */
public class SignallerConfig {
	String pin;

	public SignallerConfig(String pin) {
		this.pin = pin;
	}
	
	public void pin(String pin) {
		this.pin = pin;
	}
	public String pin() {
		return this.pin;
	}
	
	@Override
	public String toString() {
		return pin;
	}
	
}
