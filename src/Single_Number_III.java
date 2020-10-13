import java.util.*;

/********************************Using Bit Manipulation***************/
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none
class Single_Number_III {
	public int[] singleNumber(int[] nums) {
		int bitMask = 0;
		for(int i=0; i<nums.length; i++){
			bitMask ^= nums[i];
		}
		//[1,2,1,3,2,5] => combination of 3 and 5, seperate single number out of it
		int diff = bitMask & (-bitMask);
		int bitMask2 = 0;
		for(int i=0; i<nums.length; i++){
			if((diff & nums[i]) != 0){
				bitMask2 ^= nums[i];
			}
		}
		return new int[]{bitMask2, bitMask2 ^ bitMask};
	}
}



/********************************Using HashSet***************/
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none

class Single_Number_III_HashSet {
	public int[] singleNumber(int[] nums) {
		int[] arr = new int[2];
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++){
			//if set contains elements, then remove from set else add
			if(set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
		}
		//converting set to Array
		Object[] toArr = set.toArray();
		arr[0] = (int)toArr[0];
		arr[1] = (int)toArr[1];

		return arr;
	}
}
