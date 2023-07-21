public class trappingrainwater {

    public static void main(String args[]){
        int height[] = {4, 2, 0, 6, 3, 2, 5};

        //corner cases
        if (height.length <= 2){
            System.out.println("No water will be trapped");
        }
        //initializing the auxilliary array for finding the max left
        int maxleft[] = new int[height.length];
        //giving the value of the first element in height to compare with
        maxleft[0] = height[0];

        //traversing the array forwards
        for(int i = 1; i < height.length; i++){
            //changing the value of maxleft array
            if(height[i] >= maxleft[i-1]){
                maxleft[i] = height[i];
            }
            else{
                maxleft[i] = maxleft[i-1];
            }
        }


        int maxright[] = new int[height.length];
        //giving a value to last element of maxright to compare with
        maxright[height.length-1] = height[height.length-1];

        //traversing the array backwards
        for(int i = height.length-2; i >= 0; i--){
            //Setting the values for maxright
            if(height[i] >= maxright[i+1]){
                maxright[i] = height[i];
            }
            else{
                maxright[i] = maxright[i+1];
            }
        }

        int trappedwater = 0;
        int waterabove = 0;
        int waterlevel;
        //traversing the array to calculate how much water will be stored in the array
        for(int i = 0; i < height.length; i++){
            //to calculate the level of water
            waterlevel = Math.min(maxleft[i],maxright[i]);
            //to calculate the water trapped
            waterabove = waterlevel - height[i];
            //to update the total water
            trappedwater += waterabove;
        }
        System.out.println("Total Water Trapped : "+ trappedwater);
    }
}
