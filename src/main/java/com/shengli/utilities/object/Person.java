package com.shengli.utilities.object;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ComparisonChain;

import com.google.common.base.Objects;

/**
 * Created by shengli on 8/17/15.
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("name", name)
                .add("age", age)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }

    @Override
    public int compareTo(Person o) {
        return ComparisonChain.start()
                .compare(this.name, o.getName())
                .compare(this.age, o.getAge())
                .result();

    }
}
