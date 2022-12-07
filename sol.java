public class sol {
    public static void main(String[] args) {
        BiNode<Integer> bst = new BiNode<>(2), b1 = new BiNode<Integer>(4);
        bst.setLeft(new BiNode<Integer>(1));
        bst.setRight(b1);
        b1.setLeft(new BiNode<Integer>(3));
        b1.setRight(new BiNode<Integer>(5));

        System.out.println(bst);
        for (int i = 1; i < 10; i++) {
            int x = findSmallestAtK(bst, i);
            if (x == -1)
                System.out.println("none found");
            else
                System.out.println(i + "-th smallest element: " + x);
        }
    }

    private static int findSmallestAtK(BiNode<Integer> bst, int k) {
        // K starts counting at 1 instead of 0, we have to subtract 1 from it.
        if (bst == null)
            return -1; // If given root is null, return -1.

        int leftCount = 0; // Assume there are zero nodes to its left
        if (bst.getLeft() != null)
            leftCount = bst.getLeft().count();
        if (k - 1 == leftCount)
            return bst.getValue();
        if (k - 1 < leftCount) {
            if (bst.getLeft() == null)
                return -1; // overshot
            return findSmallestAtK(bst.getLeft(), k);
        }
        if (bst.getRight() == null)
            return -1; // overshot
        return findSmallestAtK(bst.getRight(), k - 1 - leftCount);

    }
}