package edu.sharif.webclass.security.JWT.Prac.repositories;

import edu.sharif.webclass.security.JWT.Prac.models.EndUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EndUserRepository extends CrudRepository<EndUser,Integer> {
    Optional<EndUser> findEndUserByUserName(String userName);
}
