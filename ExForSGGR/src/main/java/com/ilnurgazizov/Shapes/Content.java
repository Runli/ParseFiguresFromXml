package com.ilnurgazizov.Shapes;

import java.util.ArrayList;

/**
 * Created by ilnurgazizov on 15.10.15.
 */
/**
 * @author Ilnur Gazizov
 * Класс Content для выполнения различных действий с данными полученными во время парсинга .xml документа
 * Реализация паттерна Стратегия.
 * */
public class Content {
    private Shape shape;                        // ссылка на объект реализующий интерфейс Shape
    private String color;                       // цвет фигуры
    private ArrayList<Float> arrayList;         // параметры фигуры хранятся в массиве ArrayList
    // Constructor
    public Content() {
        arrayList = new ArrayList<>();
    }
    /**
     * Метод setShape() устанавливает нужный тип объекта
     * @param Shape shape -         объект нужной фигуры
     * @return void
     * */
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    /**
     * Метод executeSquare() вычисляет площадь фигуры по данных в ArrayList
     * @return double  -            вычисленная площадь фигуры
     * */
    public double executeSquare() {
        return shape.executeSquare(arrayList);
    }
    /**
     * Метод setColor() устанавливает нужный цвет объекта
     * @param String color -        цвет фигуры
     * @return void
     * */
    public void setColor(String color) {this.color = color;}
    /**
     * Метод getColor() получает нужный цвет объекта
     * @return String
     * */
    public String getColor() {
        return color;
    }
    /**
     * Метод addArrayList() добавляет парметр объекта в ArrayList
     * @param float number -        значение параметра фигуры
     * @return void
     * */
    public void addArrayList(float number) {
        this.arrayList.add(number);
    }
    /**
     * Метод clearArrayList() удаляет все элементы из ArrayList
     * Сделано для того чтобы не скапливать эначения параметров фигур и не расходовать память и время работы с ними
     * @return void
     * */
    public void clearArrayList(){
        this.arrayList.clear();
    }
}
