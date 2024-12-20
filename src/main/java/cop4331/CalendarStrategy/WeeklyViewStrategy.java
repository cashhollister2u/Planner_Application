/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cop4331.CalendarStrategy;

import cop4331.System.PlannerSystem;
import cop4331.SharedModels.UserAccount;
import cop4331.EventComposite.Event;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import cop4331.CurrentDateDecorator.CurrentDate;
import cop4331.CurrentDateDecorator.CurrentDay;
import cop4331.CurrentDateDecorator.CurrentWeek;
import cop4331.CurrentDateDecorator.EventDate;
import cop4331.SharedViews.GridBox;

/**
 * Concrete strategy for creating the weekly calendar view.
 * @author andrewcoggins CashHollister
 */

public class WeeklyViewStrategy implements CalendarViewStrategy {
    /**
     * {@inheritDoc}
     * 
     * Creates and returns a JPanel representing the weekly calendar view.
     */
    @Override
    public JPanel createCalendarView(JFrame frame) {
        JPanel weekContainerPanel = new JPanel(new FlowLayout());
        JPanel weekCompsPanel = new JPanel(new GridLayout(0, 7));
        weekContainerPanel.add(weekCompsPanel);

        PlannerSystem systemInstance = PlannerSystem.getInstance();
        UserAccount userAccount = systemInstance.getUserAccount();
        List<Event> accountEvents = userAccount.getEvents();

        // decorator pattern to get the String value corrisponding to today
        CurrentDate currentDate = new EventDate();
        CurrentDate eventCurrentWeek = new CurrentWeek(currentDate);
        List<String> weekDays = eventCurrentWeek.getCurrentDays();
        
        // get today's date w/ CurrentDay decorator 
        CurrentDate eventCurrentDay = new CurrentDay(currentDate);
        String todayDate = eventCurrentDay.getCurrentDays().get(0).substring(0,2);

        for (int x = 0; x < weekDays.size(); x++) {
            String currDate = weekDays.get(x);
            JLabel dateString = new JLabel(currDate);

            if (currDate.substring(0,2).equals(todayDate)) {
                dateString.setForeground(Color.BLUE);
            }

            GridBox box = new GridBox(dateString, 120, 800);

            currDate = currDate.substring(0, 2);
            for (Event event : accountEvents) {
                String eventDate = event.getDate().toString().substring(8,10);
                if (currDate.equals(eventDate)){
                    WeekEvent weekEvent = new WeekEvent(event, frame);
                    box.addEvent(weekEvent);
                }
            }

            weekCompsPanel.add(box);
        }

        return weekContainerPanel;
    }
}
