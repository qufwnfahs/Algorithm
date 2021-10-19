import kotlin.math.max

/**
 * [URL] https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * [TAG] Array, Dynamic Programming
 *
 * [Example]
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */

class BestTimeToBuyAndSellStock {

    // 현재까지의 최소값 - 최대값이 나올 수 있는 가장 큰 값이기에 가능
    // O(n)
    fun maxProfit(prices: IntArray): Int {
        var buyPrice = 10_000
        var maxProfit = 0

        prices.forEach { price ->
            if (price < buyPrice) {
                buyPrice = price
            } else {
               maxProfit = max(maxProfit, price - buyPrice)
            }
        }
        return maxProfit
    }

    /**
     * 배열의 최대 부분 합을 O(n)의 시간복잡도로 구하는 카데인 알고리즘
     * currentProfit이 0보다 작아지면 부분합의 시작을 옮기면 된다.
     * @currentProfit 현재 팔 때의 이익
     * @maxProfit 찾았던 최대 이익
     */
    fun kadaneAlgorithm(prices: IntArray): Int {
        var currentProfit = 0
        var maxProfit = 0

        for (i in 1 until prices.size) {
            currentProfit += prices[i] - prices[i - 1]
            currentProfit = max(0, currentProfit)
            maxProfit = max(maxProfit, currentProfit)
        }
        return maxProfit
    }
}