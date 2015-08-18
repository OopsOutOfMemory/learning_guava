package com.shengli.fp;

/**
 * Created by shengli on 8/17/15.
 * public interface Supplier<T> {
    T get();
 }
 The get method returns an instance of type T and only of that type. The Supplier interface helps us implement several of the typical creational patterns.
 When get is called, we could always return the same instance (singleton) or a new instance with each invocation.
 A Supplier interface also gives you the flexibility to use lazy instantiation by not constructing an instance until the
 get method is called. Also, since the Supplier is an interface, unit testing becomes much easier, as compared to other
 approaches for creating objects such as a static factory method. In short, the power of the Supplier interface is that
 it abstracts the complexity and details of how an object needs to be created, leaving the developer free to create an
 object in whatever way he/she feels is the best approach. Let's take a look at how we might use a Supplier interface.
 */
public class GuavaSupplierInterface {
    public static void main(String[] args) {

    }
}

//class ComposedPredicateSupplier implements
//        Supplier<Predicate<String>> {
//    @Override
//    public Predicate<String> get() {
//        City city = new City("Austin,TX","12345",250000, Climate.SUB_
//                TROPICAL,45.3);
//        State state = new State("Texas","TX", Sets.newHashSet(city),
//                Region.SOUTHWEST);
//        City city1 = new City("New York,NY","12345",2000000,Climate.
//                TEMPERATE,48.7);
//        State state1 = new State("New York","NY",Sets.
//                newHashSet(city1),Region.NORTHEAST);
//        Map<String,State> stateMap = Maps.newHashMap();
//        stateMap.put(state.getCode(),state);
//        stateMap.put(state1.getCode(),state1);
//        Function<String,State> mf = Functions.forMap(stateMap);
//        return Predicates.compose(new RegionPredicate(), mf);
//    }
//}
//Supplier<Predicate<String>> wrapped =
//        Suppliers.memoize(composedPredicateSupplier);
//
//Supplier<Predicate<String>> wrapped =
//        Suppliers.memoize(composedPredicateSupplier,10L,TimeUnit.MINUTES);

