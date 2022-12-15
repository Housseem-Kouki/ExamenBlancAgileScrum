package tn.esprit.examenblancuserproject.services;

import tn.esprit.examenblancuserproject.entities.Project;
import tn.esprit.examenblancuserproject.entities.Sprint;
import tn.esprit.examenblancuserproject.entities.User;

import java.util.List;

public interface IService {
    public List<User> getAllUsers();
    public List<Project> getAllProjects();
    public List<Sprint> getAllSprints();
    public User addUser(User u);

    public Project addProject(Project project);

    public void assignProjectToDeveloper(int projectId , int devId);
    public void assignProjectToScrumMaster(int projectId , String fName , String lName);

    public  List<Project> getProjectsByScrumMaster(String fName , String lName);

    public void addSprintAndAssignToProject(Sprint sprint , int idProject);

    public void getProjectsCurrentSprints();


}
