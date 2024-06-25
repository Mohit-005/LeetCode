import java.util.AbstractList;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return new AbstractList<List<Integer>>() {

            private List<List<Integer>> resList;

            private void onload() {
                resList = new ArrayList<>();

                List<int[]> heights = new ArrayList<>();
                for (int[] building : buildings) {
                    heights.add(new int[]{building[0], -building[2]});
                    heights.add(new int[]{building[1], building[2]});
                }
                Collections.sort(heights, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

                PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
                pq.offer(0);

                int prev = 0;
                for (int[] height : heights) {
                    if (height[1] < 0) {
                        pq.offer(-height[1]);
                    } else {
                        pq.remove(height[1]);
                    }
                    int cur = pq.peek();
                    if (prev != cur) {
                        resList.add(Arrays.asList(height[0], cur));
                        prev = cur;
                    }
                }
            }

            private void init() {
                if (null == resList) {
                    onload();
                    System.gc();
                }
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return resList.get(index);
            }

            @Override
            public int size() {
                init();
                return resList.size();
            }

        };
    }

}