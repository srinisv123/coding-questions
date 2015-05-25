<?php
/**
 * Created by IntelliJ IDEA.
 * User: svcheena
 * Date: 5/22/15
 * Time: 3:37 PM
 */

TestGreatestStockValue();

function TestGreatestStockValue() {

    #1. Test an increasing value


    $stockPrices = array(2,3,5,6,7,10);

    if (GreatestStockValue($stockPrices) == 8) {
        Echo "Test 1 passed\n";
    } else {
        Echo "Test 1 failed\n";
    }


    #2. Test a decreasing value

    $stockPrices = array (10,9,8,7,6,5);

    if (GreatestStockValue($stockPrices) == -1) {
        Echo "Test 2 passed\n";
    } else {
        Echo "Test 2 failed\n";
    }


    #3. Test random values

    $stockPrices = array (5,10,9,8,7,9,15,12,3,9,0,4);

    if (GreatestStockValue($stockPrices) == 10) {
        Echo "Test 3 passed\n";
    } else {
        Echo "Test 3 failed\n";
    }
}


/**
 *
 * 1. Keep track of lowest value so far (minVal)
 * 2. Keep track of hoghest difference so far (maxDiff)
 *
 * @param $stockPrices
 *
 * @return Integer $maxDiff Integer
 */





function GreatestStockValue($stockPrices) {



    if (count($stockPrices) <=1) {
        return -1;
    }

    $minVal = $stockPrices[0];


    $maxDiff = -1 * PHP_INT_MAX;


    for($i=1 ; $i < count($stockPrices) ; $i++) {

        # Keep track of the highest difference so far.
        $currDiff = $stockPrices[$i] - $minVal;

        if ($currDiff > $maxDiff ) {
            $maxDiff = $currDiff;
        }


        # Keep track of the lowest value so far.
        if ($stockPrices[$i] < $minVal) {
            $minVal = $stockPrices[$i];
        }



    }

    return $maxDiff;
}