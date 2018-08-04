package br.com.globalpoints.helpdesk.business.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.globalpoints.helpdesk.business.entitites.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
