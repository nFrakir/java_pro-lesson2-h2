package com.gmail.silverleaf.annn;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CurrencyParser parser = new CurrencyParser();
        try {
            parser.parse();
            List<Currency> currencies = parser.getCurrencies();

            for (Currency element: currencies) {
                System.out.println(element);
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }
}
