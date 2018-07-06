package kabak.repositories;

import kabak.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("SELECT s FROM User s WHERE s.nameUser = :nameUser")
    User findByName(@Param("nameUser") String nameUser);
}
