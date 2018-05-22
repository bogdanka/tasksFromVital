package bolotnik.andrey.mail.ru.user;

import bolotnik.andrey.mail.ru.services.interfaces.ServiceSendingMessage;

import java.util.Set;


public class UserService {

    private String smsMessage;
    private String emailMessage;

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }


    public void sendMessages(Set<Integer> idList, ServiceSendingMessage serviceSendingMessage) {

        for (Integer userId : idList) {
            serviceSendingMessage.sendEmail(userId, emailMessage);
            serviceSendingMessage.sendSMS(userId, smsMessage);
        }

    }
}
