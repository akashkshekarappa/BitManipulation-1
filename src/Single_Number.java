import java.util.*;
/********************************Using Bit Manipulation***************/
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none
class Single_Number_Bit{
	public int singleNumber(int[] nums) {
		int bitMask =0;
		//if numbers are same , i.e 2^2 = 0
		for(int i=0; i<nums.length; i++){
			bitMask ^= nums[i];
		}
		return bitMask;
	}
}


/********************************Using HashMap***************/
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none

class Single_Number_HashMap {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
		}
		for(int i=0; i<nums.length; i++){
			if(map.get(nums[i]) == 1)
				return nums[i];
		}
		return 0;
	}
}

/********************************Using HashSet***************/
//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none

class Single_Number_HashSet {
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<nums.length; i++){
			if(set.contains(nums[i]))
				set.remove(nums[i]);
			else
				set.add(nums[i]);
		}
		return (int) set.iterator().next();
	}
}


/********************************Using List***************/
//Time Complexity : O(n^2)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none

class Single_Number_BF {
	public int singleNumber(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<nums.length; i++){
			if(list.contains(nums[i]))
				list.remove(new Integer(nums[i]));
			else
				list.add(nums[i]);
		}
		return list.get(0);
	}
}
