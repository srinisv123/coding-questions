<?php

// php code is wrapped in <?php tags

/**Your previous Java content is preserved below:

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


Given an array of arrays, implement an iterator class to allow the client to traverse and remove elements in the array list. This iterator should provide three public class member functions:

boolean has_next()
return true or false if there is another element in the set

int next()
return the value of the next element in the set

void remove()
remove the last element returned by the iterator.  That is, remove the element that the previous next() returned
This method can be called only once per call to next(), otherwise, an exception will be thrown.


The code should be well structured, and robust enough to handle any access pattern.  Additionally, write code to demonstrate that the class can be used for the following basic scenarios:


Print elements
Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
Print:  1 2 3 4 5 6 7 8 9 10

Remove even elements
Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
Should result in:  [[],[1,3],[5],[],[],[],[7],[],[9],[],[]]
Print:  1 3 5 7 9
 */




$input = array(
    0 => array(),
    1 => array(1,2,3),
    2 => array(),
    3 => array(4,5),
    4 => array(),
    5 => array(),
    6 => array(6,7,8),
    7 => array(),
    8 => array(9),
    10=> array(),
);

$object = new MyIterator($input);

while ($object->has_next()) {
    $item = $object->next();
    print("item: $item \n" );
    if ($item%2 ==0) {
        $object->remove();
    }
}

echo(print_r($object->getObject(),1));

Class MyIterator {

    protected $items;
    protected $rowPos;
    protected $colPos;
    protected $calledNext;
    function __construct($array) {
        $this->items = $array;
        $this->rowPos =0;
        $this->colPos=0;
        $this->calledNext = false;
    }

    function getObject() {
        return $this->items;
    }



    function has_next() {
        while($this->rowPos <= count($this->items)) {
            //print("rowpos :" . $this->rowPos ." \n");
            if (isset($this->items[$this->rowPos][$this->colPos])) {

                return true;
            } else {
                $this->rowPos++;
                $this->colPos=0;
            }


        }

        return false;


    }


    function next() {
        if ($this->has_next()) {
            $this->calledNext = true;
            return $this->items[$this->rowPos][$this->colPos++];
        } else {
            $this->calledNext = false;
            throw new Exception("No items found");
        }
    }

    function remove() {
        if (!$this->calledNext) {
            throw new Exception ("Next needs to be called");
        } else {
            $this->items[$this->rowPos] = array_merge(array_slice($this->items[$this->rowPos], 0, $this->colPos-1), array_slice($this->items[$this->rowPos], $this->colPos, (count($this->items[$this->rowPos])-$this->colPos+1)));
           $this->colPos--;
            //unset($this->items[$this->rowPos][$this->colPos-1]);
            $this->calledNext = false;

        }
    }


}