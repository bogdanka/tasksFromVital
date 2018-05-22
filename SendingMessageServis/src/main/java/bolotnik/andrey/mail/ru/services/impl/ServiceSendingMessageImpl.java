package bolotnik.andrey.mail.ru.services.impl;

import bolotnik.andrey.mail.ru.services.interfaces.ServiceSendingMessage;


public class ServiceSendingMessageImpl implements ServiceSendingMessage {


    @Override
    public void sendEmail(Integer id, String emailMessage) {
        System.out.println("Send email "+emailMessage+" to user "+id);
    }

    @Override
    public void sendSMS(Integer id, String smsMessage) {
        System.out.println("Send sms "+smsMessage+" to user "+id);
    }
}
