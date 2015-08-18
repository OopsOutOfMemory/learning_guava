package com.shengli.fp;

import com.google.common.base.Predicate;

/**
 * Created by shengli on 8/17/15.
 *
 *
 *   public interface Predicate<T> {
        boolean apply(T input)
        boolean equals(Object object)
 }
 */
public class GuavaPredicateInterface {
    public static void main(String[] args) {

    }

    public class PopulationPredicate implements Predicate<City> {
        @Override
        public boolean apply(City input) {
            return input.getPopulation() <= 500000;
        }
    }

//    public class TemperateClimatePredicate implements Predicate<City> {
//        @Override
//        public boolean apply(City input) {
//            return input.getClimate().equals(Climate.TEMPERATE);
//        }
//    }
//    public class LowRainfallPredicate implements Predicate<City> {
//        @Override
//        public boolean apply(City input) {
//            return input.getAverageRainfall() < 45.7;
//        }
//    }
//    --------------------- Predicates.and ---------------------------------
//    Predicate smallAndDry =
//            Predicates.and(smallPopulationPredicate,lowRainFallPredicate);
//    Predicates.and(Iterable<Predicate<T>> predicates);
//    Predicates.and(Predicate<T> ...predicates);


//    --------------------- Predicates.or ---------------------------------
//    Predicate smallTemperate =
//            Predicates.or(smallPopulationPredicate,temperateClimatePredicate);
//    Predicates.or has the same overloaded method signatures like the Predicates.and method:
//            Predicates.or(Iterable<Predicate<T>> predicates);
//    Predicates.or(Predicate<T> ...predicates);

//    --------------------- Predicates.not ---------------------------------

//    Predicate largeCityPredicate =
//            Predicate.not(smallPopulationPredicate);

//    ---------------------Using the Predicates.compose method---------------------------------
//public class SouthwestOrMidwestRegionPredicate implements
//        Predicate<State> {
//    @Override
//    public boolean apply(State input) {
//    return input.getRegion().equals(Region.MIDWEST) ||
//            input.getRegion().equals(Region.SOUTHWEST);
//} }



}


