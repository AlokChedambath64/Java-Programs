public class bitwise {
    public static int getithbit(int n, int i){
        int bitmask = 1 << i;
        if ((n & bitmask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int setithbit(int n, int i){
        int bitmask = 1 << i;
        return (n|bitmask);
    }

    public static int clearithbit(int n, int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }

    public static int updateithbit(int n, int i, int newbit){
        if (newbit == 0){
            return (clearithbit(n, i));
        }
        else{
            return (setithbit(n,i));
        }
    }
    public static int clearibits(int n, int i){
        int bitmask = -1 << i;
        return n & -1 << i;
    }

    public static int clearinrange(int n, int i, int j){
        int a = (-1) << (j+1);
        int b = (1<<i) - 1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static void main(String args[]){
        System.out.println(getithbit(4,2));
        System.out.println(setithbit(4,1));
        System.out.println(clearithbit(4,2));

    }
}
