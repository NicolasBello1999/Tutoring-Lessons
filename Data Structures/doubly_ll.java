public class doubly_ll {
    
}

class node {
    public int data;
    public node next;
    public node prev;

    public node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public node insertByTail_iter(node head, int data) {
        node temp = new node(data);
        node cur = head;

        if (head == null) 
            return temp;
        
        while (cur.next != null)
            cur = cur.next;
        
        cur.next = temp;
        temp.prev = cur;
        
        return head;
    }

    
    public node insertByTail_rec(node head, int data) {
        if (head == null)
            return new node(data); // prevent us from every new node we insert being the same data value
        else if (head.next == null) {
            node temp = new node(data);
            head.next = temp;
            temp.prev = head;
            return head;
        } else {
            insertByTail_iter(head.next, data);
            return head;
        }
    }
}
