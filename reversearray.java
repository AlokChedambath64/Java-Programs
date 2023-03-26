public class arrays {
    //Creating Arrays
    public static int reverse(int array[]){
        int start = 0;
        int end = array.length-1;
        int temp;

        while(start < end) {
            temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
        return 0;
    }

    public static void main(String args[]){
        int nums[] = {1,2,4,6,422,5,67,84,2};

         reverse(nums);
         for (int i = 0; i < nums.length; i++){
             System.out.print(nums[i]+",");
         }
    }

}
