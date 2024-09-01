class Solution {
    public String nearestPalindromic(String numberStr) {
        long number = Long.parseLong(numberStr);
        if (number <= 10) return String.valueOf(number - 1);
        if (number == 11) return "9";

        int length = numberStr.length();
        long leftHalf = Long.parseLong(numberStr.substring(0, (length + 1) / 2));
        
        long[] palindromeCandidates = new long[5];
        palindromeCandidates[0] = generatePalindromeFromLeft(leftHalf - 1, length % 2 == 0);
        palindromeCandidates[1] = generatePalindromeFromLeft(leftHalf, length % 2 == 0);
        palindromeCandidates[2] = generatePalindromeFromLeft(leftHalf + 1, length % 2 == 0);
        palindromeCandidates[3] = (long)Math.pow(10, length - 1) - 1;
        palindromeCandidates[4] = (long)Math.pow(10, length) + 1;

        long nearestPalindrome = 0;
        long minDifference = Long.MAX_VALUE;

        for (long candidate : palindromeCandidates) {
            if (candidate == number) continue;
            long difference = Math.abs(candidate - number);
            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                minDifference = difference;
                nearestPalindrome = candidate;
            }
        }

        return String.valueOf(nearestPalindrome);
    }

    private long generatePalindromeFromLeft(long leftHalf, boolean isEvenLength) {
        long palindrome = leftHalf;
        if (!isEvenLength) leftHalf /= 10;
        while (leftHalf > 0) {
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return palindrome;
    }
}


// class Solution {
//     public String nearestPalindromic(String n) {
        
//         char[] ques = n.toCharArray();
//         int len = n.length(), mid = len / 2;
//         char pair1[] = new char[mid + 1];
//         pair1[0] = ques[mid];
//         char pair2[] = new char[mid + 1];
//         pair2[0] = ques[mid];
//         boolean flag = isPalindrome(ques, ques.length, pair1);

//         if(flag){
//             char num = pair1[0] - '1';
//             pair1[0] = num;
//             if(mid % 2 != 0)
//                 pair1[1] = num;
//         }

//         System.out.println(Arrays.toString(pair1));


//         return "";


//     }

//     public boolean isPalindrome(char[] arr, int len, char pair1[]){
//         int i = 0, j = len - 1, pos = len / 2;
//         boolean flag = true;
//         while (i < j){
//             if(arr[i] != arr[j])
//                 flag = false;
//             pair1[pos--] = arr[i]; 
//             i++; j--;
//         }
//         return flag;
//     }
// }
