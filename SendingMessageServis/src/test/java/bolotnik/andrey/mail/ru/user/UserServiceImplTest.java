package bolotnik.andrey.mail.ru.user;

import bolotnik.andrey.mail.ru.services.interfaces.ServiceSendingMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;


@RunWith(PowerMockRunner.class)
public class UserServiceImplTest {

    private String smsMessage;
    private String emailMessage;

    @Mock
    private ServiceSendingMessage serviceSendingMessage;

    private Set<Integer> idList = new HashSet<>();

    @InjectMocks
    private UserService userService = new UserService();

    @Before
    public void before() {
        smsMessage = "SMS message";
        emailMessage = "Email message";
        userService.setEmailMessage(emailMessage);
        userService.setSmsMessage(smsMessage);

        smsMessage = userService.getSmsMessage();

        idList.add(1);
        idList.add(2);
        idList.add(2);

    }


    @Test
    public void doWorkTest() {
        userService.sendMessages(idList, serviceSendingMessage);

        for (Integer userId : idList) {
            verify(serviceSendingMessage).sendSMS(eq(userId), eq(smsMessage));
            verify(serviceSendingMessage).sendEmail(eq(userId), eq(emailMessage));
        }

        verify(serviceSendingMessage, times(idList.size())).sendEmail(anyInt(), eq(emailMessage));
        verify(serviceSendingMessage, times(idList.size())).sendSMS(anyInt(), eq(smsMessage));




    }

    @Test
    public void checkIdTest(){
        System.out.println("Size of userList - "+idList.size());
        for (Integer userId : idList) {
            Assert.assertTrue(userId instanceof Integer);
        }
    }


}


