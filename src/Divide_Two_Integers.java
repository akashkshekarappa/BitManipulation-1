//Time Complexity : O(log n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none


/*First, we need to check whether the end result is positive or negative. Two cases will lead to negative case which is when dividend and divisor has different signs.

Second part is to deal with overflow, convert them to long first, and convert it back to integer when returning the value.

We know that division is actually the backward of multiplication, for example , 20 / 5 = 4 can be seen as 4 * 5 = 20. Here what we are going to do is to find the multiplication. We set tmp as divisor (5) and set count to 1. As long as the tmp is less than or equal to dividend (20), we left shift << which is same as multiply 2 but without using multiplication.

1st loop --- tmp = 10 , count = 2 
2nd loop --- tmp = 20, count = 4
3rd loop --- tmp = 40, count = 8 (exit the loop)
Now we right shift both tmp and count by 1, which gives us result of 4 . After subtraction of 20 from dividend, which gives us dividend = 0 and that we break out the outer loop and get to the last part.

Finally, we gotta check if the sign is positive or negative. If it is negative, then we apply negation ~result + 1 (two's complement) to get the negative result.
 **/

class Solution {
	public int divide(int dividend, int divisor) {
		boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true : false;

		long lDividend = Math.abs((long) dividend);
		long lDivisor = Math.abs((long) divisor);
		long result = 0;
		while(lDividend >= lDivisor){
			long tmp = lDivisor;
			long count = 1;
			while(tmp <= lDividend){
				tmp <<= 1;
				count <<=1;
			}
			result+= count >> 1;
				lDividend -= tmp >> 1;
		}
		return  isNegative ? (int) ~result + 1 : result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;

	}
}