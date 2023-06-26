public class recursion {

    public static int factorial(int n){
        if (n== 0){
            return 1;
        }
        int num = factorial(n-1);
        int fact = n * factorial((n-1));
        return fact;
    }
    public static void Oneton(int n){
        if (n == 1){
            System.out.print(1+ " ");
            return;
        }
        Oneton(n-1);
        System.out.print(n + " ");
    }

    public static int fibonacci(int n){
        if (n == 1 || n == 0){
            return n;
        }
        int f1 = fibonacci(n-1);
        int f2 = fibonacci(n-2);
        int fibatn = f1+f2;
        return fibatn;
    }

    public static boolean sortedcheck(int arr[], int i){
        if (i == arr.length-1){
            return true;
        }
        if (arr[i] > arr[i+1]){
            return false;
        }
        return sortedcheck(arr, i +1);
    }

    public static int keysearch(int arr[], int i, int key){
        if (arr[i] == key){
            return i;
        }
        if (i == arr.length - 1){
            System.out.println("Key not present in array");
            return 0;
        }
        return keysearch(arr,i+1, key);
    }

    public static int LastOccurrence(int arr[],int key, int i){
        if(i == arr.length){
            return -1;
        }
        int isFound = LastOccurrence(arr, key, i+1);
        if (isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }

    public static int xtopow(int x, int n){
        if (n == 0){
            return 1;
        }
        int xtooneless = xtopow(x, n-1);
        return x * xtooneless;
    }

    public static int optimizedpower(int x, int n){
        if (n == 0){
            return 1;
        }
        int halfpower = optimizedpower(x, n/2);
        int power = halfpower * halfpower;
        if (n % 2 != 0){
            power *= x;
        }
        return power;
    }

    public static void main(String args[]){
        int arr[] = {2,4,3,4,5};
        //System.out.println(LastOccurrence(arr,4 , 0));
        System.out.println(optimizedpower(2,5));
    }
}
