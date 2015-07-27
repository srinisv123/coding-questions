<?php
/* php code is wrapped in

for ( $i = 0; $i < 5; $i++) {
    echo "Hello, World\n";
}


// callETAService(clientLocation, busNumber) -> 240 (eta in seconds)
// handleRequest(input) -> 
//  
//  call callETAService(input...) 

// if any 5 of last 10 requests fail, mark service as down 
// if 3 calls in last minute are > 300ms, mark service as down
// TODO: How to mark it as up?


*/

print "hello";

$circuitBreaker = new CircuitBreaker();

$circuitBreaker->getETA(1, 2);

class CircuitBreaker {

    function __construct() {

    }

    private $array = array();
    private $currentPosition =0;
    private $maxThreshold =5;
    function setFailure() {

        $array[$this->currentPosition++] = 0;
    }


    function setSuccess() {
        $array[$this->currentPosition++] =1;
    }

    function circuitBreaker() {

        $count =0;
        $checkArray = array_slice($this->array, 10, -1); // Get last 10 from array
        foreach($checkArray as $element) {
            if ($count > $this->maxThreshold) {
                return true;
            }

            if(!$element) {
                $count++;
            }
        }

        return false;
    }


    function getETA($clientLocation, $busNumber) {
        // Make external call

        // If success

        if ($rand = rand(0,10) < 5) {
            return 0;
        } else {
            return $rand;
        }


    }

    function callETAService($clientLocation, $busNumber) {


        if ($this->circuitBreaker()) {
            return 0;
        }

        // fetch the ETA
        if ( (!$location = $this->getETA($clientLocation, $busNumber)))  {
            $this->setFailure();
            return 0;
        }

        $this->setSuccess();

        return $location;
    }
}
















