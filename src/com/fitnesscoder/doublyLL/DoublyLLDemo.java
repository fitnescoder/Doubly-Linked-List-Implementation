package com.fitnesscoder.doublyLL;

public class DoublyLLDemo {

    public static Node insertAtHead(int data, Node head) {
        if(head==null) {
            Node temp=new Node(data);
            head=temp;
            return head;
        }

        Node node=new Node(data);
        node.next=head;
        head.prev=node;
        head=node;
        return head;
    }

    public static Node insertAtTail(int data, Node tail) {
        Node temp=new Node(data);
        tail.next=temp;
        temp.prev=tail;
        tail=tail.next;
        return tail;
    }

    public static Node insertAt(int position, int data, Node head) {

        if(position==1) {
            return insertAtHead(data, head);
        }

        Node curr=head;
        int count=1;
        while(count<position-1 && curr!=null) {
            count++;
            curr=curr.next;
        }

        Node temp=new Node(data);
        Node forward=curr.next;
        curr.next=temp;
        temp.prev=curr;
        temp.next=forward;
        return head;

    }

    private static Node deleteAt(int pos, Node head) {

        if(pos==1) {
            head=head.next;
            head.prev=null;
            return head;
        }
        Node curr=head;
        int count=1;
        while(count<pos-1 && curr!=null) {
            count++;
            curr=curr.next;
        }

        curr.next=curr.next.next;
        return head;
    }

    public static void main(String[] args) {

        Node head=null;
        Node tail=null;

        head=insertAtHead(10, head);
        tail=head;
        head=insertAtHead(5, head);
        tail=insertAtTail(15,tail);
        tail=insertAtTail(20,tail);
        System.out.println("===After Insertion at Head and Tail===");
        printDLL(head);

        insertAt(5,25,head);
        insertAt(3,11,head);
        System.out.println("===After Insertion at Position Given===");
        printDLL(head);

        deleteAt(4,head);
        head=deleteAt(1,head);
        System.out.println("===After Performing Delete Operation===");
        printDLL(head);
    }



    private static void printDLL(Node head) {

        Node curr=head;

        while(curr!=null) {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
