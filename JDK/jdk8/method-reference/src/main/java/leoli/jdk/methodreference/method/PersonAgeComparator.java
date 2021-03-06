package leoli.jdk.methodreference.method;

import leoli.jdk.methodreference.bean.Person;

import java.util.Comparator;

/**
 * @author leoli
 * @date 2020/8/11
 */
public class PersonAgeComparator implements Comparator<Person> {

    public int compare(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }

}
