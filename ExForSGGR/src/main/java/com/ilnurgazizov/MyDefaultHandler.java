package com.ilnurgazizov;

import com.ilnurgazizov.Shapes.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by ilnurgazizov on 15.10.15.
 */
/**
 * Класс MyDefaultHandler наследован от DefaultHandler.
 * Переопределены методы интерфейса ContentHandler.
 * */
public class MyDefaultHandler extends DefaultHandler {

    private static int count = 0;                   // счетчик числа обработанных фигур
    private Content content = new Content();
    private String element = "";
    /**
     * Метод обозначающий начало сканирования документа
     * @return void
     * */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }
    /**
     * Метод обозначающий конец сканирования документа
     * @return void
     * */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("Finish parse XML...");
    }
    /**
     * Метод вызывается в начале разметки.
     * @param uri -          URI пространства имен(если включен режим управления пространствами имен)
     * @param localName -    Локальное имя без префикса(если включен режим управления пространствами имен)
     * @param qName -        Имя элемента(если отключен режим управления пространствами имен) или
     *               уточненное имя с префиксом(если анализатор сообщает уточненные имена, помимо локальных имен)
     * @return void
     * */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
    }
    /**
     * Метод вызывается в конце разметки.
     * @param uri -          URI пространства имен(если включен режим управления пространствами имен)
     * @param localName -    Локальное имя без префикса(если включен режим управления пространствами имен)
     * @param qName -        Имя элемента(если отключен режим управления пространствами имен) или
     *               уточненное имя с префиксом(если анализатор сообщает уточненные имена, помимо локальных имен)
     * @return void
     * */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("triangle") || localName.equals("circle") ||
                localName.equals("square") || localName.equals("rectangle")) {
            System.out.println(String.format("%d: %s - %.2f",
                    count, content.getColor(), content.executeSquare()));
            content.clearArrayList();
        }
        element = "";
    }
    /**
     * Метод вызывается при полуении символьных данных.
     * @param ch -          массив символьных данных
     * @param start -       индекс первого символа в массиве, составляющем часть сообщаемых символьных данных
     * @param length -      длина сообщаемой символьной строки
     *
     * @return void
     * */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element.equals("triangle")) {
            MyDefaultHandler.count++;
            content.setShape(new Triangle());
            return;
        } //через if{} else if{} дольше!
        if (element.equals("circle")) {
            MyDefaultHandler.count++;
            content.setShape(new Circle());
            return;
        }
        if (element.equals("square")) {
            MyDefaultHandler.count++;
            content.setShape(new Square());
            return;
        }
        if (element.equals("rectangle")) {
            MyDefaultHandler.count++;
            content.setShape(new Rectangle());
            return;
        }
        if (element.equals("color")) {
            content.setColor(new String(ch, start, length));
            return;
        }
        if (element.equals("side") || element.equals("diameter")) {
            content.addArrayList(new Float(new String(ch, start, length)));
            return;
        }
    }
}
