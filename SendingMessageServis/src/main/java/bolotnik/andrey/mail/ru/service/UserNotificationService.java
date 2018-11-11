package bolotnik.andrey.mail.ru.service;

public interface UserNotificationService {

    void notifyUser(Integer userId, String message);
}
