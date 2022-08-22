public class Node {
    Node next = null;
    int data;
    public int length = 0;

    public Node(int d) {
        data = d;
        length++;
    }

    void append(int d) {
        Node end = new Node(d);
        Node n = this;

        while(n.next != null) {
            n = n.next;
        }

        n.next = end;
        length++;
    }

    static void printList(Node head) {
        Node n = head;

        if(n.next == null) {
            System.out.print(n.data);
        }

        while(n.next != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }

        System.out.print(n.data + "\n"); /* if i used single characters for '/n' it would print the number
        n.data plus whatever the ascii value of \n is! */
    }
}