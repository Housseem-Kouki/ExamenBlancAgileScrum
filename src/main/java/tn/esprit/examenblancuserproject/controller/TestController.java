package tn.esprit.examenblancuserproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examenblancuserproject.entities.Project;
import tn.esprit.examenblancuserproject.entities.Sprint;
import tn.esprit.examenblancuserproject.entities.User;
import tn.esprit.examenblancuserproject.repository.UserRepository;
import tn.esprit.examenblancuserproject.services.IService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TestController {
    IService iService;
    UserRepository userRepository;

    @GetMapping("/AllUsers")
    @ResponseBody
    public List<User> AllUsers(){
        return iService.getAllUsers();
    }

    @GetMapping("/AllProjects")
    @ResponseBody
    public List<Project> AllProject(){
        return iService.getAllProjects();
    }

    @GetMapping("/AllSprints")
    @ResponseBody
    public List<Sprint> AllSprints(){
        return iService.getAllSprints();
    }

    @PostMapping("/addUser")
    @ResponseBody
    public User addUser(@RequestBody User user){
        return iService.addUser(user);
    }

    @PostMapping("/addProject")
    @ResponseBody
    public Project addProject(@RequestBody Project project){
        return iService.addProject(project);
    }

    @PostMapping("/assignProjectToDeveloper/{projectId}/{devId}")
    @ResponseBody
    public void assignProjectToDeveloper(@PathVariable("projectId")int projectId ,@PathVariable("devId")int devId ){
         iService.assignProjectToDeveloper(projectId,devId);
    }


    @PostMapping("/assignProjectToScrumMaster/{projectId}/{fName}/{lName}")
    @ResponseBody
    public void assignProjectToScrumMaster(@PathVariable("projectId")int projectId
            ,@PathVariable("fName")String fName ,@PathVariable("lName")String lName  ){
        iService.assignProjectToScrumMaster(projectId,fName,lName);
    }

    @PostMapping("/gestUserByNomPrenom/{fName}/{lName}")
    @ResponseBody
    public void gestUserByNomPrenom(@PathVariable("fName")String fName ,@PathVariable("lName")String lName  ){
        userRepository.findUserByFNameAndLName(fName,lName);
    }


    @GetMapping("/getProjectsByScrumMaster/{fName}/{lName}")
    @ResponseBody
    public List<Project> getProjectsByScrumMaster(@PathVariable("fName")String fName ,@PathVariable("lName")String lName  ){
      return iService.getProjectsByScrumMaster(fName,lName);
    }



    @PostMapping("/addSprintAndAssignToProject/{idProject}")
    @ResponseBody
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint ,@PathVariable("idProject")int idProject  ){
         iService.addSprintAndAssignToProject(sprint,idProject);
    }
}
