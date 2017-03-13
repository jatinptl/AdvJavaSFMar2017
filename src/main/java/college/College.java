package college;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface StudentCriterion {
    boolean test(Student s);
}

public class College {

    public static Comparator<Student> thenComparing(Comparator<Student> first, Comparator<Student> second) {
        return (s1, s2) -> {
            int firstTry = first.compare(s1, s2);
            if (firstTry == 0) return second.compare(s1, s2);
            return firstTry;
        };
    }
    
    public static Comparator<Student> inverse(Comparator<Student> original) {
        return (s1, s2) -> original.compare(s2, s1);
    }
    
    public static List<Student> getStudentsByCriterion(List<Student> all, StudentCriterion criterion) {
        List<Student> rv = new ArrayList<>();
        for (Student s : all) {
            if (criterion.test(s)) {
                rv.add(s);
            }
        }
        return rv;
    }
//    public static List<Student> getSmartStudents(List<Student> all, float threshold) {
//        List<Student> rv = new ArrayList<>();
//        for (Student s : all) {
//            if (s.getGpa() > threshold) {
//                rv.add(s);
//            }
//        }
//        return rv;
//    }
//
//    public static List<Student> getEnthusiasticStudents(List<Student> all, int threshold) {
//        List<Student> rv = new ArrayList<>();
//        for (Student s : all) {
//            if (s.getCourses().size() > threshold) {
//                rv.add(s);
//            }
//        }
//        return rv;
//    }
    
// NO NO NO!
//    public static List<Student> getSomewhatSmartStudents(List<Student> all) {
//        List<Student> rv = new ArrayList<>();
//        for (Student s : all) {
//            if (s.getGpa() > 2.8F) {
//                rv.add(s);
//            }
//        }
//        return rv;
//    }
    
    public static void showStudents(Iterable<Student> in) {
        for (Student s : in) {
            System.out.println("> " + s);
        }
        System.out.println("-------------------------------");
    }

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
                        .build(),
        }));
        showStudents(college);
        Comparator<Student> nameOrder = Student.getNameComparator();
        college.sort(nameOrder);
        showStudents(college);
        Comparator<Student> gradeOrder = (s1, s2)->Float.compare(s1.getGpa(), s2.getGpa());
        college.sort(gradeOrder);
        showStudents(college);
        college.sort(thenComparing(nameOrder, gradeOrder));
        showStudents(college);
        college.sort(thenComparing(gradeOrder, nameOrder));
        showStudents(college);
        college.sort(thenComparing(inverse(gradeOrder), nameOrder));
        showStudents(college);
        
//        showStudents(getSmartStudents(college, 2.7F));
//        showStudents(getEnthusiasticStudents(college, 2));

//        showStudents(getStudentsByCriterion(college, s -> s.getGpa() > 3.0F));
//        showStudents(getStudentsByCriterion(college, s -> s.getCourses().size() >= 3));
        
        showStudents(getStudentsByCriterion(college, Student.getSmartnessCriterion(2.7F)));
        showStudents(getStudentsByCriterion(college, Student.getEnthusiasmCriterion()));
    }
}
