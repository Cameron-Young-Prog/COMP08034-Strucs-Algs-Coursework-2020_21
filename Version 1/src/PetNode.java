public class PetNode implements Comparable<PetNode> {
    private String animal;    // animal name (String)
    private PetNode left;    // left child
    private PetNode right;    // right child
    
    
    public PetNode() {
        
    }

    public PetNode(String animal) {
        this.animal = animal;
        
    }
    
    public String getAnimal() {
        return this.animal;
    }

    public PetNode getLeft() {
        return this.left;
    }

    public PetNode getRight() {
        return this.right;
    }


    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setLeft(PetNode left) {
        this.left = left;
    }

    public void setRight(PetNode right) {
        this.right = right;
    }

    @Override
    public int compareTo(PetNode a) {
        return this.animal.compareTo(a.animal);
    }

    @Override
    public String toString() {
        return this.animal;
    }
}
