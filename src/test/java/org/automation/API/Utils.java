package org.automation.API;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utils {

    public JSONObject readPayloadFromJson(String payloadJson) {
        try {
            File file = new File(System.getProperty("user.dir") + "/TestData/" + payloadJson);
            String payloadTxt = FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));
            return new JSONObject(payloadTxt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
