//1,2,3,4,|*10*,--9,8,7,6,5 

//


public boolean exists(int[] array, int num) {

    int split = 0;
    for (int i=1; i<array.length; i++) {
    
        if (array[i] < array[i-1]) {
            split = i-1;
            break;
        }
    }
    
    int start =0;
    int end = split-1;
    boolean found=false, found2=false;
    while(!found && (start <end)) {
    
        if (array[(start+end)/2] < num) {
            start = (start+end)/2;
        } else if  (array[(start+end)/2] >num) {
            split = (start+end)/2;
        } else {
            found =true;
        }
    }
    
    if (!found ) {
        start = split;
        end = array.length -1;
        while(!found2 && (start <end)) {
        
            if (array[(start+end)/2] > num) {
                start = (start+end)/2;
            } else if  (array[(start+end)/2] <num) {
                split = (start+end)/2;
            } else {
                found2 =true;
            }
        
        }
    
    
    }
    
    return (found || found2);



}
