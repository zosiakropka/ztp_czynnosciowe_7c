
package trafficlights.state;

import trafficlights.signaller.Signaller;

/**
 *
 * @author Zofia Sobocinska
 */
public class Go extends State {

	public Go(Signaller signaller) {
		super(signaller);
	}
	
	@Override
	public String execute() {
		signaller.red().off();
		signaller.yellow().off();
		signaller.green().on();
		
		return lightsString();
	}

}
