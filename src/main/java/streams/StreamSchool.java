package streams;

import college.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSchool {

    public static void main(String[] args) {
        List<Student> college = new ArrayList<>(Arrays.asList(new Student[]{
            Student.getByNameGpaCourses("Jim", 3.5F,
            "Math", "Engineering", "Tribology"),
            Student.getByNameGpaCourses("Jim", 3.2F,
            "Math", "Engineering", "Tribology"),
            Student.getByNameGpaCourses("Jim", 3.8F,
            "Math", "Engineering", "Tribology"),
            Student.getByNameGpaCourses("Sheila", 3.8F,
            "Math", "Physics", "Astronomy", "Astrophysics"),
            Student.getByNameGpaCourses("Fred", 3.9F, "Math", "Physics"),
            Student.getByNameGpaCourses("Fred", 2.2F, "Math", "Physics"),
            Student.getByNameGpaCourses("Fred", 2.9F, "Math", "Physics"),
            Student.builder()
            .name("Albert")
            .gpa(2.2F)
            .course("Art History")
            .course("Journalism")
            .build(),
            Student.builder()
            .course("Art History")
            .name("William")
            .gpa(2.2F)
            .course("Journalism")
            .build(),}));
        
        Stream<Student> ss = college.stream();
                ss.forEach(System.out::println);
               // CANNOT do this!
//                ss.forEach(System.out::println);
        System.out.println("----------------------------");
        college.stream()
                .map(s-> s.getName() + " : " + s.getGpa())
                .forEach(System.out::println);
        System.out.println("----------------------------");
        college.stream()
                .filter(s->s.getGpa() > 3.0F)
                .forEach(System.out::println);
        System.out.println("----------------------------");
        college.stream()
                .flatMap(s->s.getCourses().stream())
                .forEach(System.out::println);
        System.out.println("----------------------------");
        college.stream()
                .flatMap(s->s.getCourses().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------");
    }
}
