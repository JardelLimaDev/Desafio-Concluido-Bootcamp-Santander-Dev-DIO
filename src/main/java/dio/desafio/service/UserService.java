package dio.desafio.service;

import dio.desafio.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findById (Long id);
    User create (User userToCreate);
}
