package ejercicio2jas2d3.services;

import ejercicio2jas2d3.models.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Zihao Wang
 */
public final class TaskManager {

    public TaskManager() {
        TreeMap<String, List<Task>> tree = new TreeMap<>();
        showTasks(tree);
    }

    public TreeMap<String, List<Task>> taskCreator(TreeMap<String, List<Task>> tree, String mainTask) {
        Scanner sc = new Scanner(System.in);
        List<Task> subTask = new ArrayList<>();
        System.out.println("Enter the main Task name ");
        mainTask = sc.nextLine();
        String subs = "1";
        while (!subs.equals("0")) {
            System.out.println("Enter the SubTask");
            subTask.add(new Task(sc.nextLine()));
            tree.put(mainTask, subTask);
            System.out.println("""
                           Enter
                           0 for EXIT
                           Any number for continue
                           """);
            subs = sc.nextLine();
        }
        System.out.println("""
                           Enter
                           0 for EXIT
                           1 for Add
                           """);
        int choice = sc.nextInt();
        if (choice == 1) {
            taskCreator(tree, mainTask);
        }
        return tree;
    }

    public void showTasks(TreeMap<String, List<Task>> tree) {
        taskCreator(tree, "");
        System.out.println("Desarrollo de software");
        for (Map.Entry<String, List<Task>> tasks : tree.entrySet()) {
                System.out.println("|--"+tasks.getKey());
            for (int i = 0; i < tasks.getValue().size(); i++) {
               System.out.println("    |--" + tasks.getValue().get(i).getNombre());
            }
        }
    }

}
