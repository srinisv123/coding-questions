<?php
/**
 * Created by IntelliJ IDEA.
 * User: ssingan
 * Date: 6/4/15
 * Time: 2:08 PM
 */


    class LinkedList {


        private  $data = 0;

        private  $next = null;


        function  __construct($data, $next)
        {

            $this->data = $data;

            $this->next = $next;
        }



        function getNext() {
            return $this->next;
        }

        function setNext($next) {
            $this->next=$next;
        }


        function getData() {
            return $this->data;
        }

    }


    function reverseList(LinkedList $head) {



        if ($head == null || $head->getNext() == null) {
            return $head;
        }


        $next  = new LinkedList($head->getData(), $head->getNext());

        $head->setNext(null);

        if ($next->getNext() == null) {
            $next->setNext($head);
            $head = $next;
            return $head;
        }


        while (true) {

            $next = $head->getNext();

            $head = $next;




        }
        return $head;

    }


    testReverseList();


    function testReverseList() {

        $head = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, null))));

        $reverse = new LinkedList(4, new LinkedList(3, new LinkedList(2, new LinkedList(1, null))));

        var_dump($head);

        var_dump($reverse);


        if ($reverse == reverseList($head)) {
            echo "Reversal works";
        } else {
            echo "Reversal failed";
        }


    }


