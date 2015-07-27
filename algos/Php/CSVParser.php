
// Parse CSV

<?php

// php code is wrapped in <?php tags


/*
We're going to be implementing a simple CSV parsing library.
There are two things to focus on. The first (and most importantly)
is actually parsing the CSV format. The second is making a
clean API that another engineer would enjoy using.

Because we are doing this on coderpad, you may pass in each line
of the file as a string in an array instead of performing actual IO.

Here are the specifications that we will be following.
Please read through this carefully.
https://www.dropbox.com/s/whonai6ki6npewv/Screenshot%202014-09-08%2016.13.02.png?dl=0

You may assume that the CSV file is correctly formatted.

Given the following strings:
'John,Smith,john.smith@gmail.com,Los Angeles,1'
'Jane,Roberts,janer@msn.com,"San Francisco, CA",0'
'"Alexandra """"Alex""",Menendez,alex.menendez@gmail.com,Miami,1'

An ideal parse will look like this:

 [['John', 'Smith', 'john.smith@gmail.com', 'Los Angeles', '1'],
  ['Jane', 'Roberts', 'janer@msn.com', 'San Francisco, CA', '0'],
  ['Alexandra ""Alex"', 'Menendez', 'alex.menendez@gmail.com', 'Miami', '1']]
  
  
  
  


*/

print_r(parseCSV(array("John,Smith,john.smith@gmail.com,Los Angeles,1", "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0","\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1")));



function parseCSV($arrayOfStrings) {

    $output = array();
    foreach($arrayOfStrings as $string) {

        $tokens = array();
        $currentToken = "";
        $i=0;
        $startQuotedString = false;
        $quotesStarted = false;
        while ($i < strlen($string)) {

            $curr = substr($string, $i++, 1);

            $next = "";
            if ($i <strlen($string)) {
                $next = substr($string, $i, 1);
            }
            // TODO: Check quotes

            if ($curr == '"') {

                // 1. Already seen a quotes
                if ($quotesStarted) {

                    if ($next=='"' && !$startQuotedString) {
                        $startQuotedString = true;
                        $currentToken .= $curr;
                        continue;
                    }

                    if ($startQuotedString) {
                        $startQuotedString = false;
                        continue;
                    }

                    // $tokens[]  = $currentToken;
                    // $currentToken = "";
                    $quotesStarted = false;
                    continue;
                } else {
                    $quotesStarted = true;
                    continue;
                }
            }

            if ($curr == ',' && !$quotesStarted) {
                $tokens[] = $currentToken;
                $currentToken = "";
            } else {
                $currentToken .= $curr;
            }

        }

        if ($currentToken != "") {
            $tokens[] = $currentToken;
        }

        $output[] = $tokens;

    }

    return $output;

}
?>
                                                                                                                                                                                                                                                                                                                         