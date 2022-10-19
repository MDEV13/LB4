package com.example.currencyexchange.controllers;

import com.example.currencyexchange.CurrencyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
public class MainController {

    @GetMapping("/main")
    public String mainPage(Model model)
    {
        try {
            model.addAttribute("currencies",CurrencyRequest.requestForCurrency());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "main.html";
    }
}
