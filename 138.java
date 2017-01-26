//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

//Return a deep copy of the list.

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        Map<RandomListNode,RandomListNode> temMap = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode tempNode = head;
        
        while (tempNode != null) {
            temMap.put(tempNode, new RandomListNode(tempNode.label));
            tempNode = tempNode.next;
        }
        tempNode = head;
        
        while (tempNode != null) {
            temMap.get(tempNode).next = temMap.get(tempNode.next);
            temMap.get(tempNode).random = temMap.get(tempNode.random);
            tempNode = tempNode.next;
        }
        
        return temMap.get(head);
        
    }
}
