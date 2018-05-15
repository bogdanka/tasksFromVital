package bolotnik.andrey.mail.ru.user.interfaces;

import java.util.Set;


public interface UserService {

    void sendMessages(Set<Long> id);
}
