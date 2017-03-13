package college;

import java.util.Arrays;
import java.util.List;

public class Student {

    private String name;
    private float gpa;
    private List<String> courses;

    public static class Builder {
        private Student target;
        
        private Builder() {
            target = new Student();
        }
        
        private Builder name(String name) {
            target.name = name;
            return this;
        }
        
        private Builder gpa(float gpa) {
            target.gpa = gpa;
            return this;
        }
        
        private Builder course(String name) {
            target.name = name;
            return this;
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    private Student() {
    }

    public static Student getByNameGpaCourses(String name, float gpa, String ... courses) {
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
