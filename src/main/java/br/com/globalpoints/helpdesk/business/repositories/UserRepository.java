package br.com.globalpoints.helpdesk.business.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.globalpoints.helpdesk.business.entitites.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UserRepository extends MongoRepository<User, String> {
}
