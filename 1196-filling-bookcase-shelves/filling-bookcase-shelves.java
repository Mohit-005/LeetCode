class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return mine(books, shelfWidth);
    }

    private int mine(int[][] books, int shelfWidth) {
        return recurse(books, new Integer[books.length], 0, shelfWidth);
    }

    private int recurse(int[][] books, Integer[] cache, int position, int shelfWidth) {
        if (position >= books.length) {
            return 0;
        }

        if (cache[position] != null) {
            return cache[position];
        }

        int currWidth = 0;
        int totalHeight = Integer.MAX_VALUE;
        int maxHeight = 0;
        int pointer = position;
        while (pointer < books.length && currWidth + books[pointer][0] <= shelfWidth) {
            maxHeight = Math.max(maxHeight, books[pointer][1]);
            currWidth += books[pointer][0];
            totalHeight = Math.min(totalHeight, 
                maxHeight + recurse(books, cache, pointer + 1, shelfWidth));
            pointer++;
        }

        cache[position] = totalHeight;
        return totalHeight;
    }
}