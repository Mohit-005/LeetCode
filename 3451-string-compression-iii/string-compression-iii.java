class Solution {
    public String compressedString(String word) {
        int idx=0;int n=word.length();int i=0;
        // String comp="";
        StringBuilder comp=new StringBuilder();
        while(i<n){
            char ch=word.charAt(i);
            int cnt=0;
            while(i<n && word.charAt(i)==ch){
                i++;
                cnt++;
                if(cnt==9){
                    break;
                }
            }
            comp.append((char)(cnt+'0'));
            comp.append(ch);
            // comp+=(char)(cnt+'0');
            // comp+=ch;
        }
        return comp.toString();
    }
}