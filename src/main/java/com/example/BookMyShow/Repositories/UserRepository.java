package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long aLong);


    Optional<User> findAllByEmail(String email);
    @Override
    User save(User entity);
}
//likjdlkfjdfhelkjelknmlkdsncnklsdjvlkdsvnlksnslsnx]\

