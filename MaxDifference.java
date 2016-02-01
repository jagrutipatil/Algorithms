// calculate maximum difference between two elements in unsorted array such that min element's index is less than max elements index

 static int maxDifference(int[] a) { 
		if (a.length < 2) 
		   return -1;
		
		int max = a[a.length-1] , maxDiff = -1, i = 0;

		for (i = a.length -2 ; i >= 0 ; i--) {
			if (max < a[i]) {
				max =a[i];
			} else {
				if ((max - a[i]) > maxDiff) {
					maxDiff = max - a[i];
				}
			}
		}	
		
		return maxDiff;
    }
