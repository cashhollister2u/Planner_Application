/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SharedViews;

import MainInterfaceWindow.MainInterfaceController;
import LoginWindow.LoginController;
import CalendarWindow.CalendarController;
import AddEventWindow.AddEventController;
import UserProfileWindow.UserProfileController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;


/**
 *
 * @author cashhollister
 */
public class TaskBarController extends JPanel{
    private JFrame currentFrame;
    
    public TaskBarController(JFrame frame) {
        this.currentFrame = frame;
        
        // Create the taskbar panel
        JPanel taskbarPanel = new JPanel();
        taskbarPanel.setLayout(new GridLayout(5, 1));

        // Create taskbar buttons
        JButton homeButton = new JButton("Main Interface");
        JButton userProfileButton = new JButton("User Profile");
        JButton addEventsButton = new JButton("Add Events");
        JButton calendarButton = new JButton("Calendar");
        JButton logoutButton = new JButton("Logout");

        // Add buttons to the taskbar panel
        taskbarPanel.add(homeButton);
        taskbarPanel.add(userProfileButton);
        taskbarPanel.add(addEventsButton);
        taskbarPanel.add(calendarButton);
        taskbarPanel.add(logoutButton);
        
        this.add(taskbarPanel);
        
        // Add action listeners to the buttons
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new MainInterfaceController();
            }
        });

        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new UserProfileController();
            }
        });

        addEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new AddEventController();
            }
        });

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new CalendarController();
            }
        });
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentFrame.dispose();
                new LoginController();
            }
        });
    }
    
}