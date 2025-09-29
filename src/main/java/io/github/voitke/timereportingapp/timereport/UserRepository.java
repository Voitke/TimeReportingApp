package io.github.voitke.timereportingapp.timereport;

import io.github.voitke.timereportingapp.timereport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}