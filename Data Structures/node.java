public class node {
    private int data;
    private node next;

    // constructor that creates a new node in memory when we create a new object of this class
    public node (int data) {
        this.data = data;
        this.next = null;
    }

    // overload method to create a new node that points to another node (has an existing node value)
    public node(int data, node next) {
        this.data = data;
        this.next = next;
    }


    // creates a node and then inserts the new at the end of the LL (Linked List)
    public node insertbytail(node head, int data) {
        node temp = new node(data); // creating a new node
        node iter = head; // using head as reference

        if (head == null) return temp;

        while (iter.next != null) 
            iter = iter.next;

        iter.next = temp;

        return head;
    }

    // same thing as the previous method but doesn't have a return type because it modifies directly the linked list passed by parameter
    public void insertbytail_void(node head, int data) {
        node temp = new node(data); // creating a new node
        node iter = head; // using head as reference

        if (head == null) {
            head = temp;
            return;
        }

        while (iter.next != null) {
            iter = iter.next;
        }
    
        iter.next = temp;
    }

    // prints the list by traversing it from head to tail
    public void printlist(node head) {
        node iter = head;

        while (iter != null) {
            System.out.printf("%d%s", iter.data, iter.next != null ? " -> " : " -> NULL\n");
            iter = iter.next;
        }
    }

    // removes a node from the LL
    public node removeNode(node head, int key) {
        node iter = head;
        node temp;

        while (iter.next != null) { // checking one step ahead
            if (iter.next.data == key) { // we check for the element to be removed in the next node (easier for us to get prev node of the one to be removed)
                temp = iter.next; // temporarily hold the node we want to remove
                iter.next = temp.next; // make the next position skip over the node we want to remove (hence we get the node after temp)
                temp = null; // replace the memory of the node to be removed with null (no longer exists in memory for efficiency)
                return head;
            }
            iter = iter.next; // iterate through the LL
        }

        System.out.println("Could not find the requested node to be removed (No element found).");
        return head;
    }
}