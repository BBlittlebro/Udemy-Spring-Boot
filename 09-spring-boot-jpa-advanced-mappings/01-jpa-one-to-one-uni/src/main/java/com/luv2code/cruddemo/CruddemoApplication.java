package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            createInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {

//        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//        InstructorDetail tempInstructorDetail = new InstructorDetail(
//                "http://www.luv2coe.com/youtube",
//                "Luv 2 code!!!");

        Instructor tempInstructor = new Instructor("Andy", "Wu", "andy@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.luv2coe.com/youtube",
                "Gaming");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // NOTE: this will ALSO save the details object because of CascadeType.ALL
        System.out.println("Saving instructor:" + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done!");
    }
}
