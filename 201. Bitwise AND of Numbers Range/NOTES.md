# Explanation of LeetCode Problem [201. Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/description/?envType=daily-question&envId=2024-02-21) Solution

## Description
The provided code is a C++ solution to LeetCode problem 201 - Bitwise AND of Numbers Range. The problem asks to find the bitwise AND of all numbers between two given integers `left` and `right`, inclusive.

## Approach
The approach used in the code is to right-shift both `left` and `right` until they become equal. This is because the rightmost bits of `left` and `right` will be different, and the bitwise AND of any two numbers with different rightmost bits will always be 0. The number of times we right-shift `left` and `right` is counted using a variable `cnt`. Finally, we left-shift `left` by `cnt` to obtain the result.

## Breakdown of Key Components
### Initialization:
```cpp
int rangeBitwiseAnd(int left, int right) {
    int cnt = 0;
    // ...
}
```
We define a function `rangeBitwiseAnd` that takes two integers `left` and `right` as input. We initialize a variable `cnt` to 0.

### Right-shifting `left` and `right`:
```cpp
while (left != right) {
    left >>= 1;
    right >>= 1;
    cnt++;
}
```
We enter a while loop that continues until `left` and `right` become equal. In each iteration, we right-shift both `left` and `right` by 1 bit. We increment `cnt` by 1.

### Left-shifting `left`:
```cpp
return (left << cnt);
```
After the while loop terminates, we left-shift `left` by `cnt` bits. We return the result.

## Complexity Analysis
The time complexity of this algorithm is O(log n), where n is the difference between `left` and `right`. The space complexity is O(1), as we only use a constant amount of extra space to store the `cnt` variable.
