
import java.util.HashMap;

public class BinaryTree<T> {
    T data;
    BinaryTree<T> leftSon;
    BinaryTree<T> rightSon;

    public BinaryTree(T data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public boolean hasLeftSon() {
        return this.leftSon != null;
    }

    public boolean hasRightSon() {
        return this.rightSon != null;
    }

    public int countNode() {
        if (isEmpty()) return 0;
        int count = 1; // починаємо з кореня
        if (this.leftSon != null) {
            count += this.leftSon.countNode();
        }
        if (this.rightSon != null) {
            count += this.rightSon.countNode();
        }
        return count;
    }

    public BinaryTree<T> findNode(T element) {
        if (element == null || this.isEmpty()) {
            return null;
        }
        if (this.data.equals(element)) {
            return this;
        }
        BinaryTree<T> result;
        if (this.leftSon != null) {
            result = this.leftSon.findNode(element);
            if (result != null) return result;
        }
        if (this.rightSon != null) {
            result = this.rightSon.findNode(element);
            if (result != null) return result;
        }
        return null;
    }

    public boolean contain(T element) {
        return findNode(element) != null;
    }

    public void addNode(T element, T parent, boolean leftOrRight) {
        if (element == null || parent == null) {
            throw new IllegalArgumentException();
        }

        BinaryTree<T> parentTree = findNode(parent);
        if (parentTree == null) {
            throw new IllegalArgumentException();
        }

        if (leftOrRight) {
            if (parentTree.hasLeftSon()) {
                throw new IllegalArgumentException();
            }
            parentTree.leftSon = new BinaryTree<>(element);
        } else {
            if (parentTree.hasRightSon()) {
                throw new IllegalArgumentException();
            }
            parentTree.rightSon = new BinaryTree<>(element);
        }
    }

    public String encode(String text, HashMap<T, String> codeMap) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            T key = (T) Character.valueOf(c);
            if (codeMap.containsKey(key)) {
                encodedString.append(codeMap.get(key));
            } else {
                throw new IllegalArgumentException();
            }
        }
        return encodedString.toString();
    }

    public String decode(String code, HashMap<String, T> codeMap) {
        StringBuilder decodedString = new StringBuilder();
        StringBuilder currentCode = new StringBuilder();
        for (char c : code.toCharArray()) {
            currentCode.append(c);
            if (codeMap.containsKey(currentCode.toString())) {
                decodedString.append(codeMap.get(currentCode.toString()));
                currentCode = new StringBuilder();
            }
        }
        return decodedString.toString();
    }

    public String toString() {
        // позначаю () якщо leftSon\rightSon == null
        if (isEmpty()) return "()";
        String result = "(" + this.data;

        if (this.leftSon != null) {
            result += this.leftSon.toString();
        } else result += "()";

        if (this.rightSon != null) {
            result += this.rightSon.toString();
        } else result += "()";

        result += ")";
        return result;
    }
}
