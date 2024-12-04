class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0;
        int j=0;
        int len1=str1.length();
        int len2=str2.length();
        while(i<len1 && j<len2){
            int c1 = str1.charAt(i)-'a';
            int c2 = str2.charAt(j)-'a';
            if(c1==c2 || c2-c1==1 || c1-c2==25){
                i++;
                j++;
            }else {
                i++;
            }
        }
        return j==len2;
    }
}