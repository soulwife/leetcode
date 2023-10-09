/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {
    if head == nil || head.Next == nil {
        return head
    }
    
    newHead := head.Next
    current := head
    var previous *ListNode
    
    for current != nil && current.Next != nil {
        tmp := current.Next
        
        current.Next = tmp.Next
        tmp.Next = current
        
        if previous != nil {
            previous.Next = tmp
        }
        
        previous = current
        current = current.Next
    }
    
    return newHead
}
