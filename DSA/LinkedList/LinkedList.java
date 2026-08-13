
class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}



public class LinkedList {

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public LinkedList(int[] arr){
        head = null;
        size = 0;

        for(int num : arr){
            insert(num);
        }
    }

    public void insert(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            size++;
            return;
        }


        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

        size++;
    }


    public int size(){
        return size;
    }

    public void print() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }


    public boolean delete(int data){
        if(head == null){
            return false;
        }

        if(head.data == data){
            head = head.next;
            size--;
            return true;
        }

        Node temp = head;

        while(temp.next != null){
            if(temp.next.data == data){
                temp.next = temp.next.next;
                size--;
                return true;
            }

            temp = temp.next;

        }

        return false;
    }
}
