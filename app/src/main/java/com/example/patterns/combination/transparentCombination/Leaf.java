package com.example.patterns.combination.transparentCombination;

/**
 * 透明的组合模式——叶子节点
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void invoke() {
        System.out.println("invoke: " + name);
    }

    @Override
    public void addChild(Component child) {
        System.out.println("no child: " + name);
    }

    @Override
    public void removeChild(Component child) {
        System.out.println("no child: " + name);
    }

    @Override
    public Component getChild(int index) {
        System.out.println("no child: " + name);
        return null;
    }
}
