package com.example.patterns.adapter;

/**
 * 适配器模式——实现目标接口即为适配器
 */
public class VoltAdapter implements FiveVolt {

    private Volt220 volt220;

    public VoltAdapter(Volt220 volt220) {
        this.volt220 = volt220;
    }

    @Override
    public int getVolt5() {
        System.out.println(volt220.getVolt220());
        return 5;
    }
}
