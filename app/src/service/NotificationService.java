package service;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class NotificationService {
    private static NotificationService instance;
    private Queue<String> notifications = new LinkedList<>();

    private NotificationService() {}

    public static NotificationService getInstance() {
        if (instance == null) {
            instance = new NotificationService();
        }
        return instance;
    }

    public void notifyUser(String message) {
        notifications.add(message);
        JOptionPane.showMessageDialog(null, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    public Queue<String> getNotifications() {
        return notifications;
    }
}

