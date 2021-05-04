public class LinkedListNode {
    private String product;    // product name (String)
    private LinkedListNode next; // next node
      

    public LinkedListNode(String product) {
        this.product = product;
        this.next = null;
    }

    public String getProduct() {
        return this.product;
    }

    public LinkedListNode getNext() {
        return this.next;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    public void setNext(LinkedListNode next) {
        this.next = next;
    }

}