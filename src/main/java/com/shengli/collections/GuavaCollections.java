package com.shengli.collections;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.io.Files;
import com.shengli.utilities.object.Person;

import java.util.List;
import java.util.Set;

/**
 * Created by shengli on 8/18/15.
 */
public class GuavaCollections {
    public static void main(String[] args) {

        /*------------ Lists -----------------*/

        List<Person> personList = Lists.newArrayList();

//        List<Person> personList =
//                Lists.newArrayList(person1,person2,person3,person4);
//
//        List<List<Person>> subList = Lists.partition(personList,2);

//        [[person1,person2],[person3, person4]]




        /*------------ Sets -----------------*/
        //s1 not in s2
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("2","3","4");
        Sets.difference(s1,s2);

        //Any elements that exist in the second set but not in the first set are not included.
        // For example, the following would return a SetView instance with one element, "1":

        //并集
        Set<String> s3 = Sets.newHashSet("1","2","3");
        Set<String> s4 = Sets.newHashSet("2","3","4");
        Sets.SetView setView = Sets.symmetricDifference(s3,s4);
        //Would return [1,4]


        //交集
        Set<String> s5 = Sets.newHashSet("1","2","3");
        Set<String> s6 = Sets.newHashSet("3","2","4");
        Sets.SetView<String> sv = Sets.intersection(s5,s6);
//        assertThat(sv.size()==2 && sv.contains("2") &&
//                sv.contains("3"),is(true));


        //union去重
        Set<String> s7 = Sets.newHashSet("1","2","3");
        Set<String> s8 = Sets.newHashSet("3","2","4");
        Sets.SetView<String> sv2 = Sets.union(s1,s2);
//        assertThat(sv.size()==4 &&
//                sv.contains("2") &&
//                sv.contains("3") &&
//                sv.contains("4") &&
//                sv.contains("1"),is(true));


        /*------------ Maps -----------------*/
        //old way
//        List<Book> books = someService.getBooks();
//        Map<String,Book> bookMap = new HashMap<String,Book>()
//        for(Book book : books){
//            bookMap.put(book.getIsbn(),book);
//        }

        //uniqueIndex即返回key
//        Map<String,Book>bookMap = Maps.uniqueIndex(books.iterator(),new
//                Function<Book, String>(){
//                    @Override
//                    public String apply( Book input) {
//                        return input.getIsbn();
//                    }
//      };)


        //Maps.asMap


        //Maps.transformEntries

        //Multimaps
//        一个key对应多个value
//        Multimap<Person, BlogPost> multimap = ArrayListMultimap.create();
//        public void addBlogPost(final Person author, final BlogPost blogPost) {
//            multimap.put(author, blogPost)
//        }


        //BiMap
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        //This call causes an IllegalArgumentException to be thrown!
//        biMap.put("2","Tom");


        BiMap<String,String> biMap2 = HashBiMap.create();
        biMap2.put("1","Tom");
        biMap2.forcePut("2", "Tom");
        /**
         * In this example, we are adding two different keys with the same value, which is an expected behavior for a
         * traditional map. But when using a bimap, inserting a new key with a value that already exists in the map
         * causes IllegalArgumentException to be thrown.
         */


        //BiMap逆转k,v
//        BiMap<String,String> biMap = HashBiMap.create();
//        biMap.put("1","Tom");
//        biMap.put("2","Harry");
//        assertThat(biMap.get("1"), is("Tom"));
//        assertThat(biMap.get("2"), is("Harry"));
//        BiMap<String,String> inverseMap = biMap.inverse();
//        assertThat(inverseMap.get("Tom"), is("1"));
//        assertThat(inverseMap.get("Harry"),is("2"));



        /*------------ Table -----------------*/
        //A table is a collection that takes two keys, a row, and a column, and maps those keys to a single value
//        HashBasedTable<Integer,Integer,String> table =
//                HashBasedTable.create();
//        //Creating table with 5 rows and columns initially
//        HashBasedTable<Integer,Integer,String> table =
//                HashBasedTable.create(5,5);
//        //Creating a table from an existing table
//        HashBasedTable<Integer,Integer,String> table =
//                HashBasedTable.create(anotherTable);

        //Map<R, Map<C, V>>

        HashBasedTable<Integer,Integer,String> table =
                HashBasedTable.create();
        table.put(1,1,"Rook");
        table.put(1,2,"Knight");
        table.put(1,3,"Bishop");
        boolean contains11 = table.contains(1, 1);
        boolean containColumn2 = table.containsColumn(2);
        boolean containsRow1 = table.containsRow(1);
        boolean containsRook = table.containsValue("Rook");
        table.remove(1,3);
        table.get(3,4);




        /*------------ Range -----------------*/

        Range<Integer> numberRange = Range.closed(1,10);
        //both return true meaning inclusive
        numberRange.contains(10);
        numberRange.contains(1);


        Range<Integer> numberRange2 = Range.open(1,10);
        //both return false meaning exclusive
        numberRange2.contains(10);
        numberRange2.contains(1);
    }



}

// Range Example for a comparator
// class Person implements Comparable<Person> {
//    private String firstName;
//    private String lastName;
//    private int age;
//    private String sex;
//    @Override
//    public int compareTo(Person o) {
//        return ComparisonChain.start().
//                compare(this.firstName,o.getFirstName()).
//                compare(this.lastName,o.getLastName()).
//                compare(this.age,o.getAge()).
//                compare(this.sex,o.getSex()).result();
//    }
//
//Range<Integer> ageRange = Range.closed(35,50);
//
//Function<Person,Integer> ageFunction = new Function<Person,
//        Integer>() {
//    @Override
//    public Integer apply(Person person) {
//        return person.getAge();
//    }
//};
//
//Predicate<Person> predicate =
//        Predicates.compose(ageRange,ageFunction);

