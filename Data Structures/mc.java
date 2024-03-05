import java.util.Scanner;

public class mc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        node linkedList = null; // this is our LL which we will use to access our head and add-on.
        String key;

        try {
            linkedList = createNodes(input, linkedList);
            linkedList.printlist(linkedList);

            System.out.printf("Choose a node to remove (enter the value of the node): ");
            key = input.nextLine();

            linkedList.removeNode(linkedList, Integer.parseInt(key));
            linkedList.printlist(linkedList);
        } catch (Exception e) {
            System.err.println("Error creating nodes!");
        }

        input.close();
    }
    
    public static node createNodes(Scanner input, node head) {
        String numOfElements, value;

        System.out.printf("Enter the number of elements you want in your Linked List: ");
        numOfElements = input.nextLine();

        for (int x = 0; x < Integer.parseInt(numOfElements); x++) {
            System.out.printf("Enter a number: ");
            value = input.nextLine();

            if (head == null)
                head = new node(Integer.parseInt(value));
            else
                head.insertbytail_void(head, Integer.parseInt(value));
                //head = head.insertbytail(head, Integer.parseInt(value));
        }

        return head;
    }
}
