class Solution {
    public int countSeniors(String[] details) {
        int sum=0;
        int inc=0;
        for(int i=0;i<details.length;i++){
            sum=sum*10+details[i].charAt(11)-48;
            sum=sum*10+details[i].charAt(12)-48;
            if(sum>60){
                inc++;
            }
            sum=0;
        }
        return inc;
    }
}