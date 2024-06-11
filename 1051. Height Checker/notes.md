# Explanation of LeetCode Problem [1051. Height Checker](https://leetcode.com/problems/height-checker/) Solution

# Intuition

The problem is to find the number of students who are not in their correct positions based on their heights. This is done by comparing the current order of students with the expected order, which is the sorted order of the students by height. The expected order is calculated by counting the frequency of each height and then placing the students in that order.

# Approach

Here is the approach explained using pseudo code:

### Pseudo Code

1. Initialize `heightsFreq` and `expected` arrays:
   ```java
   for(int index =0; index < heights.length; index++){
       heightsFreq[heights[index]]++;
   }
   int count =0;
   for(int index =0; index < heightsFreq.length && count < heights.length; index++){
   while(heightsFreq[index]>0){
           expected[count++]= index;
           heightsFreq[index]--;
   }
   }
   ```
2. Calculate the expected order of students based on their heights:
   ```java
   for(int index =0; index < heights.length; index++){
   if(heights[index]!= expected[index]){
           diffCount++;
   }
   }
   ```

### Explanation

1. **Step 1: Count the frequency of each height**
   * Initialize the `heightsFreq` array with all elements set to 0.
   * Iterate over the `heights` array and increment the corresponding element in `heightsFreq` for each height.
2. **Step 2: Calculate the expected order of students**
   * Initialize the `expected` array with all elements set to 0.
   * Iterate over the `heightsFreq` array and place each height in the `expected` array in the order they appear.
   * Use a variable `count` to keep track of the current position in the `expected` array.
3. **Step 3: Compare the current order with the expected order**
   * Iterate over the `heights` array and compare each height with the corresponding height in the `expected` array.
   * If the heights do not match, increment the `diffCount` variable.
4. **Step 4: Return the number of students who are not in their correct positions**
   * Return the `diffCount` variable, which stores the number of students who are not in their correct positions based on their heights.

Here is the pseudo code in a more detailed form:

```java
function heightChecker(heights):
// Initialize the frequency array
    heightsFreq =newint[101]
for each height in heights:
        heightsFreq[height]++

// Initialize the expected array and the count variable
    expected =newint[heights.length]
    count =0
    diffCount =0

// Calculate the expected order of students
for each height in heightsFreq:
while heightsFreq[height]>0:
            expected[count++]= height
            heightsFreq[height]--

// Compare the current order with the expected order
for each height in heights:
if height != expected[heights.indexOf(height)]:
            diffCount++

// Return the number of students who are not in their correct positions
return diffCount
```

This pseudo code explains the approach used in the Java code to solve the problem.

# Complexity

## Time Complexity

The time complexity of the Java code is O(n log n) due to the sorting operation. The sorting operation is done using the built-in sort function in Java, which has a time complexity of O(n log n). The other operations, such as counting the frequency of each height and comparing the current order with the expected order, have a time complexity of O(n), which is dominated by the sorting operation.

**Time Complexity: O(n log n)**

## Space Complexity

The space complexity of the Java code is O(n) due to the use of the frequency array and the expected array. The frequency array is used to count the frequency of each height, and the expected array is used to store the expected order of students based on their heights. Both arrays have a size of n, where n is the number of students.

**Space Complexity: O(n)**
