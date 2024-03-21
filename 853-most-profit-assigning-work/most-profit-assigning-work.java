class Solution {
    public int maxProfitAssignment(int[] diff, int[] profit, int[] worker) {

	int pair[][] = new int[diff.length][2];
	for(int i = 0; i < diff.length; i++){
		pair[i][0] = diff[i];
		pair[i][1] = profit[i];
	}
	// sorting 2d array on basis of difficulty colmn
	Arrays.sort(pair, new Comparator<int[]>() {
		@Override
		public int compare(int o1[], int o2[]){
			return Integer.valueOf(o1[0]).compareTo(o2[0]);
		}
	});

	int totalProfit = 0;

	//MAGIC begins HERE
	Arrays.sort(worker);
	int bestPaySoFar = 0;
	int i = 0;      // declaring globally creates MAGIC!!

	for(int k = 0; k < worker.length; k++){
		int ability = worker[k];

		while(i < pair.length && ability >= pair[i][0]){
			if(bestPaySoFar < pair[i][1])
				bestPaySoFar = pair[i][1];
			i++;
		}

		totalProfit += bestPaySoFar;
	}

	    return totalProfit;
    }
}