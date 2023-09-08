func twoSum(nums []int, target int) []int {
    b := []int{}
    nums1 := []int{}
inc := 0
    for i, v := range nums {
        if len(nums) > 1 {
           nums1 = nums[i+1:] 
inc = inc + 1
        } else {
            break;
        }

        for i1, v1 := range nums1 {
            if ((v+v1) == target) {
                b = append(b, i, (i1+inc))
                break
            }
            
        }
            if len(b) > 0 {
                break;
            } 
        
    }
    
    return b
}
