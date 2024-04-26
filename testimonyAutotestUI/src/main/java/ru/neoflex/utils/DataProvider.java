package ru.neoflex.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.neoflex.model.SendFormData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProvider {
    public static Iterator<Object[]> sendPageTestData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/sendPageData.json"))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<SendFormData> sendFormData = gson.fromJson(json, new TypeToken<List<SendFormData>>() {
            }.getType());
            return sendFormData.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }
}
