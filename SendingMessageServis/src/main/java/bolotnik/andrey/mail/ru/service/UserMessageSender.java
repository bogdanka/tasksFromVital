package bolotnik.andrey.mail.ru.service;

public interface UserMessageSender {

    void sendMessage(Integer userId, String message);
}
