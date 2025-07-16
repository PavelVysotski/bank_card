package ru.aston.user_service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aston.user_service.repository.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM ")
    Optional<User> findBy(@Param("id") String id);

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.email) = LOWER(:email)", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM users u WHERE LOWER(u.email) = LOWER(:email) AND u.is_active = true", nativeQuery = true)
    Optional<User> findByEmailActive(@Param("email") String email);
}
