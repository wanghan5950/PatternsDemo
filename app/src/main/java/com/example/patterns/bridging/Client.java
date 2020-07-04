package com.example.patterns.bridging;

public class Client {

    public static void main(String[] args) {
        /**
         * Coffee和CoffeeAdditives独立变化，新增类型只需增加各自的实现
         * Coffee只需持有CoffeeAdditives的抽象引用
         */
        //大杯加糖咖啡
        Coffee largeSugar = new LargeCoffee(new Sugar());
        largeSugar.makeCoffee();
        //小杯原味咖啡
        Coffee smallOrdinary = new SmallCoffee(new Ordinary());
        smallOrdinary.makeCoffee();
    }
}
