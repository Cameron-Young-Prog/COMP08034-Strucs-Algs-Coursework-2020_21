    /* attributes of linked list */
    public class LinkedList {
        private LinkedListNode head;    // root of linked list

        @Override
        public String toString() {
            String nodeDetails = new String();

            if (this.head != null) {
                LinkedListNode productCurrent = this.head;
                nodeDetails += "LIST: \t"; 
                while (productCurrent != null) {
                    nodeDetails += "|" + productCurrent.getProduct() + "|" + "\t";
                    productCurrent = productCurrent.getNext();
                }
            } else {
                nodeDetails += "list null";
            }
            return nodeDetails;

        }

        public void listInsert(PetNode productList, String product) throws Exception {
            LinkedList list = productList.getList();

            // Create LinkedListNode
            LinkedListNode newNode = new LinkedListNode(product);
    
            // Add new node to LinkedList
            if (list.head == null) {
                list.head = newNode;
            } else {
                LinkedListNode current = list.head;
                // require to explicitly set to null to avoid compilation error
                LinkedListNode previous = null;
                Boolean insertionPositionFound = false;
                while (!insertionPositionFound) {
                    if (product.compareTo(current.getProduct()) == 0) {
                        System.out.println("insert invalid - Value not unique");
                    }
                    if (product.compareTo(current.getProduct()) < 0) {
                        insertionPositionFound = true;
                        newNode.setNext(current);
                        if (current == list.head) {
                            list.head = newNode;
                        } else {
                            previous.setNext(newNode);
                        }
                    } else if (current.getNext() == null) {
                        insertionPositionFound = true;
                        current.setNext(newNode);
                    } else {
                        previous = current;
                        current = current.getNext();
                    }
                }
            }
        }

        public Boolean search(PetNode productList, String targetProduct) throws Exception{
            LinkedList list = productList.getList();

            Boolean isFound = false;
            
            LinkedListNode current = list.head;
            
            if (list.head == null) {
                System.out.println("ERROR: List is empty!");
                }
            
            while (!isFound) {
                if (targetProduct.equals(current.getProduct())) {
                    isFound = true;
                } else if (current.getNext() == null) {
                    throw new Exception();
                } else {
                    current.setNext(current);
                }
            }
            
            
            return isFound;
        }

        public Boolean remove(PetNode productList, String product) throws Exception{
            LinkedList list = productList.getList();

            Boolean isFound = true;
            
            LinkedListNode current = list.head;

            if (list.head == null) {
                System.out.println("ERROR: List is empty!");
            }
            while (isFound) {
                if (product.equals(current.getProduct())) {
                    current.setProduct(null);
                    isFound = false;
                } else if (current.getNext() == null) {
                    throw new Exception();
                } else {
                    current.setNext(current);
                }
                }
            return isFound;
        }
    }