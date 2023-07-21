public class backtracking {
    public static void subsets(String str, String ans, int i){
        if (i == str.length()){
            System.out.println(ans);
            return;
        }
        //yes
        subsets(str, ans + str.charAt(i), i  + 1);
        //no
        subsets(str, ans, i + 1);
    }

    public static void permutations(String str, String ans, int strlen){
        if (strlen == 0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            //adding two substrings to get the string with the char eliminated
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutations(newStr, ans + curr, strlen - 1);
        }
    }
    public static void main(String args[]){
        String str = "abc";
        //System.out.println(str.length());
        int strlen = str.length();
        permutations(str, "", strlen);
    }
}
