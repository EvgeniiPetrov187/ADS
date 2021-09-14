package com.petrov;

import java.util.ArrayList;
import java.util.List;


public class Main6 {
    public static void main(String[] args) {

        List<Tree<Integer>> list = new ArrayList<>();
        int treeSize = 20;
        int balanced = 0;

        for (int i = 0; i < treeSize; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            for (int j = 0; j <= tree.getSize(); j++) {
                tree.add((int) (Math.random() * 50) - 25);
            }
            list.add(tree);
            tree.display();
            System.out.println("Balance of tree " + i + ": " + Node.isBalanced(tree.getRoot()));
        }

        for (int i = 0; i < list.size(); i++) {
            if (Node.isBalanced(list.get(i).getRoot())) {
                balanced++;
            }
        }
        System.out.println("Сбалансированных деревьев: " + (balanced * 100 / treeSize) + " %");
    }
}

