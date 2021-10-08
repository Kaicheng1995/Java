/**
* Step 1: find the first descending number
* Step 2: find the just bigger number
* Step 3: swap them and reverse the rest numbers
*/


class Solution {
    public void nextPermutation(int[] nums) {
        
        // calculate 1st descending number
        int first = nums.length - 1;
    	for (int i = nums.length - 1; i > 0; i--) {
    		if (nums[i-1] < nums[i]) {
    			first = i-1;
    			break;
    		}
    	}

    	// calculate just bigger number
    	if (first != nums.length - 1) {
    		int bigger = first + 1;
    		for (int i = first + 1; i < nums.length; i++) {
    			if (nums[i] > nums[first]) {
    				bigger = i;
    			} else {break;}
    		}
    		
	    	// swap them
	        int temp = nums[bigger];
	        nums[bigger] = nums[first];
	        nums[first] = temp;

	        // reverse the rest (这里不是sort，因为已经是递减的顺序了，即使交换之后)
	        int start = first + 1;
	        int end = nums.length - 1; 
	        while (start < end) {
	        	int temp = nums[start];
	        	nums[start] = nums[end];
	        	nums[end] = temp;
	        	start++;
	        	end--;
	        }

	    } else {
	    	// reverse the whole
	    	int start = 0;
	        int end = nums.length - 1; 
	        while (start < end) {
	        	int temp = nums[start];
	        	nums[start] = nums[end];
	        	nums[end] = temp;
	        	start++;
	        	end--;
	    	}
	    }
    }
}