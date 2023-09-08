<? 
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function singleNumber($nums) {
        foreach($nums as $num) {
            $res = array_keys($nums, $num);
            if (count($res) === 1) 
                break;
        }
        return $nums[$res[0]];
    }
}

$s = new Solution();
var_dump($s->singleNumber([1,3,4,2,1,4,3]));
?>
