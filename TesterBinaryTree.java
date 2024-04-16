public class TesterBinaryTree {
    public static void main(String[] args) {
        // Створення бінарного дерева
        BinaryTree<Integer> tree = new BinaryTree<>(1);

        // Додавання елементів до дерева
        tree.addNode(2, 1, true); // Додаємо 2 як лівого сина 1
        tree.addNode(3, 1, false); // Додаємо 3 як правого сина 1

        // Виведення дерева
        System.out.println("Binary Tree: " + tree);

        int element = 3;
        System.out.println("Element " + element + " is in the tree: " + tree.contain(element));

        System.out.println("Elements in our tree: " + tree.countNode());
    }
}
