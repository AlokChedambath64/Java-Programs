public class string {

    public static void anagram(String str1, String str2){
        int count = 0;
        for (int i = 0; i < str1.length(); i++){
            //Character ch = str1.charAt(i);
            Character ch = Character.toUpperCase(str1.charAt(i));
            for (int j = 0; j < str2.length(); j++){
                Character ch1 = Character.toUpperCase(str2.charAt(j));
                if (ch.equals(ch1)){
                    count++;
                }
            }
        }
        if (count == str1.length()){
            System.out.println("The given strings are anagrams");
        }
        else{
            System.out.println("The given strings are not anangrams");
        }
    }

    public static void main(String args[]){
        String str1 = "earth";
        String str2 = "heart";

        anagram(str1, str2);
    }
}
