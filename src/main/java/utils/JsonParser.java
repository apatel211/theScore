package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class JsonParser {

    public static JSONObject getJsonData() throws IOException, ParseException, org.json.simple.parser.ParseException {
        File filename = new File("src//main//resources//testData.json");
        String json= FileUtils.readFileToString(filename , "UTF-8");
        Object obj = new JSONParser().parse(json);
        JSONObject jsonObject = (JSONObject) obj;
        return  jsonObject;
    }

    public static String getTestData(String key) throws IOException, ParseException, org.json.simple.parser.ParseException {
        String testDataValue;
        return  testDataValue = (String) getJsonData().get(key);
    }
}

