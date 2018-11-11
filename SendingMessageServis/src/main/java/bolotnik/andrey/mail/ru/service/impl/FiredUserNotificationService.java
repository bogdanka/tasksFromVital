package bolotnik.andrey.mail.ru.service.impl;

import bolotnik.andrey.mail.ru.service.UserMessageSender;
import bolotnik.andrey.mail.ru.service.UserNotificationService;

import java.util.Collection;

public class FiredUserNotificationService implements UserNotificationService {
    private Collection<UserMessageSender> userMessageSenders;

    public FiredUserNotificationService(Collection<UserMessageSender> userMessageSenders) {
        this.userMessageSenders = userMessageSenders;
    }

    @Override
    public void notifyUser(final Integer userId, final String message) {
        if (userMessageSenders != null && userMessageSenders.size() > 0) {
            userMessageSenders.forEach(sender -> sender.sendMessage(userId, message));
        }
    }
}
