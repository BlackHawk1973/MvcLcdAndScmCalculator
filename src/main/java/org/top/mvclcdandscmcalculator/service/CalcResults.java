package org.top.mvclcdandscmcalculator.service;

import org.springframework.stereotype.Service;


public class CalcResults {
    private Integer gcd; //НОД
    private Integer lcm; //НОК

    public CalcResults() {
    }

    public CalcResults(Integer gcd, Integer lcm) {
        this.gcd = gcd;
        this.lcm = lcm;
    }
    // геттеры и сеттеры


    public Integer getGcd() {
        return gcd;
    }

    public void setGcd(Integer gcd) {
        this.gcd = gcd;
    }

    public Integer getlcm() {
        return lcm;
    }

    public void setLcm(Integer lcm) {
        this.lcm = lcm;
    }

    @Override
    public String toString() {
        return "НОД = " + gcd + ", НОК = " + lcm;
    }
}
