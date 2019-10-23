package com.gmail.silverleaf.annn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CurrencyParser extends DefaultHandler {
    private String apiUrl = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private List<Currency> currencies = new ArrayList<>();

    public CurrencyParser() {
        super();
    }

    public CurrencyParser(String apiUrl) {
        super();
        this.apiUrl = apiUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    @Override
    public String toString() {
        return "CurrencyParser{" +
                "apiUrl='" + apiUrl + '\'' +
                ", currencies=" + currencies +
                '}';
    }

    public void parse() throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(apiUrl);
        Element root = document.getDocumentElement();
        NodeList nodeList = root.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i+=1) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element row = (Element) node;
                NamedNodeMap attributes = row.getChildNodes().item(0).getAttributes();

                Currency currency = new Currency();
                currency.setBase_currency(attributes.getNamedItem("base_ccy").getTextContent());
                currency.setCurrency(attributes.getNamedItem("ccy").getTextContent());

                String rateValue = attributes.getNamedItem("buy").getTextContent();
                Double tmp = Double.valueOf(rateValue);
                currency.setBuy(tmp);

                rateValue = attributes.getNamedItem("sale").getTextContent();
                tmp = Double.valueOf(rateValue);
                currency.setSale(tmp);

                currencies.add(currency);
            }
        }
    }
}
