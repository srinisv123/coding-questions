<?php

/*
cat, cut = true
cat, cast = true
cat, cat = false
cat, dog = false
cat, ct= true

caaat, caat

"" a
bat, tabs = ?

CT CUT
 ^   ^
*/


print checkSingleChange("cut", "cuttt") ? "true" : " false";



function checkSingleChange($s1, $s2) {

    // Check lenght
    $l1 = strlen($s1);
    $l2 = strlen($s2);
    if(abs($l1-$l2) >1 ) {
        return false;
    }

    $i=0;
    $j=0;

    // Same lenght c c
    if ($l1 == $l2) {
        $oneChange = false;
        while($i <= $l1-1) {
            if (substr($s1, $i,1) != substr($s2, $j, 1)) {
                if (!$oneChange) {
                    $oneChange = true;
                } else {
                    return false;
                }
            }

            $i++;
            $j++;

        }
        return $oneChange;
    }


    if ($l1<$l2) {
        $short = $s1;
        $long = $s2;
    } else {
        $short = $s2;
        $long = $s1;
    }

    $oneChange = false;
    $i=0;
    $j=0;

    // a, ay
    while($i <= $l1-1) {


        // If different lenghts
        if(substr($short,$i,1) != substr($long, $j, 1)) {
            $j++;
            if (!$oneChange) {
                $oneChange = true;
            } else {
                return false;
            }
        } else {

            $j++;
            $i++;
        }



    }


    if (!$oneChange && ($j == $l2-1)) {
        return true;
    } else {
        return false;
    }


}

function checkSingleChangeCombined($s1, $s2) {

    // Check lenght
    $l1 = strlen($s1);
    $l2 = strlen($s2);
    if(abs($l1-$l2) >1 ) {
        return false;
    }

    $i=0;
    $j=0;

    // Same lenght c c
    $oneChange = false;
    while($i <= $l1-1 || $j <= $l2-1) {
        if (substr($s1, $i,1) != substr($s2, $j, 1)) {
            if (!$oneChange) {

                if ($l1 == $l2) {
                    $i++;
                    $j++;
                } else if($l1 < $l2) {
                    $i++;
                } else {
                    $j++;
                }
                $oneChange = true;
            } else {
                return false;
            }
        } else {

            $i++;
            $j++;
        }

    }





    if (($i==$l1-1)|| ($j==$l2-1) && $oneChange) {
        return true;
    }

    return $oneChange;



}




?>
