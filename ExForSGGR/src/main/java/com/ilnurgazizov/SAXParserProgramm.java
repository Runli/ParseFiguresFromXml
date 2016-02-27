package com.ilnurgazizov;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * Created by ilnurgazizov on 16.10.15.
 */
/**
 *  SAXParserProgramm класс для проведения парсинга .xml документа
 * */
public class SAXParserProgramm {
    private String filePath; // путь к XML
    private String xsdPath; // путь к XSD

    /**
     * 2 конструктора
     */
    public SAXParserProgramm() {
        this.filePath = "test.xml";
        this.xsdPath = "shapes.xsd";
    }

    public SAXParserProgramm(String filePath) {
        this.filePath = filePath;
        this.xsdPath = "shapes.xsd";
    }

    /**
     * Метод проверяет соответсвует ли .xml документ структуре описанного в .xsd
     *
     * @return boolean
     */
    public boolean goCheckXMLForXSD() {
        try {
            File xml = new File(filePath);
            File xsd = new File(xsdPath);
            if (!xml.exists() && !xsd.exists()) {
                System.out.println("Не найден XML " + filePath);
                System.out.println("Не найден XSD " + xsdPath);
                return false;
            }
            if (!xml.exists()) {
                System.out.println("Не найден XML " + filePath);
                return false;
            }
            if (!xsd.exists()) {
                System.out.println("Не найден XSD " + xsdPath);
                return false;
            }
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(filePath));
            return true;
        } catch (SAXException e) {
            e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Метод парсит .xml документ при помощи потокового анализатора SAX и
     * наследованного класса ответов MyDefaultHandler.
     * Метод void setNamespaceAware(boolean) устанавливает значение свойств, определяющиего режим управления
     * пространствами имен. Если установлено true параметра value, то в генерируемых фабрикой
     * синтаксических анализаторах бедет включен режим упраления пространствами имен.
     * @return void
     * */
    public void goParseAndExecute() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();
            MyDefaultHandler myDefaultHandler = new MyDefaultHandler();
            parser.parse(new File(filePath), myDefaultHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
