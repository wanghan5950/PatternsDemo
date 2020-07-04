package com.example.patterns.wrapper;

/**
 * 装饰模式——穿昂贵衣服的人
 */
public class ExpensiveDressedPerson extends DressedPerson {

    public ExpensiveDressedPerson(Person person) {
        super(person);
    }

    /**
     * 定义装饰方法
     */
    private void dressShirt() {
        System.out.println("穿短袖");
    }

    private void dressLeather() {
        System.out.println("穿皮衣");
    }

    private void dressJean() {
        System.out.println("穿牛仔裤");
    }

    @Override
    public void dressed() {
        super.dressed();
        //执行装饰方法
        dressShirt();
        dressLeather();
        dressJean();
    }
}
