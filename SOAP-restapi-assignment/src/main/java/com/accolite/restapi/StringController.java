package com.accolite.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(path= "/stringOperation")
public class StringController {

    @GetMapping("/endsWithVovel/{string1}")
    public String concatenate(@PathVariable("string1") String string1) {
        string1 = string1.toLowerCase();
        if (string1.endsWith("a") || string1.endsWith("e") ||
                string1.endsWith("i") || string1.endsWith("o") ||
                string1.endsWith("u")) {
            return "String Ends with vowel";
        }
        return "String does not end with vowel";
    }
    @GetMapping("/hashCode/{string1}")
    public int hashCode(@PathVariable("string1") String string1) {
        return string1.hashCode();
    }



    @GetMapping("/length/{string1}")
    public int length(@PathVariable("string1") String string1) {
        return string1.length();
    }

    @GetMapping("/equals/{string1}/{string2}")
    public Boolean equals(@PathVariable("string1") String string1, @PathVariable("string2") String string2) {
        return string1.equals(string2);
    }

    @GetMapping("/substring/{string1}/{index1}/{index2}")
    public String substring(@PathVariable("string1") String string1, @PathVariable("index1") Integer index1, @PathVariable("index2") Integer index2) {
        return string1.substring(index1,index2);
    }


}