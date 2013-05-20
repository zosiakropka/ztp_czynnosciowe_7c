package trafficlights.signaller.light;

import static trafficlights.signaller.light.Color.RED;

/**
 *
 * @author Zofia Sobocinska
 */
public class Light {

	private Color color;
	private boolean state;
	private String onString;
	private String offString;

	public Light(Color color) {
		this.color = color;
		switch (color) {
			case RED:
				setString("\033[1;41mR\033[m", "\033[1;31mr\033[m");
				break;
			case GREEN:
				setString("\033[1;42mG\033[m", "\033[1;32mg\033[m");
				break;
			case YELLOW:
				setString("\033[1;43mY\033[m", "\033[1;33my\033[m");
				break;
		}
	}

	public boolean state() {
		return state;
	}

	public void on() {
		state = true;
	}

	public void off() {
		state = false;
	}

	@Override
	public String toString() {
		return state?onString:offString;
	}

	public void log() {
		System.out.println(this);
	}
	
	private void setString(String onString, String offString) {
		this.onString = onString;
		this.offString = offString;
	}
}
