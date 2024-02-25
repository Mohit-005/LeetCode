# Explanation of [997. Find the Town Judge](https://leetcode.com/problems/find-the-town-judge/description/?envType=daily-question&envId=2024-02-21) Solution

This Java code is solving a problem where you're trying to find a "judge" in a town. The town has the following properties:
- The town consists of `n` people labeled from `1` to `n`.
- There is a rumor that one of these people is secretly the town judge.
- If the town judge exists, then:
    - The town judge trusts nobody.
    - Everybody (except for the town judge) trusts the town judge.
    - There is exactly one person that satisfies properties 1 and 2.

The function `findJudge` takes two parameters: an integer `n` representing the number of people in the town, and a 2D array `trust` where `trust[i] = [a, b]` represents that the person labeled `a` trusts the person labeled `b`.

Here's how the code works:

1. Two integer arrays `trusting` and `trusted` are created to keep track of the trust relationships. Each index in these arrays represents a person (index `0` is ignored as there is no person labeled `0`).

2. The code then iterates over the `trust` array. For each trust relationship `a -> b`, it increments `trusting[a]` (because `a` trusts someone) and `trusted[b]` (because `b` is trusted by someone).

3. The code then iterates over all people. If it finds a person who trusts nobody (i.e., `trusting[i] == 0`) and is trusted by `n - 1` people (i.e., `trusted[i] == n - 1`), it sets that person as the answer (`ans = i`).

4. Finally, the code returns the answer. If no judge is found, the answer remains `-1`.

This approach works because it accurately counts the trust relationships for each person, allowing us to identify the judge according to the problem's rules. It runs in O(n) time complexity as it makes a single pass over the trust relationships, and it uses O(n) space to store the trust counts. This meets the problem's constraints.