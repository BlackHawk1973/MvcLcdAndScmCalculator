package org.top.mvclcdandscmcalculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.top.mvclcdandscmcalculator.service.CalcResults;
import org.top.mvclcdandscmcalculator.service.Calculation;
import org.top.mvclcdandscmcalculator.service.InitialData;

// Контроллер приложения обрабатывает и принимает запросы
@Controller
public class MainController {
    private final Calculation calculation;

    public MainController(Calculation calculation) {
        this.calculation = calculation;
    }
    //Обработчик вызова начальной страницы
    @GetMapping("")
    public String index() {
        return "index";
    }

    // обработчик получения страницы с формой
    @GetMapping("calculation-form")
    public String calcForm(Model model) {
        // добавление пустого объекта исходных данных в модель
        // чтобы форма могла заполнить этот объект и передать post-обработчику
        InitialData emptyinitialData = new InitialData(1, 1);
        model.addAttribute("initialData", emptyinitialData);
        return "calculation-form";
    }

    // обработчик формы
    @PostMapping("calculation-form")
    public String calc(InitialData initialData, Model model) {
        // 1. считать входные данные
        System.out.println("> получены данные " + initialData);

        //2. решить задачу поиска НОД и НОК сервисом
        try {
            CalcResults calcResults = calculation.solveGcdLcm(initialData);
            System.out.println("Найден результат: " + calcResults);

            // 3. записать ответ
            model.addAttribute("initialData", initialData);
            model.addAttribute("calcResults", calcResults);
        } catch (IllegalArgumentException ex) {
            System.out.println("> возникла ошибка: " + ex.getMessage());
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "calculation-form";
    }
}
