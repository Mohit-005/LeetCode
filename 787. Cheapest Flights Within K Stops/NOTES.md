# Explanation of LeetCode Problem [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/description/?envType=daily-question&envId=2024-02-23) Solution


## Intuition

The problem involves finding the cheapest flight path from a source city to a destination city with a limited number of stops. The solution utilizes Breadth-First Search (BFS) to explore the graph while keeping track of the minimum cost to reach each node.

## Approach

### Data Structures:

- The code uses an unordered map `adj` to represent the adjacency list of the graph. Each node (airport) is mapped to a vector of pairs, where each pair represents an adjacent node and the cost (price) to reach that node.
- A vector `visited` is used to keep track of the minimum cost to reach each node from the source node. It is initialized with `INT_MAX` to represent that initially, the cost to reach all nodes is infinite.
- A queue `qu` is used for BFS traversal of the graph. It stores pairs of node and its accumulated cost so far.

### Initialization:

- The `visited` vector is initialized with `INT_MAX`, except for the source node, which is initialized with cost `0`. This represents that the cost to reach the source node from itself is `0`.

### Building Adjacency List:

- The code iterates through the `flights` vector and populates the adjacency list `adj` with the information provided in `flights`. Each flight (edge) is added to the adjacency list with its corresponding source node, destination node, and cost.

### BFS Traversal:

- The code performs BFS traversal with a slight modification to account for the number of stops (flights) allowed. It initializes `K` to `K+1` to accommodate the extra step for counting the destination node's cost.
- Within each iteration of BFS, the code traverses all nodes at the current level (or stop) in the BFS traversal.
- For each node, it calculates the cost to reach its neighbors considering the current accumulated cost. If this new cost is less than the previously recorded cost to reach that neighbor, it updates the cost and adds the neighbor to the queue for further exploration.
- The traversal continues until the number of stops allowed (`K`) becomes `0`, indicating that we've explored up to the allowed number of stops.

### Result:

- Finally, the function returns the cost to reach the destination node (`dst`). If there's no way to reach the destination node within the given number of stops, it returns `-1`.

## Complexity

- **Time complexity:** O(V + E), where V is the number of vertices and E is the number of edges in the graph.
- **Space complexity:** O(V + E), where V is the number of vertices and E is the number of edges in the graph.
