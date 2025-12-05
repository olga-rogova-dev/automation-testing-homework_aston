package src.main.lesson6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        students.add(new Student("Рогова", "A-01", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Петров", "A-01", 1, Arrays.asList(2, 2, 3)));
        students.add(new Student("Васильков", "B-02", 2, Arrays.asList(5, 5, 4)));
        students.add(new Student("Иванов", "B-02", 2, Arrays.asList(5, 3, 5)));
        students.add(new Student("Лебедева", "B-03", 3, Arrays.asList(5, 4, 5)));
        PhoneBook pb = new PhoneBook();

        StudentUtils.removeBadStudents(students);
        StudentUtils.promoteGoodStudents(students);

        System.out.println("Студенты 2 курса:");
        StudentUtils.printStudents(students, 2);
        System.out.println("Студенты 3 курса:");
        StudentUtils.printStudents(students, 3);
        System.out.println("Студенты 4 курса:");
        StudentUtils.printStudents(students, 4);

        pb.add("Рогова", "+375-29-746-63-34");
        pb.add("Петров", "+375-25-564-77-00");
        pb.add("Васильков", "+375-44-735-23-44");
        pb.add("Иванов", "+375-29-987-08-02");
        pb.add("Рогова", "+375-25-598-34-90");

        pb.get("Рогова");
        pb.get("Петров");
        pb.get("Васильков");
        pb.get("Иванова");
    }
}