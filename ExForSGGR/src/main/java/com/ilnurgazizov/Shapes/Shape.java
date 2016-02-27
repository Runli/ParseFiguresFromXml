package com.ilnurgazizov.Shapes;

import java.util.List;

/**
 * Created by ilnurgazizov on 15.10.15.
 */
/**
 * @author Ilnur Gazizov
 * Интерфейс Shape для вы числения нужных значений.
 * В данном случае площади, но можно добавить еще и периметр, вписанные/описанные окружности и т.д.
 * */
public interface Shape {
    /**
     * Метод executeSquare() вычисляет площадь фигуры
     * @param List<Float> args -        значения параметров фигуры
     * @return double -                 вычисленная площадь
     * */
    double executeSquare(List<Float> args);
}
