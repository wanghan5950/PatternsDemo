package com.example.patterns.builder;

import androidx.annotation.NonNull;

/**
 * 建造者模式——可扩展的建造者
 */
public abstract class BaseComputer {

    protected String cpu;
    protected String gpu;
    protected String power;
    protected int ram;
    protected int hardDisk;

    protected BaseComputer(BaseComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.power = builder.power;
        this.ram = builder.ram;
        this.hardDisk = builder.hardDisk;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public String getPower() {
        return power;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    @NonNull
    @Override
    public String toString() {
        return "Computer:" +
                " cpu: " + cpu +
                " gpu: " + gpu +
                " power: " + power +
                " ram: " + ram +
                " hardDisk: " + hardDisk;
    }

    public abstract static class BaseComputerBuilder<T extends BaseComputerBuilder<T, K>, K extends BaseComputer> {

        private String cpu = "default cpu";
        private String gpu = "default gpu";
        private String power = "default power";
        private int ram = 1;
        private int hardDisk = 1;

        public T ofCpu(String cpu) {
            this.cpu = cpu;
            return (T)this;
        }

        public T ofGpu(String gpu) {
            this.gpu = gpu;
            return (T)this;
        }

        public T ofPower(String power) {
            this.power = power;
            return (T)this;
        }

        public T ofRam(int ram) {
            this.ram = ram;
            return (T)this;
        }

        public T ofHardDisk(int hardDisk) {
            this.hardDisk = hardDisk;
            return (T)this;
        }

        public abstract K build();
    }
}
