package com.irq3.infrastructure.repositories;

import com.irq3.domain.models.User;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.H2)
public interface UserRepository extends CrudRepository<User, Long>{

    Optional<User> getUserByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
