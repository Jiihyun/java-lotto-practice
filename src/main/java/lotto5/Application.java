package lotto5;

import lotto5.controller.MainController;

public class Application {
    public static void main(String[] args) {
        try {
            MainController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
