class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemovedLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to simplify edge cases, like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse the list until the end
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the next node if it matches the value
                current.next = current.next.next;
            } else {
                // Move to the next node only if no deletion is done
                current = current.next;
            }
        }

        // Return the new head, which is the next node of the dummy
        return dummy.next;
    }
}