import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.DimmingLights;

public class OKJavaGoInHomeInput {
    // parameter, 매개변수
    public static void main(String[] args) {
        String id = args[0];
        String bright = args[1];
    
        // Call elevator
        Elevator elevator = new Elevator(id);
        elevator.callForUp(1);

        // Turn off Security
        Security security = new Security(id);
        security.off();

        // Turn on light
        Lighting lamp = new Lighting(id + " / lamp");
        lamp.on();

        DimmingLights chandelier = new DimmingLights(id + " / chandelier");
        chandelier.setBright(Double.parseDouble(bright));
        chandelier.on();
    }
}
