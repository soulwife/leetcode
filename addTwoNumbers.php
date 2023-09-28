<?
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val = 0, $next = null) {
 *         $this->val = $val;
 *         $this->next = $next;
 *     }
 * }
 */
class Solution {
    public ListNode $listNode;
    public function addValToString($obj, $str) {
        $str .= $obj->val;
        if (is_null($obj->next)) {
            return $str;
        } else {
            return $this->addValToString($obj->next, $str); 
        }
        
    }

    public function convertArrayToListNode(?ListNode $listNode, $array): ListNode {
        if (is_null($listNode)) {
            $this->listNode = new ListNode($array[0]);
            $listNode = clone $this->listNode;
        }
        $lastValue = array_shift($array);
        if (count($array) > 0) {
            $listNode->next = $this->convertArrayToListNode(new ListNode($array[0]), $array);
        } else {
            $listNode->val = $lastValue;
        }

        return $listNode;
    }

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    public function addTwoNumbers($l1, $l2) {
        $l1Str = $l2Str = '';
        $l1Str = $this->addValToString($l1, $l1Str);
        $l2Str = $this->addValToString($l2, $l2Str);

        $sum = bcadd((int)strrev($l1Str),(int)strrev($l2Str));
        $arrSum = str_split(strrev($sum));
        $this->listNode = $this->convertArrayToListNode(null, $arrSum);

        return $this->listNode;
    }
}
?>
