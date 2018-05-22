package bolotnik.andrey.mail.ru.services.interfaces;



public interface ServiceSendingMessage {

    void sendEmail(Integer id, String message);
    void sendSMS(Integer id, String message);

}
