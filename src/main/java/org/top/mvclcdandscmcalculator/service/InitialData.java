package org.top.mvclcdandscmcalculator.service;

// Класс с исходными данными - натуральными числами, у которых нужно найти НОД и НОК
public class InitialData {
    // поля - натуральные числа
    private Integer number1;
    private Integer number2;

    // конструкторы

    public InitialData() {
    }

    public InitialData(Integer number1, Integer number2) {
        this.number1 = number1;
        this.number2 = number2;
    }
    // геттеры и сеттеры

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    @Override
    public String toString() {
        return "Найти НОД(" + number1 + ", " + number2 +") и НОК(" + number1 + ", " + number2 +")";
    }
}
