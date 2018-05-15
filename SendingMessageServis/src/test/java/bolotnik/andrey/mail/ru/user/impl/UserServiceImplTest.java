package bolotnik.andrey.mail.ru.user.impl;

import bolotnik.andrey.mail.ru.services.impl.ServiceSendingMessageToEmail;
import bolotnik.andrey.mail.ru.services.impl.ServiceSendingMessageToSMS;
import bolotnik.andrey.mail.ru.services.interfaces.ServiceSendingMessage;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by dron on 15.05.2018.
 */
public class UserServiceImplTest {
    @Test
    public void sendMessages() throws Exception {
        ServiceSendingMessage mockSms = mock(ServiceSendingMessageToSMS.class);
        ServiceSendingMessage mockEmail = mock(ServiceSendingMessageToEmail.class);




    }

}