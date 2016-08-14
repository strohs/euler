package euler.java;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Class for playing around with Java 8 features.
 * User: Cliff
 * Date: 8/3/2016
 * Time: 9:38 AM
 */
public class J8Samples {

    //old school String comparator
    public final Comparator<String> DESCENDING_ORDER = ( o1, o2 ) -> o2.compareTo( o1 );

    public static void printColl( Collection<String> col ) {
        for (String c : col ) System.out.println( c );
    }


    public static void main( String[] args ) {
        List<String> names = Arrays.asList( "Mercury", "Apollo", "Gemini", "Bacchus", "Hades", "Zeus", "Aphrodite","Persephone","Poseidon" );


        //Collections.sort( names, new J8Samples().DESCENDING_ORDER );
        //System.out.println("---");
        //printColl( names );

        //Random rand = new Random(  );
        //rand.ints().limit( 100 ).filter( (int n) -> (n % 7) == 0).forEach( System.out::println );

        int sum = IntStream.range( 1, 11 ).reduce( 0, Integer::sum );
        System.out.println( sum );


        // Runnable r = () -> System.out.println("hello from runnable");
        //r.run();
    }
}
