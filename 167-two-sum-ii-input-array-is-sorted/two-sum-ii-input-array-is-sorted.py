class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # Initialize pointers at the start and end of the array
        left, right = 0, len(numbers) - 1

        # Loop until the pointers cross
        while left < right:
            current_sum = numbers[left] + numbers[right]

            if current_sum == target:
                # Found the pair, return 1-based indices
                return [left + 1, right + 1]
            elif current_sum < target:
                # Sum is too small, move the left pointer to a larger value
                left += 1
            else:
                # Sum is too large, move the right pointer to a smaller value
                right -= 1