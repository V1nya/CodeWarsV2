package com.company.pz5_3;

public class BinaryTree<V> {
    MyNode root;

    public void push(V value, int key) {
        if (root == null) {
            root = new MyNode<V>(value, key);
        } else {
            root.insert(new MyNode(value,key));
        }
    }

    public V peek(int key) {
        if (root.getKey() != key) {
            return (V) root.search(key);
        } else {
            return (V) root.getValue();
        }
    }

    public void remove(int key) {
        if (root.getKey() == key) {
            if (root.getRight() != null) {
                if (root.getLeft() != null)
                    root.getLeft().setParent(root.getRight());
                root = root.getRight();
            } else {
                if (root.getLeft() != null) {
                    root = root.getLeft();
                    root.setParent(null);
                } else {
                    root = null;
                }
            }
        } else {
            root.remove(key);
        }

    }
}
