package tn.esprit.examenblancuserproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.examenblancuserproject.entities.Project;
import tn.esprit.examenblancuserproject.entities.Sprint;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    @Query("SELECT p FROM Project p , Sprint s where  p.id = s.project.id and s.startDate = current_date ")
    List<Project>  getProjectSprintCurrent();
}
