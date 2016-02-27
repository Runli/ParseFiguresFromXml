package com.ilnurgazizov.Shapes;

import java.util.List;

/**
 * Created by ilnurgazizov on 15.10.15.
 */

/**
 * @author Ilnur Gazizov
 *         Реализация интерфейса Shape для треугольника
 */
public class Triangle implements Shape {
    public double executeSquare(List<Float> arrayList) {
        if (arrayList.get(0) < 0 || arrayList.get(1) < 0 || arrayList.get(2) < 0) {
//            System.out.print("Negative side! ");
            return -1;
        } else if(arrayList.get(0) + arrayList.get(1) <= arrayList.get(2)
                || arrayList.get(0) + arrayList.get(2) <= arrayList.get(1)
                || arrayList.get(2) + arrayList.get(1) <= arrayList.get(0)){
//            System.out.print("Incorrect triangle`s sides! ");
            return -1;
        }
        else {
            double sq = 0.25 * Math.sqrt(
                    (arrayList.get(0) + arrayList.get(1) + arrayList.get(2) *
                            (arrayList.get(1) + arrayList.get(2) - arrayList.get(0)) *
                            (arrayList.get(0) + arrayList.get(2) - arrayList.get(1)) *
                            (arrayList.get(0) + arrayList.get(1) - arrayList.get(2)))
            );
            return sq;
        }
    }
}

