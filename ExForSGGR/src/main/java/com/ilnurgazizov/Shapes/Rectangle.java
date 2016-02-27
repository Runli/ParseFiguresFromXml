package com.ilnurgazizov.Shapes;

import java.util.List;

/**
 * Created by ilnurgazizov on 15.10.15.
 */

/**
 * @author Ilnur Gazizov
 *         Реализация интерфейса Shape для прямоугольлника
 */
public class Rectangle implements Shape {
    public double executeSquare(List<Float> arrayList) {
        if (arrayList.get(0) < 0 || arrayList.get(1) < 0) {
//            System.out.print("Negative side! ");
            return -1;
        } else {
            double sq = arrayList.get(0) * arrayList.get(1);
            return sq;
        }
    }
}
