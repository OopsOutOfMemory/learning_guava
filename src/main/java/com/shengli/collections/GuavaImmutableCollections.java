package com.shengli.collections;

import com.google.common.collect.ImmutableListMultimap;

/**
 * Created by shengli on 8/18/15.
 */
public class GuavaImmutableCollections {
    public static void main(String[] args) {

        //Creating immutable collection instances
        ImmutableListMultimap<Integer, String> map = new
                ImmutableListMultimap.Builder<Integer, String>()
                .put(1, "Foo")
                .putAll(2, "Foo", "Bar", "Baz")
                .putAll(4, "Huey", "Duey", "Luey")
                .put(3, "Single").build();

        map.put(5, "aaa");//UnsupportedOperationException


        //Ordering
        //While it implements the Comparator interface, Ordering has the compare method declared as abstract.

        /*
        Creating a new instance and providing an implementation for the compare
        method.
         Using the static Ordering.from method that creates an instance of Ordering
        from an existing Comparator.
         */

        /*
        public class CityByPopluation implements Comparator<City> {
            @Override
            public int compare(City city1, City city2) {
                return Ints.compare(city1.getPopulation(),city2.
                        getPopulation());
            } }
         */

        //Ordering.from(cityByPopluation).reverse();

        //Ordering.from(comparator).nullsFirst();   NULL VALUE placed in the begining


        //Secondary sorting

        /*

           public class CityByRainfall implements Comparator<City> {
               @Override
               public int compare(City city1, City city2) {
                      return Doubles.compare(city1.getAverageRainfall(),city2.
           getAverageRainfall()); }
        }
         */

        //Ordering.from(cityByPopulation).compound(cityByRainfall);  先根据第一个comparator排序，然后根据第二个comparator排序


        //Retrieving minimum and maximum values

        /*
        Ordering<City> ordering = Ordering.from(cityByPopluation);
        List<City> topFive = ordering.greatestOf(cityList,5);
        List<City> bottomThree = ordering.leastOf(cityList,3);
         */

    }
}
