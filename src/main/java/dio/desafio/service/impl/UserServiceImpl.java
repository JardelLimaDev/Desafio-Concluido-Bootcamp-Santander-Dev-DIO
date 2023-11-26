package dio.desafio.service.impl;

import dio.desafio.domain.model.User;
import dio.desafio.domain.repository.UserRepository;
import dio.desafio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountRegistration(userToCreate.getAccount().getRegistration())){
            throw new IllegalArgumentException("Este numero de matrícula já é existente para esse ID.");
        }
        return this.userRepository.save(userToCreate);
    }
}
