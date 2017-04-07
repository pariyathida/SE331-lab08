package camt.cbsd.config;

import camt.cbsd.dao.StudentDao;
import camt.cbsd.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by CAMT on 4/7/2017.
 */
@ConfigurationProperties(prefix="server")
@Component
public class DataLoader implements ApplicationRunner {
    StudentDao studentDao;
    @Autowired
    public void setStudentDao(StudentDao studentDao){
        this.studentDao = studentDao;
    }
    String baseUrl;
    String imageUrl;
    String imageBaseUrl;
    public void setBaseUrl (String baseUrl){
        this.baseUrl = baseUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        imageBaseUrl = baseUrl + imageUrl;
        studentDao.addStudent(Student.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu").gpa(2.15).image(imageBaseUrl+"mitsuha.jpg").feature(true).penAmount(0).description("The most beloved one").build());
        studentDao.addStudent(Student.builder().studentId("SE-002").name("Prayuth").surname("The minister").gpa(3.59).image(imageBaseUrl+"Tu.gif").feature(false).penAmount(15).description("The great man ever").build());
        studentDao.addStudent(Student.builder().studentId("SE-003").name("Jurgen").surname("Kloop").gpa(2.15).image(imageBaseUrl+"Kloop.gif").feature(true).penAmount(2).description("The man for the Kop").build());

        Student student = new Student(1,"SE-001","Mitsuha","Miyamizu",2.15,imageBaseUrl+"mitsuha.gif",true,0,"The most beloved one");

    }
}
