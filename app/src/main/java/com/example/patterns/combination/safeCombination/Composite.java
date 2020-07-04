package com.example.patterns.combination.safeCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全的组合模式——枝干节点
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
        //遍历储存的节点
        for (Component component : components) {
            component.invoke();
        }
    }

    /**
     * 添加叶子节点
     * @param leaf 叶子节点
     */
    public void addLeaf(Component leaf) {
        components.add(leaf);
    }

    /**
     * 移除叶子节点
     * @param leaf 叶子节点
     */
    public void removeLeaf(Component leaf) {
        components.remove(leaf);
    }

    /**
     * 获取叶子节点
     * @param index 叶子节点下标
     * @return 叶子节点
     */
    public Component getLeaf(int index) {
        return components.get(index);
    }
}
