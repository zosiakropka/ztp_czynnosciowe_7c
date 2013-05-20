
package trafficlights.state;

import trafficlights.signaller.Signaller;

/**
 *
 * @author Zofia Sobocinska
 */
public class Stop extends State {

	public Stop(Signaller signaller) {
		super(signaller);
	}
	
	@Override
	public String execute() {
		signaller.green().off();
		signaller.yellow().off();
		signaller.red().on();
		
		return lightsString();
	}

}
