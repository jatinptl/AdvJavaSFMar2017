package college;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.script.ScriptEngine;

public class Student /*implements Comparable<Student>*/ {

    static int MAX_COURSES = 9;

    private String name;
    private float gpa;
    private List<String> courses;

//    @Override
//    public int compareTo(Student o) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public static class Builder {

        private Student target;

        private Builder() {
            target = new Student();
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder gpa(float gpa) {
            target.gpa = gpa;
            return this;
        }

        public Builder course(String course) {
            if (target.courses == null) {
                target.courses = new ArrayList<String>();
            }
            target.courses.add(course);
            return this;
        }

        public Student build() {
            target.validate();
            return target;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public void validate() {
        StringBuilder sb = new StringBuilder();
        if (name == null) {
            sb.append("Name of Student must never be null ");
        }
        if (gpa < 0 || gpa > 4) {
            sb.append("gpa must be in range 0 -> 4");
        }
        if (sb.length() > 0) {
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private Student() {
    }

    public static Student getByNameGpaCourses(String name, float gpa, String... courses) {
        if (name == null) {
            throw new IllegalArgumentException("Must provide name");
        }
        Student self = new Student();
        self.name = name;
        self.gpa = gpa;
        self.courses = Arrays.asList(courses);
        return self;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }

    private static Comparator<Student> nameComparator = (Student o1, Student o2) -> {
        return o1.getName().compareTo(o2.getName());
    };

    public static Comparator<Student> getNameComparator() {
        return nameComparator;
    }

//    private static Comparator<Student> nameComparator = 
////            new 
//        /* private static class StudentNameComparator implements*/ 
////        Comparator<Student>() {
//
//        /*@Override
//        public int compare*/(Student o1, Student o2) -> {
//            System.out.println("+");
//            return o1.getName().compareTo(o2.getName());
//        }
//    /*}*/;
//
//    public static Comparator<Student> getNameComparator() {
//        return nameComparator;
//    }
//    private static Comparator<Student> nameComparator = new 
//        /* private static class StudentNameComparator implements*/ 
//        Comparator<Student>() {
//
//        @Override
//        public int compare(Student o1, Student o2) {
//            System.out.println("+");
//            return o1.getName().compareTo(o2.getName());
//        }
//    };
//
//    public static Comparator<Student> getNameComparator() {
//        return nameComparator;
//    }
//
//    private static Comparator<Student> nameComparator = new StudentNameComparator();
//    public static Comparator<Student> getNameComparator() {
//        return nameComparator;
//    }
//    
//    private static class StudentNameComparator implements Comparator<Student> {
//
//        @Override
//        public int compare(Student o1, Student o2) {
////            System.out.print(".");
////            System.out.flush();
//            return o1.getName().compareTo(o2.getName());
//        }
//    }
}
