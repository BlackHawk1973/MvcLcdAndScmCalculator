package org.top.mvclcdandscmcalculator.service;

import org.springframework.stereotype.Service;

// Класс, позволяющий находить НОД двух чисел
@Service
public class Calculation {
    // метод находит НОД (алгоритмом Евклида) и НОК
    // вход: два числа
    // выход: НОД и НОК двух введенных чисел
    // в случае некорректных входных данных выбрасывает исключение
    public CalcResults solveGcdLcm(InitialData initialData) {
        Integer number1 = Math.abs(initialData.getNumber1());
        Integer number2 = Math.abs(initialData.getNumber2());

        // проверка входных данных
        if(number1 == null || number2 == null || number1 == 0 || number2 == 0) {
            throw new IllegalArgumentException("Исходные данные не должны быть равны нулю");
        }
        if (number1 > number2) {
            Integer calcGcd = gcd(number1, number2);
            Integer calcLcm = number1 * number2 / calcGcd;
            return new CalcResults(calcGcd, calcLcm);
        }
        else {
            Integer calcGcd = gcd(number2, number1);
            Integer calcLcm = number1 * number2 / calcGcd;
            return new CalcResults(calcGcd, calcLcm);
        }
    }

    public int gcd(Integer number1, Integer number2) {
        if (number2 == 0)
            return number1;
       else
           return gcd(number2, number1 % number2);
    }
}
