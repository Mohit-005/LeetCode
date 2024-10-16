class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder strBuilder = new StringBuilder();
        int total =a+b+c;//total number count for looping
        int aCount=0,bCount=0,cCount=0;
        for(int i=0;i<total;i++){
            if((a>=b && a>=c && aCount<2) || (bCount==2 && a>0) || (cCount==2 && a>0))
            {
                strBuilder.append('a'); //adding the a value to String
                a--;
                aCount++;
                bCount=0;
                cCount=0;
            }
            else if((b>=a && b>=c && bCount<2) || (aCount==2 && b>0) || (cCount==2 && b>0)){
                strBuilder.append('b'); //adding the a value to String
                b--;
                bCount++;
                aCount=0;
                cCount=0; 
            }
            else if((c>=a && c>=b && cCount<2) || (aCount==2 && c>0) || (bCount==2 && c>0)){
                strBuilder.append('c'); //adding the a value to String
                c--;
                cCount++;
                aCount=0;
                bCount=0; 
            }
            
        }return strBuilder.toString();
    }
}