package real_spring;

public class MessengerEMail implements Messenger {
    @Override
    public void sendMessage(String email, String message) {
        System.out.println("Message " + message + " ass was sent to " + email);
    }
}
