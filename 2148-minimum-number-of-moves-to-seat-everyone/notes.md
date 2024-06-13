Explanation of [2037. Minimum Number of Moves to Seat Everyone](https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/?envType=daily-question&envId=2024-06-13) solution.

# Intuition:
The core idea of the solution is to use a frequency array to track the imbalance between the number of students and the number of seats at each position. By iterating through this frequency array, we can determine the minimum number of moves required to balance this imbalance, effectively assigning each student to a seat.

# Approach:

1. **Initialization**:
   - Create an array `pos` of size 101 (since the positions range from 1 to 100).
   - Initialize a variable `res` to store the result (the total number of moves).
   - Initialize a variable `current` to keep track of the current imbalance.

2. **Populate the `pos` array**:
   - For each position in the `seats` array, increment the corresponding index in the `pos` array.
   - For each position in the `students` array, decrement the corresponding index in the `pos` array.
   - This will help in tracking the net effect of students and seats at each position.

3. **Calculate the minimum moves**:
   - Iterate through the `pos` array.
   - For each element in `pos`, add the absolute value of `current` to `res`.
   - Update `current` by adding the current element of `pos` to it.
   - This step effectively accumulates the total number of moves required to balance the students and seats.

# Complexity:

## Time Complexity:
- **Initialization and population of `pos` array**: 
  - Iterating through the `seats` array and the `students` array: O(n)
- **Calculating the minimum moves**:
  - Iterating through the `pos` array (fixed size of 101): O(1)

Thus, the overall time complexity is **O(n)**.

## Space Complexity:
- The `pos` array is of fixed size 101, which is a constant space: O(1)
- Additional variables (`res` and `current`): O(1)

Thus, the overall space complexity is **O(1)**.
