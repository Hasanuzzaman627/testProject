package helpers.mail;
import java.util.HashMap;
import static helpers.mail.ReadEmail.check;

public class EmailService {
    public static void main(String[] args) throws InterruptedException {
        email();
    }
    public static HashMap<String, String> email() throws InterruptedException {
        Thread.sleep(15000);
        String host = "imap.gmail.com";
        String username = "noreply.technonext@gmail.com";
        String password = "fmqsvzogfczxrzuk";
        HashMap<String, String> email = check(host, "verification_code", username, password);
        System.out.println(email.get("Body"));
        return email;
    }

}
