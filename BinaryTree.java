import java.util.NoSuchElementException;

public class BinaryTree<T> {
    T data;
    BinaryTree<T> leftSon;
    BinaryTree<T> rightSon;
    public BinaryTree(T data){
        if (data == null){
            throw new NoSuchElementException();
        }
        this.data = data;
    }
    public boolean isEmpty(){
        return this.data == null;
    }
    public boolean hasLeftSon() {
        return this.leftSon != null;
    }

    public boolean hasRightSon() {
        return this.rightSon != null;
    }
    public int countNode(){
        if (isEmpty()) return 0;
        int count = 1; //починаємо з кореня КЛП
        if (this.leftSon != null){
            count += this.leftSon.countNode();
        }
        if (this.rightSon != null){
            count += this.rightSon.countNode();
        }
        return count;
    }
    public BinaryTree<T> findNode(T element){
        if (element == null || this.isEmpty()) {
            return null;
        }
        if (this.data.equals(element)) {
            return this;
        }
        BinaryTree<T> result;
        if (this.leftSon != null){
            result = this.leftSon.findNode(element);
            if(result != null) return result;
        }
        if (this.rightSon != null){
            result = this.rightSon.findNode(element);
            if(result != null) return result;
        }
        return null;
    }
    public boolean contain(T element) {
        return this.findNode(element) != null;
    }
    public void addNode(T element, T parent, boolean leftOrRight) {
        if (element == null || parent == null) {
            throw new IllegalArgumentException();
        }

        if (!contain(parent)) {
            throw new IllegalArgumentException();
        }

        if (!contain(element)) {
            BinaryTree<T> ourParent = this.findNode(parent);
            if (leftOrRight) {
                if (ourParent.hasLeftSon()) {
                    throw new IllegalArgumentException();
                }
                ourParent.leftSon = new BinaryTree<>(element);
            } else {
                if (ourParent.hasRightSon()) {
                    throw new IllegalArgumentException();
                }
                ourParent.rightSon = new BinaryTree<>(element);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    public String toString() {
        String result;
        if(this.isEmpty()) return "()";

        result = "(" + this.data;

        if (this.leftSon != null) {
            result += this.leftSon.toString();
        } else result += "()";

        if (this.rightSon != null) {
            result += this.rightSon.toString();
        } else result += "()";
        result  += ")";
        return result;

    }

}