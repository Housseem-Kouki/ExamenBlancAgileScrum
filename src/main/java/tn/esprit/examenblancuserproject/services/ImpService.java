package tn.esprit.examenblancuserproject.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examenblancuserproject.entities.Project;
import tn.esprit.examenblancuserproject.entities.Sprint;
import tn.esprit.examenblancuserproject.entities.User;
import tn.esprit.examenblancuserproject.repository.ProjectRepository;
import tn.esprit.examenblancuserproject.repository.SprintRepository;
import tn.esprit.examenblancuserproject.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ImpService implements IService{
    UserRepository userRepository;
    ProjectRepository projectRepository;
    SprintRepository sprintRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    @Transactional
    public Project addProject(Project p) {
        for(Sprint s : p.getSprints()){
            s.setProject(p);
            sprintRepository.save(s);
        }
        return projectRepository.save(p);
    }

    @Override
    public void assignProjectToDeveloper(int projectId, int devId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(devId).orElse(null);

        user.getProjects().add(project);
        project.getUsers().add(user);
        userRepository.save(user);


    }

    @Override
    public void assignProjectToScrumMaster(int projectId, String fName, String lName) {
        User user = userRepository.findUserByFNameAndLName(fName,lName);
        Project project = projectRepository.findById(projectId).orElse(null);


        project.getUsers().add(user);
        user.getProjectsMaster().add(project);
        userRepository.save(user);
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        User user = userRepository.findUserByFNameAndLName(fName,lName);
        // Set<Project> listProject = user.getProjectsMaster();
        List<Project> listProject = new ArrayList<>(user.getProjectsMaster());
        return listProject;
    }

    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        sprint.setProject(project);
        sprintRepository.save(sprint);
    }

    @Override
    @Scheduled(cron = "*/30 * * * * *" )
    public void getProjectsCurrentSprints() {
        List<Project> projectList = projectRepository.getProjectSprintCurrent();
        System.out.println("****** Les projets on sprint aujourdhui *************");

        for(Project p : projectList){
            System.out.println(p.toString());
        }
    }
}
