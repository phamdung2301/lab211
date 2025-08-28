/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.ArrayList;
import java.util.List;
import object.Task;
import object.TaskType;

/**
 *
 * @author ADMIN
 */
public class ManagerTask {

    private List<Task> taskList;

    public ManagerTask() {
        this.taskList = new ArrayList<>();
    }

    private void getTaskType(TaskType taskType) {
        String[] task = {"code", "Test", "Design", "Review"};
        printTask(task);
        int choice = Validation.getInt("Enter task type: ", 1, 4);
        taskType.setTaskID(choice);
        taskType.setDescription(task[choice - 1]);
    }

    private void printTask(String[] task) {
        System.out.println("AVAIABLE TASK");
        for (int i = 0; i < task.length; i++) {
            System.out.println((i + 1) + " = " + task[i]);
        }
    }

    public void addTask() {

        int ID;
        if (taskList.isEmpty()) {
            ID = 1;
        } else {
            ID = taskList.get(taskList.size() - 1).getId() + 1;
        }

        String requirementName = Validation.getString("Enter requirement Name: ", "[A-Za-z\\s]+");
        TaskType taskType = new TaskType();
        getTaskType(taskType);

        String date = Validation.getDate("Enter date: ");

        double planFrom, planTo;
        do {
            planFrom = Validation.getDouble("Enter planFrom: ", 8, 17.5);
            planTo = Validation.getDouble("ENter planTo: ", planFrom + 0.5, 17.5);

            if (!checkHoursAndOverLap(requirementName, date, planFrom, planTo)) {
                System.out.println("Invalid input for time. Please enter again: ");
            } else {
                break;
            }
        } while (true);

        String assignee = Validation.getString("Enter assignee ", "[A-Za-z\\s]+");
        String review = Validation.getString("Enter review: ", "[A-Za-z\\s]+");
        taskList.add(new Task(ID, taskType, requirementName, date, planFrom, planTo, assignee, review));
        System.out.println("Add task Successfully!!!");
    }

    public void deleteTask() {
        int ID = Validation.getInt("Enter ID you wanna delete: ", 1, taskList.size());
        for (Task task : taskList) {
            if (task.getId() == ID) {
                System.out.print("Task found. Are you sure delete task(Y/N)");
                boolean choice = Validation.checkInputYN();
                if (choice) {
                    taskList.remove(task);
                    return;
                } else {
                    System.out.println("Canceled delete!!!");
                    break;
                }
            }
        }
        System.out.println("ID not found in the database!!!");
    }

    public void displayTask() {
        if (taskList.isEmpty()) {
            System.out.println("No task for display!!!");
            return;
        }

        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s%n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");

        for (Task task : taskList) {
            double time = task.getPlanTo() - task.getPlanFrom();
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s%n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskType().getDescription(),
                    task.getDate(),
                    time,
                    task.getAssignee(),
                    task.getReviewer());
        }
    }

    private boolean checkHoursAndOverLap(String requirementName, String date, double planFrom, double planTo) {
        double totalHours = 0;
        for (Task task : taskList) {
            if (task.getRequirementName().equals(requirementName) && task.getDate().equals(date)) {
                if (planFrom < task.getPlanTo() && planTo > task.getPlanFrom()) {
                    System.out.println("The nem task must not overlap with the existing task time: ");
                    return false;
                }
                totalHours += task.getPlanTo() - task.getPlanFrom();
            }
        }
        totalHours += planTo - planFrom;
        if (totalHours >= 8) {
            System.out.println("The total working hours for this requirement is one day cannot excced 8 hours");
            return false;
        }
        return true;
    }
}
