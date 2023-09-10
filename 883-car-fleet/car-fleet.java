class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] carData = new double[n][2];
        for(int i=0;i<n;i++){
            carData[i][0] = position[i]*1d;
            carData[i][1] = ((target-position[i])*1d)/speed[i];
        }
        Arrays.sort(carData,(a,b)->(Double.compare(a[0],b[0])));
        int noOfCars =1;
        double tt = carData[n-1][1];
        for(int i=n-2;i>=0;i--){
            if(carData[i][1]>tt){
                noOfCars++;
                tt=carData[i][1];
            }
        }
        return noOfCars;
    }
}