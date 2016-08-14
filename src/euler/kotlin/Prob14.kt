package euler.kotlin

import java.util.*
import kotlin.system.measureTimeMillis

/**
 * Created with IntelliJ IDEA.
 * User: Cliff
 * Date: 2/5/2016
 * Time: 3:02 PM
 */
fun isEven( n: Long ) = (n % 2) == 0L

fun collatz( n: Long ) : List<Long> {
    var czs : MutableList<Long> = ArrayList()
    czs.add( n )
    if ( n <= 1 ) return czs

    var cz = n;
    while ( cz > 1 ) {
        when {
            isEven( cz ) -> cz /= 2
            else -> cz = (cz * 3) + 1   //cz is odd
        }
        czs.add( cz )
    }
    return czs
}

fun main( args: Array<String> ) {

    var maxCount = -1
    var czNum = -1
    val elapsedTime = measureTimeMillis {
        for( i in 1..999999) {
            val czs = collatz( i.toLong() );
            if ( czs.size > maxCount ) {
                maxCount = czs.size
                czNum = i
            }
        }
    }

    println( "the number with the longest collatz sequence is ${czNum} with a length of ${maxCount}")
    println( "${elapsedTime}ms" )

}