package com.example.patterns.combination.safeCombination;

/**
 * 安全的组合模式——叶子节点
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void invoke() {
        System.out.println("invoke: " + name);
    }
}
