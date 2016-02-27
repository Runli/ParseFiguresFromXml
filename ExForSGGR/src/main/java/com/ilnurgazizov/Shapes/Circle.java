package com.ilnurgazizov.Shapes;

import java.util.List;

/**
 * Created by ilnurgazizov on 15.10.15.
 */

/**
 * @author Ilnur Gazizov
 *         Реализация интерфейса Shape для круга
 */
public class Circle implements Shape {
    public double executeSquare(List<Float> arrayList) {
        float pi = ((float) Math.PI);
        if (arrayList.get(0) < 0) {
//            System.out.print("Negative diameter! ");
            return -1;
        } else {
            double sq = pi * Math.pow(arrayList.get(0) / 2, 2);
            return sq;
        }
    }
}
