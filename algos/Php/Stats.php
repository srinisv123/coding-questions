<?php

/*

class Stats
   insert(val)
   
   getMean()
   
   getMedian()

*/





// php code is wrapped in <?php tags

/* for ( $i = 0; $i < 5; $i++) {
   echo "Hello, World\n";
 }*/

$stats = new Stats();

try {
    $stats->printMeanAndMedian();
} catch (Exception $e) {
    echo("The exception was : " . $e->getMessage() ."\n");
}
$stats->insert(10);
$stats->printMeanAndMedian();
print_r($stats->getLeftHeap());
print_r($stats->getRightHeap());

$stats->insert(11);
$stats->printMeanAndMedian();
$stats->printMeanAndMedian();
print_r($stats->getLeftHeap());
print_r($stats->getRightHeap());

$stats->insert(12);
$stats->printMeanAndMedian();
$stats->printMeanAndMedian();
print_r($stats->getLeftHeap());
print_r($stats->getRightHeap());

$stats->insert(13);
$stats->printMeanAndMedian();
$stats->printMeanAndMedian();
print_r($stats->getLeftHeap());
print_r($stats->getRightHeap());

$stats->insert(9);
$stats->printMeanAndMedian();
$stats->printMeanAndMedian();
print_r($stats->getLeftHeap());
print_r($stats->getRightHeap());

$stats->insert(8);
$stats->printMeanAndMedian();
$stats->printMeanAndMedian();
print_r($stats->getLeftHeap());
print_r($stats->getRightHeap());

class Stats {

    protected $leftMaxHeap;
    protected $rightMinHeap;
    protected $aggregate;
    function __construct() {

        $this->leftMaxHeap = new SplMaxHeap();
        $this->rightMinHeap = new SplMinHeap();
        $this->aggregate = 0;


    }

    function getLeftHeap() {
        return $this->leftMaxHeap;
    }

    function getRightHeap() {
        return $this->rightMinHeap;
    }

    function printMeanAndMedian() {
        echo("The mean is: " . $this->getMean() . "\n");
        echo("The median is: " . $this->getMedian() . "\n");
    }

    function insert($val) {
        //update the aggregate
        $this->aggregate += $val;


        $leftMax = null;
        try {
            $leftMax = $this->leftMaxHeap->top();
        } catch (Exception $e) {

        }


        if ($leftMax == null || $val <= $leftMax) {
            $this->leftMaxHeap->insert($val);
        } else  {
            $this->rightMinHeap->insert($val);
        }

        //re-balancing
        if (abs($this->leftMaxHeap->count()-$this->rightMinHeap->count())>=2 ) {
            if ($this->leftMaxHeap->count() > $this->rightMinHeap->count()) {
                $greaterHeap = $this->leftMaxHeap;
                $lesserHeap = $this->rightMinHeap;
            } else {
                $greaterHeap = $this->rightMinHeap;
                $lesserHeap = $this->leftMaxHeap;
            }

            $element = $greaterHeap->extract();
            $lesserHeap->insert($element);
        }


    }

    function getMean() {

        if ($this->leftMaxHeap->count() == 0 && $this->rightMinHeap->count() ==0) {
            return 0;
        }
        return ($this->aggregate / ($this->leftMaxHeap->count() + $this->rightMinHeap->count()));
    }

    function getMedian() {

        if ($this->leftMaxHeap->count() == 0 && $this-> rightMinHeap->count() ==0) {
            throw new Exception ("Invalid Operation, no data to find median");
        }

        if ($this->leftMaxHeap->count() > $this->rightMinHeap->count()) {
            return $this->leftMaxHeap->top();
        } else {
            return $this->rightMinHeap->top();
        }

    }


}





