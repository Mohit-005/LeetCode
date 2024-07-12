class Solution {
    public int maximumGain(String s, int x, int y) {
        char[] arrs = s.toCharArray();
        int rema = 0, remb = 0, cntx = 0, cnty = 0, ans = 0;
        for (char c : arrs) {
            if (c != 'a' && c != 'b') {
                ans += (x * cntx) + (y * cnty);
                rema = 0;
                remb = 0;
                cntx = 0;
                cnty = 0;
                continue;
            }
            if (c == 'a') {
                if (remb == 0) {
                    if (cntx > 0 && x < y) {
                        cntx--;
                        cnty++;
                    }
                    rema++;
                } else {
                    cnty++;
                    remb--;
                }
            }
            if (c == 'b') {
                if (rema == 0) {
                    if (cnty > 0 && y < x) {
                        cnty--;
                        cntx++;
                    }
                    remb++;
                } else {
                    cntx++;
                    rema--;
                }
            }
        }
        return ans + (x * cntx) + (y * cnty);
    }
}