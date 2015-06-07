<?php
/**
 * Created by IntelliJ IDEA.
 * User: ssingan
 * Date: 6/3/15
 * Time: 9:29 PM
 */

test_product_of_arrays_without_division();

function product_of_arrays_without_division($input_array) {


    if (empty($input_array)) {
        return $input_array;
    }

    $successive_products = array();

    $successive_products[0]=1;

    for( $i=1; $i<= count($input_array)-1; $i++) {
        $successive_products[$i] = $successive_products[$i-1] * $input_array[$i-1];
    }

    $previous_products = array();

    $previous_products[count($input_array)-1] = 1;

    for($i=count($input_array)-2; $i>=0 ; $i--) {
        $previous_products[$i] = $previous_products[$i+1] * $input_array[$i+1];
    }

    $final_product = array();

    for($i=0;$i<count($input_array);$i++) {
        $final_product[$i] = $successive_products[$i] * $previous_products[$i];
    }

    return $final_product;

}


function test_product_of_arrays_without_division() {
    if (product_of_arrays_without_division(array()) === array()) {
        echo "empty array works\n";
    } else {
        echo "empty array does not work\n";
    }


    $result = product_of_arrays_without_division(array(1,2,3));
    if ($result === array(6,3,2)) {
        echo "1,2,3 array works\n";
    } else {
        echo "1,2,3 array does not work\n";
    }

    $result = product_of_arrays_without_division(array(0,2,3,3,2));
    if ($result === array(36,0,0,0,0)) {
        echo "0,2,3,3,2 array works\n";
    } else {
        echo "0,2,3,3,2 array does not work\n";
    }

}

