package tn.esprit.examenblancuserproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examenblancuserproject.entities.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findUserByFNameAndLName(String fName , String lName);


}
