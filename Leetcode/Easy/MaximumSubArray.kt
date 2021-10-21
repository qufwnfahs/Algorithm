import kotlin.math.max

/**
 * [URL] https://leetcode.com/problems/maximum-subarray/
 * [TAG] Array, Dynamic Programming, Divide and Conquer
 *
 * [Example]
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
class MaximumSubArray {
    // Dynamic Programming
    fun kadaneAlgorithm(nums: IntArray): Int {
        var currentSum = nums[0]
        var largestSum = currentSum

        for (i in 1 until nums.size) {
            currentSum = max(nums[i], currentSum + nums[i])
            largestSum = max(largestSum, currentSum)
        }
        return largestSum
    }
}