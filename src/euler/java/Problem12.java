package euler.java;

import java.util.*;

/**
 * Highly divisible triangular number
 *
 *
 * The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be: 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five divisors.
 * What is the value of the first triangle number to have over five hundred divisors?
 */
public class Problem12 {

    class TriangleNum {
        private long lastTNum = 1;
        private long tnum = 1;
        private long currTerm = 1;

        TriangleNum( long term ) {
            currTerm = term;
            tnum = computeTNum( term );
            lastTNum = tnum;
        }

        long nextTNum() {
            currTerm++;
            lastTNum = tnum;
            tnum = tnum + currTerm;
            return tnum;
        }

        public long getTnum() {
            return tnum;
        }

        private long computeTNum( long term ) {
            long num = 0;
            while ( term > 0 ) {
                num += term--;
            }
            return num;
        }

    }


    public static TreeSet<Long> factors(long n)
    {
        TreeSet<Long> factors = new TreeSet<Long>();
        factors.add(n);
        factors.add(1L);
        for(long test = n - 1; test >= Math.sqrt(n); test--)
            if(n % test == 0)
            {
                factors.add(test);
                factors.add(n / test);
            }
        return factors;
    }

    public long getDivisors( int startTerm, int divisorSize ) {
        TriangleNum tn = new TriangleNum( startTerm );
        long [] divisors = new long[divisorSize];
        Arrays.fill( divisors, 0 );
        int factorCount = 0;

        while ( factorCount <= divisorSize ) {
            long n = 1;
            int i = 0;
            //compute divisors
            while ( n <= tn.getTnum() ) {
                if ( ( tn.getTnum() % n ) == 0 ) {
                    divisors[i++] = n;
                }
                n++;
            } //end compute divisors
            tn.nextTNum();
        }
        System.out.println( Arrays.toString( divisors ) );
        return tn.getTnum();
    }



    public static void main( String[] args ) {
        TreeSet facts = factors( 76576500 );
        System.out.println( facts );
        System.out.println( facts.size() );
        //Problem12 p = new Problem12();
        //long triNum = p.getDivisors( 1, 3 );
        //System.out.println("the number is:" + triNum );

    }
}
