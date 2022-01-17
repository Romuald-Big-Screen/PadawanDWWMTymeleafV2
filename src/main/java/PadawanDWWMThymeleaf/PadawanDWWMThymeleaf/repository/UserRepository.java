package PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.repository;



import PadawanDWWMThymeleaf.PadawanDWWMThymeleaf.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from users where userName = :userName", nativeQuery = true)
    public Optional<User> findUserByEmail(String email);

}
