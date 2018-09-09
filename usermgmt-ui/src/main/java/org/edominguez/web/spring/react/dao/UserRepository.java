package org.edominguez.web.spring.react.dao;

import org.edominguez.web.spring.react.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Override
    void delete(User deleted);
}
