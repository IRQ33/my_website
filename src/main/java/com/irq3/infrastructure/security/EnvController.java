package com.irq3.infrastructure.security;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class EnvController {

    public static Map<String,String> readData(){
        Map<String, String> map = new HashMap<>();
        try(InputStream stream = EnvController.class.getClassLoader().getResourceAsStream(".env")) {
            if(stream==null){
                throw new RuntimeException("No file");
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            reader.lines()
                    .forEach(a->{
                        String[] s = a.split("=");
                        if(s.length!=2 )
                            throw new RuntimeException("Bad format with "+ a);
                        map.put(s[0].trim(),s[1].trim());
                    });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public static String getEnvValue(String key){
        Map<String,String> map = readData();
        return map.get(key);
    }
}
