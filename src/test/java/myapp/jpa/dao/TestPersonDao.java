package myapp.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import myapp.dao.PersonDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import myapp.model.Person;

@SpringBootTest
public class TestPersonDao {

    @Autowired
    PersonDao dao;

    @Test
    public void addAndFindPerson() {
        // Create a new person
        Person p1 = new Person();
        p1.setFirstName("Jean");
        p1.setEmail("jean@gmail.com");
        p1.setPassword("password123");

        // Add the person to the database
        dao.addPerson(p1);

        // Get the person from the database
        Person p2 = dao.getPersonById(p1.getId());

        // Check that the retrieved person matches the original person
        assertEquals(p1.getId(), p2.getId());
        assertEquals(p1.getFirstName(), p2.getFirstName());
        assertEquals(p1.getEmail(), p2.getEmail());
        assertEquals(p1.getPassword(), p2.getPassword());
    }



}