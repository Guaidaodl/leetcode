
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val result: ArrayList<List<Int>> = ArrayList()
        var lastThreeResult: List<List<Int>>? = null
        for (i in 0 until nums.size - 3) {

            val r = threeSum(nums, i + 1, target - nums[i])
            r.forEach {t ->
                lastThreeResult?.let {
                    if (exist(it, t)) {
                        return@forEach
                    }
                }
                result.add(listOf(nums[i], t[0], t[1], t[2]))
            }

            lastThreeResult = if (nums[i + 1] == nums[i]) {
                r
            } else {
                null
            }
        }

        return result
    }

    fun threeSum(nums: IntArray, begin: Int, target: Int): List<List<Int>> {

        val result: ArrayList<List<Int>> = ArrayList()
        var lastTwoResult: List<List<Int>>? = null
        for (i in begin until nums.size - 2) {

            val r = twoSum(nums, i + 1, target - nums[i])
            r.forEach {t ->
                lastTwoResult?.let {
                    if (exist(it, t)) {
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

    private fun exist(lastResult: List<List<Int>>, r: List<Int>): Boolean {
        lastResult.forEach {
            var same = true
            for (i in 0 until it.size) {
                if (it[i] != r[i]) {
                    same = false
                    break
                }
            }

            if (same) {
                return true
            }
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