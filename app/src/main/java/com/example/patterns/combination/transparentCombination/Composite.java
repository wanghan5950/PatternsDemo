package com.example.patterns.combination.transparentCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * 透明的组合模式——枝干节点
 */
public class Composite extends Component {

    //用于存储节点的容器
    private List<Component> components = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void invoke() {
        System.out.println("invoke: " + name);
        for (Component component : components) {
            component.invoke();
        }
    }

    @Override
    public void addChild(Component child) {
        components.add(child);
    }

    @Override
    public void removeChild(Component child) {
        components.remove(child);
    }

    @Override
    public Component getChild(int index) {
        return components.get(index);
    }
}
