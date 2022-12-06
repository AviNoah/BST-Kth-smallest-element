public class sol {
    public static void main(String[] args) {
        BiNode<Integer> bst = new BiNode<>(2);
        bst.setLeft(new BiNode<Integer>(1));
        bst.setRight(new BiNode<Integer>(3));
        int k = 1;
        int x = KthSmallestElement(bst, k);
        System.out.println(bst);
        if (x == -1)
            System.out.println("none found");
        else
            System.out.println(k + "-th smallest element: " + x);
    }

    private static int KthSmallestElement(BiNode<Integer> bst, int k) {
        // Sol: Walk left K steps, reducing K by 1.
        // When stepping right, add 1 and then keep going left K+1 steps
        // When there is no right, default to -1.

        if (k == 1) {
            if (bst.getLeft() == null)
                return bst.getValue(); // this is the smallest one.
            // bst has a left, there is a smaller element.
            return KthSmallestElement(bst.getLeft(), k);
        }

        // k is bigger than 1.

        if (bst.getLeft() != null)
            return KthSmallestElement(bst.getLeft(), k + 1);

        if (bst.getRight() != null) {
            return KthSmallestElement(bst.getRight(), k - 1); // Attempt right side.
        }

        return -1; // No possible way to find.
    }

}