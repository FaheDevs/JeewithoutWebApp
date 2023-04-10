package myapp.jpa.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import myapp.dao.GroupDao;
import myapp.model.GroupTable;

@SpringBootTest
@Transactional
public class TestGroupDao {

    @Autowired
    GroupDao dao;

    @Test
    public void addAndFindGroup() {
        // Create a new group
        GroupTable g1 = new GroupTable();
        g1.setName("Group 1");

        // Add the group to the database
        dao.addGroup(g1);

        // Get the group from the database
        GroupTable g2 = dao.getGroupById(g1.getId());

        // Check that the retrieved group matches the original group
        assertEquals(g1.getId(), g2.getId());
        assertEquals(g1.getName(), g2.getName());
    }



}
