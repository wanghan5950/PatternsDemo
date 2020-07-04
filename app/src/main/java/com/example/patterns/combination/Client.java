package com.example.patterns.combination;

import com.example.patterns.combination.safeCombination.Composite;
import com.example.patterns.combination.safeCombination.Leaf;
import com.example.patterns.combination.transparentCombination.Component;

public class Client {

    public static void main(String[] args) {
        //安全的组合模式
        safeCombination();
        //透明的组合模式
        transparentCombination();
    }

    private static void safeCombination() {
        Composite root = new Composite("root");
        Composite branch1 = new Composite("branch1");
        Composite branch2 = new Composite("branch2");
        Leaf leaf1 = new Leaf("leaf1");
        Leaf leaf2 = new Leaf("leaf2");
        branch1.addLeaf(leaf1);
        branch2.addLeaf(leaf2);
        root.addLeaf(branch1);
        root.addLeaf(branch2);
        root.invoke();
    }

    private static void transparentCombination() {
        Component root = new com.example.patterns.combination.transparentCombination.Composite("root");
        Component branch1 = new com.example.patterns.combination.transparentCombination.Composite("branch1");
        Component branch2 = new com.example.patterns.combination.transparentCombination.Composite("branch2");
        Component leaf1 = new com.example.patterns.combination.transparentCombination.Leaf("leaf1");
        Component leaf2 = new com.example.patterns.combination.transparentCombination.Leaf("leaf2");
        root.addChild(branch1);
        root.addChild(branch2);
        branch1.addChild(leaf1);
        branch2.addChild(leaf2);
        root.invoke();
    }
}
