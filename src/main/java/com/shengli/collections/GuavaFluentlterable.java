package com.shengli.collections;

import com.google.common.collect.Lists;
import com.shengli.utilities.object.Person;

import java.util.List;

/**
 * Created by shengli on 8/17/15.
 */
public class GuavaFluentlterable {
    public static void main(String[] args) {
        Person person1 = new Person("Wilma", 30, "F");
        Person person2 = new Person("Fred", 32, "M");
        Person person3 = new Person("Betty", 31, "F");
        Person person4 = new Person("Barney",  33, "M");
        List<Person> personList = Lists.newArrayList(person1, person2, person3,
                person4);
    }
}
