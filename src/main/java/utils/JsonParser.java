package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class JsonParser {

    public static JSONObject getJsonData() throws IOException, ParseException {
        File file = new File("src/main/resources/testData.json");
        try {
            String json = FileUtils.readFileToString(file, "UTF-8");
            return (JSONObject) new JSONParser().parse(json);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String getTestData(String key) throws IOException, ParseException {
        return (String) getJsonData().get(key);
    }
}

