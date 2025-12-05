package src.main.lesson6;

import java.util.Iterator;
import java.util.Set;

public class StudentUtils {
    public static void removeBadStudents(Set<Student> students) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getAverage() < 3.0) {
                System.out.println("Студент " + s.getName() + " удален");
                it.remove();
            }
        }
    }

    public static void promoteGoodStudents(Set<Student> students) {
        for (Student s : students) {
            if (s.getAverage() >= 3.0) {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println(s.getName());
            }
        }
    }
}