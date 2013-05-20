
package trafficlights.state;

import trafficlights.signaller.Signaller;

/**
 *
 * @author Zofia Sobocinska
 */
public class Ready extends State {

	public Ready(Signaller signaller) {
		super(signaller);
	}
	
	@Override
	public String execute() {
		signaller.green().off();
		signaller.red().on();
		signaller.yellow().on();
		
		return lightsString();
	}

}
