package bolotnik.andrey.mail.ru.user.impl;

import bolotnik.andrey.mail.ru.services.impl.ServiceSendingMessageToEmail;
import bolotnik.andrey.mail.ru.services.impl.ServiceSendingMessageToSMS;
import bolotnik.andrey.mail.ru.services.interfaces.ServiceSendingMessage;
import bolotnik.andrey.mail.ru.user.interfaces.UserService;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class UserServiceImpl implements UserService {

    String smsMessage = "Some message";
    String emailMessage = "Some message";

    ServiceSendingMessage smsService;
    ServiceSendingMessage emailService;


    @Override
    public void sendMessages(Set<Long> idList) {

        smsService = new ServiceSendingMessageToSMS();
        emailService = new ServiceSendingMessageToEmail();


        for (Long userId : idList) {
            smsService.sendMessage(userId, smsMessage);
            emailService.sendMessage(userId, emailMessage);
        }

    }
}
