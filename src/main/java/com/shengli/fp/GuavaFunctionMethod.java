package com.shengli.fp;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shengli on 8/17/15.
 */
public class GuavaFunctionMethod {
    public static void main(String[] args) {

        Map<String, State> stateMap = Maps.newHashMap();
        State state = new State();
        stateMap.put("NY", state);

        //By using a Function interface to perform the state lookups, you can easily change out the implementation
        Function<String,State> lookup = Functions.forMap(stateMap);
        //Would return State object for NewYork
        lookup.apply("NY");


        Function<String,State> lookup2 = Functions.forMap(stateMap);
        Function<State, String> stateFunction = new StateToCityString();
        //Now a call to composed.apply("NY") would return the following:"Albany,Buffalo,NewYorkCity"
        Function<String,String> composed =
                Functions.compose(stateFunction ,lookup);

        String cities = stateFunction.apply(lookup.apply("NY"));

    }

    public static class StateToCityString implements Function<State,String> {
        @Override
        public String apply(State input) {
            return Joiner.on(",").join(input.getMainCities());
        }
    }

}



class State {
    private String name;
    private String code;
    private Set<City> mainCities = new HashSet<City>();

    public Set<City> getMainCities() {
        return mainCities;
    }
}

class City {
    private String name;
    private String zipCode;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String toString() {
        return name;
    }
}