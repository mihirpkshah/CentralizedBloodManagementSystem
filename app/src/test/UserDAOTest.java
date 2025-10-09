//package test;
//
//import dao.UserDAO;
//import model.User;
//import org.junit.jupiter.api.*;
//import java.sql.SQLException;
//
//public class UserDAOTest {
//    private UserDAO userDAO;
//
//    @BeforeEach
//    public void setUp() {
//        userDAO = new UserDAO();
//    }
//
//    @Test
//    public void testAddAndGetUser() throws SQLException {
//        User user = new User(0, "Test User", "test@example.com", "hash", "donor", "1234567890", "Test Address");
//        userDAO.addUser(user);
//        User fetched = userDAO.getUserByEmail("test@example.com");
//        Assertions.assertNotNull(fetched);
//        Assertions.assertEquals("Test User", fetched.getName());
//    }
//}
//
