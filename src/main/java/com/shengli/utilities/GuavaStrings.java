package com.shengli.utilities;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by shengli on 8/17/15.
 */
public class GuavaStrings {

    public static final Logger LOG = LoggerFactory.getLogger(GuavaStrings.class);

    public static void main(String[] args) {
        LOG.info("Old way is ->"+buildString());

        // 6 is the minimum length the resulting string must have. Can be zero or negative,
        // in which case the input string is always returned
        LOG.info("USING GUAVA padEnd is ->" + Strings.padEnd("foo", 6, 'x')); //

        LOG.info("USING GUAVA padStart is ->" + Strings.padStart("foo123", 6, 'x'));

        LOG.info(Strings.nullToEmpty("ABC"));
        LOG.info(Strings.nullToEmpty(null));

        LOG.info(Strings.emptyToNull(""));

        LOG.info(Strings.emptyToNull(null));

        System.out.println(Strings.isNullOrEmpty("abc"));
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));

        /*---It would probably be a good idea to always use the nullToEmpty method on any string objects passed as arguments---*/

    }


    public static String buildString () {
        StringBuilder builder = new StringBuilder("foo");
        char c = 'x';
        for(int i=0; i<3; i++){
            builder.append(c);
        }
        return builder.toString();
    }
}
