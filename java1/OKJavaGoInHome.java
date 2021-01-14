import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class OKJavaGoInHome {
    public static void main(String[] args) {
        String id = "JAVA APT 777";
        
        // Call elevator
        Elevator elevator = new Elevator(id);
        elevator.callForUp(1);

        // Turn off Security
        Security security = new Security(id);
        security.off();

        // Turn on light
        Lighting lamp = new Lighting(id + " / lamp");
        lamp.on();

        Lighting chandelier = new Lighting(id + " / chandelier");
        chandelier.on();
    }
}