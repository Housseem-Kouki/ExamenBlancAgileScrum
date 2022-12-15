package tn.esprit.examenblancuserproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examenblancuserproject.entities.Sprint;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint,Integer > {

}
