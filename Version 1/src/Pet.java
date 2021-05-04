import java.lang.String;

public class Pet implements Comparable<Pet> {

    private PetNode root;    // root of BST
    private PetNode current;    // current node of BST
    private PetNode parent;    // parent node of child

    private String getTree(PetNode current, Integer level) {
        String treeDetails = new String(); 
        level++;

        if (current != null) {
            treeDetails += this.getTree(current.getRight(), level);
            for (Integer i = 0; i < level; i++) {
                treeDetails += "    ";
            }
            treeDetails += current.getAnimal()+ " \n";
            treeDetails += this.getTree(current.getLeft(), level);
        } else {
            for (Integer i = 0; i < level; i++) {
                treeDetails += "    ";
            }
            treeDetails += "null\n";
        }
        return treeDetails;
    }

    public void insert(String animal) throws Exception {
        PetNode newNode = new PetNode(animal);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.insert(newNode, this.root);
        }
    }

    private void insert(PetNode newNode, PetNode current) throws Exception{
        if (newNode.getAnimal().compareTo(current.getAnimal()) == 0)
            throw new Exception();
        if (newNode.getAnimal().compareTo(current.getAnimal()) < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                this.insert(newNode, current.getLeft());
            }
        } else if (current.getRight() == null) {
            current.setRight(newNode);
        } else {
            this.insert(newNode, current.getRight());
        }
        
    }

    /** Helper function for find */
    public PetNode find(String animal){
        // returns node of animal in BST
        return this.find(animal, this.root);
    }

    /** finds animal in BST */
    private PetNode find(String animal, PetNode current){
            // initialise node of animal
            PetNode foundAnimal;
            foundAnimal = null;
            // recursively find animal in BST
            if (current != null) {
                if (animal.compareTo(current.getAnimal()) == 0) {
                    this.current = current;
                    foundAnimal = current;
                } else {
                    this.parent = current;
                    if (animal.compareTo(current.getAnimal()) < 0) {
                        foundAnimal = this.find(animal, current.getLeft());
                    } else {
                        foundAnimal = this.find(animal, current.getRight());
                    }
                }
            } 
            else {
                throw new NullPointerException();
            }

            return foundAnimal;    // returns node of found animal
    }

    /** Removes animal from BST */
    public Comparable remove(String animal){
        // animal to delete
        Comparable removedAnimal = this.find(animal);

        if (this.current.getLeft() == null && this.current.getRight() == null) {
            this.replaceNode(null);
        } else if (this.current.getLeft() != null && this.current.getRight() == null) {
            this.replaceNode(this.current.getLeft());
            this.current.setLeft(null);
        } else if (this.current.getLeft() == null && this.current.getRight() != null) {
            this.replaceNode(this.current.getRight());
            this.current.setRight(null);
        }
        return removedAnimal;
    }

    /** Replaces node in BST with child node */
    private void replaceNode(PetNode replacement) {
        // removing root
        if (this.current == this.root) {
            this.root = replacement;
        } else if (this.current == this.parent.getLeft()) {
            this.parent.setLeft(replacement);
        } else {
            this.parent.setRight(replacement);
        }
        this.current.setAnimal(null);
    }

    /* Prints BST contents */
    @Override
    public String toString(){
        String treeDetails = new String();
        if (this.root != null) {
            treeDetails += this.getTree(this.root, 0);   
        } else {
            treeDetails += "tree is empty";
        }
        return treeDetails;
    }

    @Override
    public int compareTo(Pet o) {
        return 0;
    }
}