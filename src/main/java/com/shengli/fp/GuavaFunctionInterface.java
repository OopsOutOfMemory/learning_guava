package com.shengli.fp;

import com.google.common.base.Function;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shengli on 8/17/15.
 *
 * A good Function implementation should have no side effects,
 * meaning the object passed as an argument should remain unchanged after the apply method has been called.
 *
 * public interface Function<F,T> {
        T apply(F input);
        boolean equals(Object object);
 }
 */
public class GuavaFunctionInterface {
    public static void main(String[] args) {
    }


    public static class DateFormatFunction implements Function<Date,String> {
        @Override
        public String apply(Date input) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
            return dateFormat.format(input);
        }
    }

    /*
    In this first example, we can clearly see that a java.util.Date object is being transformed using a SimpleDateFormat
     class to give us a string representation of the date in our desired format. While this example is probably
      overly simplistic, it demonstrates the purpose of the Function interface, transforming an object while hiding the
       implementation details. Although in this example we are using a class that implements the Function interface,
        we could have easily defined Function inline as an anonymous class. Consider the following example:
     */

    Function<Date,String> function = new Function<Date, String>() {
        @Override
        public String apply( Date input) {
            return new
                    SimpleDateFormat("dd/mm/yyyy").format(input);
        }
    };

    /*
    There is no difference between the previous two examples; one is simply a class that implements the Function
     interface and the other is an anonymous class. One advantage to having a class implement the Function interface
     is that you could use dependency injection to pass a Function interface into a collaborating class and increase
      your code's cohesion.
     */

}
