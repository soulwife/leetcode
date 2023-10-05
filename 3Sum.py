class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            left = i+1
            right = len(nums)-1
            while(left < right):
                sum = nums[i] + nums[left] + nums[right]
                if sum < 0:
                    left+=1
                elif sum >0:
                    right-=1
                else:
                    result.append([nums[i],nums[left],nums[right]])
                    while left<len(nums)-1 and nums[left] == nums[left + 1] : left += 1
                    while right > 0 and nums[right] == nums[right - 1]: right -= 1
                    left+=1
                    right-=1
        return result
