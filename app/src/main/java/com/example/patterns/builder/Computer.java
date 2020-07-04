package com.example.patterns.builder;

import androidx.annotation.NonNull;

/**
 * 建造者模式——简单的建造者
 */
public class Computer {

    private String cpu;
    private String gpu;
    private String power;
    private int ram;
    private int hardDisk;

    private Computer() {
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
                "cpu: " + cpu +
                "gpu: " + gpu +
                "power: " + power +
                "ram: " + ram +
                "hardDisk: " + hardDisk;
    }

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.gpu = builder.gpu;
        this.power = builder.power;
        this.ram = builder.ram;
        this.hardDisk = builder.hardDisk;
    }

    public static class ComputerBuilder {

        private String cpu = "default cpu";
        private String gpu = "default gpu";
        private String power = "default power";
        private int ram = 1;
        private int hardDisk = 1;

        public ComputerBuilder ofCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public ComputerBuilder ofGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder ofPower(String power) {
            this.power = power;
            return this;
        }

        public ComputerBuilder ofRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder ofHardDisk(int hardDisk) {
            this.hardDisk = hardDisk;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
