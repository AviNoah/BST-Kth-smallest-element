public class BiNode<T> {
    private T value;
    private BiNode<T> left;
    private BiNode<T> right;

    public BiNode(T value, BiNode<T> right, BiNode<T> left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public BiNode(T value) {
        this(value, null, null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BiNode<T> getLeft() {
        return left;
    }

    public void setLeft(BiNode<T> left) {
        this.left = left;
    }

    public BiNode<T> getRight() {
        return right;
    }

    public void setRight(BiNode<T> right) {
        this.right = right;
    }

    public int getDepth() {
        // Returns the depth of the tree root.
        if (this.left == null && this.right == null)
            return 1;
        if (this.left == null)
            return 1 + this.right.getDepth();
        if (this.right == null)
            return 1 + this.left.getDepth();
        return 1 + Math.max(this.right.getDepth(), this.left.getDepth());
    }

    public boolean isAnagramOf(BiNode<T> other)
    {
        // If the values are not equal, return false.
        if(!this.value.equals(other.getValue()))
            return false;

        // Note anagrams are mirrors of one another therefore there should be symmetry between left and right of this and other.
        // Check left and right roots
        
            
        if(this.right != null)
            if(other.left == null) return false; 

        if(this.left != null)
            if(other.right == null) return false; 

        if(this.right == null)
            if(other.left != null) return false;

        if(this.left == null)
            if(other.right != null) return false;

        // A mirror of right or left exists.

        if(this.right == null && other.left == null)
            if(this.left == null && other.right == null) return true;
            else return this.getLeft().isAnagramOf(other.getRight());
        else
            if(this.left == null && other.right == null) return this.getRight().isAnagramOf(other.left);
            else return this.getRight().isAnagramOf(other.left) && this.getLeft().isAnagramOf(other.getRight());
        
    }

    @Override
    public String toString() {
        if (this.value == null)
            return "null";
        if (this.left == null)
            if (this.right == null)
                return this.value.toString();
            else
                return this.value.toString() + ", " + this.right.toString();
        else if (this.right == null)
            return this.left.toString() + this.value.toString();
        else
            return this.value.toString() + ", " + this.left.toString() + ", " + this.right.toString();
    }

}