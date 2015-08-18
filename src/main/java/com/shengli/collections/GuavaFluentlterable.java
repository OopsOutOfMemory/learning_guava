package com.shengli.collections;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
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

        fluentIterableFilter(personList);
        fluentIterableTransform(personList);
    }

    private static void fluentIterableFilter(List<Person> personList) {
        FluentIterable<Person> personsFilteredByAge = FluentIterable.from(personList).filter(new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                return input.getAge() > 31;
            }
        });
    }


    private static void fluentIterableTransform(List<Person> personList) {
        List<String> transformedPersonList = FluentIterable.from(personList).transform(new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return Joiner.on("#").join(input.getName(), input.getAge(),input.getGender());
            }
        }).toList();
    }

}
