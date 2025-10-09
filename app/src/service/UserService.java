package service;

import dao.UserDAO;
import model.User;
import java.sql.SQLException;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public void addUser(User user) throws SQLException {
        userDAO.addUser(user);
    }
}

