package com.example.currencyexchange;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CurrencyRequest {

    public static String parseUrl(URL url) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
//                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static List<JSONObject> requestForCurrency() throws ParserConfigurationException, SAXException, IOException {
        JSONArray arrCurrencies = new JSONArray(parseUrl(new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5")));
        List<JSONObject> objs = new ArrayList<>();
        for(int i=0;i<arrCurrencies.toList().size();i++)
        {
            objs.add((JSONObject) arrCurrencies.get(i));

        }
        return objs;
    }

    public static void main(String[] args) {
        try {
            System.out.println(requestForCurrency());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
