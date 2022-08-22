/*
 * Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary
 * buffer was not allowed?
 */

public class TwoPointOne {
    /*
     * removes all duplicates from a LL. returns the new head.
     * 
     * Idea 1: Iterate through the list, and for every element, you loop through the list again and remove
     * all the elements that are equal to it. The runtime for this is not very efficient (O(n^2) quadratic)
     *      - let's try this way because i literally cannot think of anything else
     */
    static Node removeDuplicates(Node head) {
        Node a = head;

        while(a.next != null) {
            Node b = a.next;

            while(b.next != null) {
                if(a.data == b.data) {
                    removeNode(a.next, b.data);
                }
                b = b.next;
            }

            a = a.next;
        }

        return head;
        /*
         * i am hitting what the girlies call a block, my brain is lit rally not working so i will try again
         * a little later
         */
    }

    /*
     * removes the first node whose data value == d. returns the head of the new list.
     */
    static Node removeNode(Node head, int d) {
        Node n = head;
    
        if(n.data == d) {
            return n.next;
        }

        while(n.next != null) {
            if(n.next.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.append(1);
        head.append(7);
        head.append(2);
        head.append(1);
        head.append(7);
        head.append(1);
        head.append(6);

        Node.printList(head);

        //removeDuplicates(head);

        Node.printList(head);
    }
}

