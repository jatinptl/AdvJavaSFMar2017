package college;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    static int MAX_COURSES = 9;

    private String name;
    private float gpa;
    private List<String> courses;

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
        if (name == null) sb.append("Name of Student must never be null ");
        if (gpa < 0 || gpa > 4) sb.append("gpa must be in range 0 -> 4");
        if (sb.length() > 0) throw new IllegalArgumentException(sb.toString());
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

}
