public class quicksort {
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void quicksort(int arr[], int si, int ei){
        if (si >= ei){
            return;
        }
        //
        int pIdx = partition(arr, si, ei);
        printArr(arr);
        quicksort(arr, si, pIdx - 1);//Left
        quicksort(arr, pIdx + 1, ei);//Right
    }

    public static int partition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si - 1;

        for(int j = si; j < ei; j++){
            if (arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }
        //to put pivot in the right location in the array
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;

        return i;
    }

    public static void main(String args[]){
        int arr[] = {6, 3, 9, 8, 2, 5};
        quicksort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}

