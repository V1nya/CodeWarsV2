package com.company.pz5_3;

public class MyNode<V> {
    private V value;
    private int key;
    private MyNode parent;
    private MyNode left;
    private MyNode right;

    public MyNode() {
    }

    ;

    public MyNode(V value, int key) {
        this.value = value;
        this.key = key;
    }

    public MyNode(V value, int key, MyNode parent) {
        this.value = value;
        this.key = key;
        this.parent = parent;
    }

    public V getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public MyNode getParent() {
        return parent;
    }

    public void setParent(MyNode parent) {
        this.parent = parent;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }


    public void insert(MyNode node) {

        if (this.getKey() <= node.getKey()) {
            if (this.right == null) {
                this.right = node;
                this.right.setParent(this);
            } else
                this.right.insert(node);
        } else {
            if (this.left == null) {
                this.left = node;
                this.left.setParent(this);
            } else {
                this.left.insert(node);
            }
        }
    }

    public V search(int key) {
        if (this.key != key) {
            if (this.key >= key) {
                return (V) this.left.search(key);
            } else {
                if (this.right != null)
                    return (V) this.right.search(key);

            }
        }
        return value;
    }

    public void remove(int key) {
        if (this.right.getKey() == key) {
            if (this.right.right != null) {
                this.right.right.setParent(this);
                if (this.right.left != null)
                    this.right.left.setParent(this);
                MyNode leftNode = this.right.left;
                this.setRight(this.right.right);
                if (leftNode != null)
                    insert(leftNode);
            } else if (this.right.left != null) {
                this.right.left.setParent(this);
                if (this.right.right != null)
                    this.right.right.setParent(this);
                this.setLeft(this.right.left);
            } else {

                this.right = null;
            }
        } else if (this.left.getKey() == key) {
            if (this.left.right != null) {
                this.left.right.setParent(this);
                if (this.left.left != null)
                    this.left.left.setParent(this);
                MyNode leftNode = this.left.left;
                this.setLeft(this.left.right);
                if (leftNode != null)
                    insert(leftNode);
            } else if (this.left.left != null) {
                this.left.left.setParent(this);
                if (this.left.right != null)
                    this.left.right.setParent(this);
                this.setLeft(this.left.left);
            } else {
                this.left = null;
            }

        } else {
            if (this.key > key) {
                this.left.remove(key);
            } else {
                this.right.remove(key);
            }
        }

    }
}