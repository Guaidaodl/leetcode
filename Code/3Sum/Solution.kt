class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val result: ArrayList<List<Int>> = ArrayList()
        var lastTwoResult: List<List<Int>>? = null
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) return result

            val r = twoSum(nums, i + 1, 0 - nums[i])
            r.forEach {t ->
                lastTwoResult?.let {
                    if (exit(it, t)) {
                        return@forEach
                    }
                }
                val lastResult = listOf(nums[i], t[0], t[1])
                result.add(lastResult)
            }

            lastTwoResult = if (nums[i + 1] == nums[i]) {
                r
            } else {
                null
            }
        }

        return result
    }

    private fun exit(lastResult: List<List<Int>>, r: List<Int>): Boolean {
        lastResult.forEach {
            if (it[0] == r[0] && it[1] == r[1]) return true
        }

        return false
    }

    private fun twoSum(nums: IntArray, begin: Int, target: Int): List<List<Int>> {
        var b = begin
        var e = nums.size - 1

        val result: ArrayList<List<Int>> = ArrayList()
        while(b < e) {
            val sum = nums[b] + nums[e]
            if (sum > target) {
                do {
                    e--
                } while (b < e && nums[e] == nums[e + 1])
            } else  {
                if (sum == target) {
                    result.add(listOf(nums[b], nums[e]))
                }
                do {
                    b++
                } while (b < e && nums[b] == nums[b - 1])
            }
        }

        return result
    }
}