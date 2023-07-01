public class mergesort {
    public static void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void mergesort(int arr[], int si, int ei){
        if (si >= ei){
            return;
        }
        int mid = si + (ei - si)/2;
        //sorting left side of mid
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);
        merge (arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei){
        //we need to create a temporary array to work on
        int temp[] = new int[ei - si + 1];
        //to traverse the sections of the array we need two iterators
        int i = si;
        int j = mid + 1;
        //iterator to traverse the temporary array
        int k = 0;

        while (i <= mid && j <= ei){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= ei){
            temp[k] = arr[j];
            k++;
            j++;
        }
        //copying the temporary array to the main array.
        for ( k = 0, i =si ; k < temp.length ; k++, i++){
            arr[i] = temp[k];
        }
    }

    public static void main(String args[]){
        int arr[] = {6, 3, 9, 5, 2, 8};
        mergesort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
