package com.ilnurgazizov;
/**
 * Created by ilnurgazizov on 15.10.15.
 */

import java.util.Scanner;

/**
 * Main клавный класс с которого начинается работа программы.
 * Создается объект клсса @SAXParserProgramm методами которого производится проверка .xml документа .xsd схеме,
 * либо вычисления площадей фигур .
 * Так же вычисляется время работы программы в миллисекундах.
 */

public class Main {
    public static void main(String[] args) {
        String filePath; // когда в jar переведу надо будет поменять
        SAXParserProgramm saxParserProgramm; // ссылка на объект моего основного класса
        Scanner scanner = new Scanner(System.in);
        long startTime;
        long timeSpent;


        if (args.length != 0) { // если дан только xml
            filePath = args[0];
            saxParserProgramm = new SAXParserProgramm(filePath);
        } else {
            saxParserProgramm = new SAXParserProgramm(); // по умолчанию(если ничего не дано на вход программе)
        }

        System.out.println("What you want to do: ");
        System.out.println("check your .xml file for .xsd scheme(1), " +
                "parse data and execute calculations(2), " +
                "or quit from program(q)?");

        String userIn = scanner.nextLine();
        if (userIn.equals("2")) {
            startTime = System.currentTimeMillis();

            saxParserProgramm.goParseAndExecute();

            timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("The program worked " + timeSpent + " milliseconds.");
        } else if (userIn.equals("1")) {
            startTime = System.currentTimeMillis();

            System.out.println(saxParserProgramm.goCheckXMLForXSD());

            timeSpent = System.currentTimeMillis() - startTime;
            System.out.println("The program worked " + timeSpent + " milliseconds.");
        } else return;
    }
}
