package br.com.globalpoints.helpdesk.business.repositories;

import br.com.globalpoints.helpdesk.business.entitites.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
