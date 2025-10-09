//package test;
//
//import model.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import service.AuthService;
//import java.sql.SQLException;
//
//public class AuthServiceTest {
//    private AuthService authService;
//
//    @BeforeEach
//    public void setUp() {
//        authService = new AuthService();
//    }
//
//    @Test
//    public void testAuthenticateWithInvalidUser() throws SQLException {
//        User user = authService.authenticate("invalid@example.com", "wrong");
//        Assertions.assertNull(user);
//    }
//}
//
