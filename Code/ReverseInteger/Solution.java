public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x *= sign;
        int i = 1;
        int reverse = 0;
        while (x / i != 0) {
            reverse = reverse * 10 + x / i % 10;
            i *= 10;
        }

        return reverse * sign;
    }

	public static void main(String []args) {
		System.out.println(reverse(0));
		System.out.println(reverse(123));
		System.out.println(reverse(100));
		System.out.println(reverse(-100));
	}
}