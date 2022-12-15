package tn.esprit.examenblancuserproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy  //Activation de lAOP
public class ExamenBlancUserProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenBlancUserProjectApplication.class, args);
    }

}
