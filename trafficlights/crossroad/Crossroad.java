package trafficlights.crossroad;

import java.util.HashMap;
import trafficlights.signaller.Signaller;
import trafficlights.state.Go;
import trafficlights.state.Halt;
import trafficlights.state.Ready;
import trafficlights.state.State;
import trafficlights.state.Stop;

/**
 *
 * @author Zofia Sobocinska
 */
public abstract class Crossroad <Key> {

	HashMap<Key, Driver> drivers = new HashMap<>();
	
	public Driver driver(Key key) {
		
		return drivers.get(key);
	}
	
	public abstract void start();
	public abstract void stop();
	
	protected void add(Key key, Signaller signaller) {
		drivers.put(key, new Driver(signaller));
	}
	
	public static class Driver {
		State stopState;
		State readyState;
		State goState;
		State haltState;
		
		public Driver(Signaller signaller) {
			stopState = new Stop(signaller);
			readyState = new Ready(signaller);
			goState = new Go(signaller);
			haltState = new Halt(signaller);
		}
	}
}
