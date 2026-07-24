package com.devsenior.andres;

import com.devsenior.andres.repository.DataRepository;
import com.devsenior.andres.service.AnalyticsService;
import com.devsenior.andres.ui.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        DataRepository dataRepository = new DataRepository();
        AnalyticsService analyticsService = new AnalyticsService(dataRepository);
        ConsoleUI consoleUI = new ConsoleUI(analyticsService);
        consoleUI.iniciar();
    }
}