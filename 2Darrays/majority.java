public class majority {
    public static void majority(int arr[][], int array[]){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (array[i] == (arr[j][0])){
                    arr[j][1]++;
                }
            }
        }
        for (int j = 0; j < arr.length; j++){
            if (arr[j][1] > (array.length - 1)/2){
                System.out.println("Majority = "+ j);
            }
        }
    }
    public static void main(String args[]){
        int arr[][] = {{0,0},{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0},{9,0}};
        int array[] = {3,2,3};
        majority(arr, array);

    }
}
