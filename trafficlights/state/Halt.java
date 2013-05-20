
package trafficlights.state;

import trafficlights.signaller.Signaller;

/**
 *
 * @author Zofia Sobocinska
 */
public class Halt extends State {

	public Halt(Signaller signaller) {
		super(signaller);
	}
	
	@Override
	public String execute() {
		signaller.red().off();
		signaller.green().off();
		signaller.yellow().on();
		
		return lightsString();
	}

}
