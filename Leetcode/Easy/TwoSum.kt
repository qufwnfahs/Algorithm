/**
 * [URL] https://leetcode.com/problems/two-sum/
 * [TAG] Array, Hash Table
 *
 * [Example]
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

class Solution {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        bruteForce(nums, target) // Inefficient way.

        return hashTable(nums, target)
    }

    // 실행 시간 : O(n^2)
    // nums 배열의 모든 원소를 탐색하여 결과를 반환.
    private fun bruteForce(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            if (i > target) break

            for (j in i + 1 until nums.size) {
                if (nums[i] + nums[j] > target) break

                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(0, 1)
    }

    // 이 문제의 답은 무조건 1가지가 존재한다고 명시되어 있으므로,
    // target - nums[i] = nums[j]이 하나만 성립한다.
    // 이를 통해 HashTable을 이용한다면 O(n).
    private fun hashTable(nums: IntArray, target: Int): IntArray {
        // key : nums 안의 숫자.
        // value : nums 안의 key의 인덱스
        val hashMap = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val key = target - nums[i]

            hashMap[key]?.let {
                return intArrayOf(it, i)
            }
            hashMap[nums[i]] = i
        }
        return intArrayOf(0, 1)
    }
}