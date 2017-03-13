package college;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class College {

    public static void showStudents(Iterable<Student> in) {
        for (Student s : in) {
            System.out.println("> " + s);
        }
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        List<Student> college = new ArrayList<>(Arrays.asList(
                Student.getByNameGpaCourses("Jim", 3.5F,
                        "Math", "Engineering", "Tribology"),
                Student.getByNameGpaCourses("Sheila", 3.8F,
                        "Math", "Physics", "Astronomy", "Astrophysics"),
                Student.getByNameGpaCourses("Fred", 2.9F, "Math", "Physics"),
                Student.builder()
                        .name("Albert")
                        .gpa(2.2F)
                        .course("Art History")
                        .course("Journalism")
                        .build();
        ));
        showStudents(college);
        college.sort(new StudentNameComparator());
        showStudents(college);
    }
}
