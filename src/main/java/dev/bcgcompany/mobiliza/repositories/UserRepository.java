package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);
}
