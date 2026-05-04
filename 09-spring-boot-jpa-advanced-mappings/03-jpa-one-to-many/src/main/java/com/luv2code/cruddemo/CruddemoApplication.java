package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
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
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            // findInstructorDetail(appDAO);
            // deleteInstructorDetail(appDAO);
            createInstructorWithCourses(appDAO);
        };
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        Instructor tempInstructor = new Instructor("Susan", "Public", "susan@luv2code.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "http://www.youtube.com",
                "Video Games");

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
        Course tempCourse2 = new Course("The Pinball Masterclass");

        // add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {

        int theId = 3;
        System.out.println("Deleting instructorDetail id: " + theId);

        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding instructorDetail id: " + theId);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        System.out.println("instructorDetail only: " + tempInstructorDetail);
        System.out.println("the associated tempInstructor: " + tempInstructorDetail.getInstructor());
        System.out.println("Done!");
    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting instructor id: " + theId);

        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
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
