package collectionapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExamples {

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Fred", "Jim", "Sheila");
//        ls.forEach(s -> System.out.println(s));
        ls.forEach(System.out::println);
        System.out.println("-----------------------");
        
        ArrayList<Object[]> al = new ArrayList<>(Arrays.asList(new Object[][]{
            {"Fred", 2.9F}, {"Jim", 3.8F}, {"Sheila", 3.9F}, {"Mary", 3.1F}}));
        al.removeIf(s->((Float)(s[1])).floatValue() < 3.0F);
        al.forEach(s->System.out.println(s[0] + " scored " + s[1]));
        System.out.println("-----------------------");
        
        Map<String, String> homeCal = new HashMap<>();
        homeCal.put("Today", "Clean up");
        homeCal.put("Tomorrow", "Party");
        homeCal.forEach((k,v) -> System.out.println(k + " I shall " + v));
        System.out.println("-----------------------");
        
//        ls.replaceAll(s->s.toUpperCase());
        ls.replaceAll(String::toUpperCase);
        ls.forEach(s->System.out.println(s));
        System.out.println("-----------------------");
        
        Map<String, String> workCal = new HashMap<>();
        workCal.put("Yesterday", "Meeting");
        workCal.put("Tomorrow", "Leave early");
        Map<String, String> combined = new HashMap<>();
        
        homeCal.forEach((k,v) -> combined.merge(k, v, (v1, v2) -> v1 + ", " + v2));
        workCal.forEach((k,v) -> combined.merge(k, v, (v1, v2) -> v1 + ", " + v2));
        combined.forEach((k,v) -> System.out.println(k + " I shall " + v));
    }
}
