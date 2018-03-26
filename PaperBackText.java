import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaperBackText extends TextBook {

    private String registration_id;
    private double markup;

    private static List<String> registration_tracking = new ArrayList<String>();

    public PaperBackText() {
        super();
        createRegistrationID();
    }

    // Mutators - Setters
    private void setRegistrationId(String registration_id) {
        this.registration_id = registration_id;
        addRegistrationTracking(registration_id);
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    // Accessors - Getters
    public String getRegistration_id() {
        return this.registration_id;
    }

    public double getMarkup() {
        return this.markup;
    }

    private String generateRegistrationID() {
        Random r = new Random();
        int[] rand_ints = r.ints(4, 0, 65536).toArray();
        String registration_id = "";
        for (int i=0; i < rand_ints.length; i++) {
            registration_id += String.format("%04X", rand_ints[i]);
            if (i < rand_ints.length - 1) {
                registration_id += "-";
            }
        }
        return registration_id;
    }

    private void addRegistrationTracking(String registration_id) {
        registration_tracking.add(registration_id);
    }

    private void createRegistrationID() {
        String registration_id = generateRegistrationID();
        boolean unique = checkUnique(registration_id, registration_tracking);
        if (unique) {
            setRegistrationId(registration_id);
        }
        else {
            createRegistrationID();
        }
    }
}
