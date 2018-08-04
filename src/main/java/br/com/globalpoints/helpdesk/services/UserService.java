package br.com.globalpoints.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.globalpoints.helpdesk.business.entitites.User;
import br.com.globalpoints.helpdesk.business.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User upsert(User user) {
        return this.userRepository.save(user);
    }

    public User findById(String id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElse(null);
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

    public Page<User> find(int page, int count) {
        var pages = new PageRequest(page, count);
        return this.userRepository.findAll(pages);
    }
}
