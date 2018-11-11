package bolotnik.andrey.mail.ru.service.impl;

import bolotnik.andrey.mail.ru.service.UserMessageSender;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class FiredUserNotificationServiceTest {
    @Mock
    private SmsUserMessageSender smsUserMessageSender;
    @Mock
    private EmailUserMessageSender emailUserMessageSender;

    private FiredUserNotificationService firedUserNotificationService;

    @Before
    public void before() {
        initMocks(this);

        Collection<UserMessageSender> senders = Arrays.asList(
                smsUserMessageSender,
                emailUserMessageSender
        );
        firedUserNotificationService = new FiredUserNotificationService(senders);
    }

    @Test
    public void allSendersCalledOnceWithTheSameUserIdAndMessage() {
        // given
        Integer userId = 1;
        String message = "message";

        // when
        firedUserNotificationService.notifyUser(userId, message);

        // then
        verify(smsUserMessageSender, times(1)).sendMessage(userId, message);
        verify(emailUserMessageSender, times(1)).sendMessage(userId, message);
    }
}