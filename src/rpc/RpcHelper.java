package rpc;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class RpcHelper {
    // Writes a JSONArray to http response.
    public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws IOException{
        response.setContentType("application/json");
        response.getWriter().print(array);
    }

    // Writes a JSONObject to http response.
    public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws IOException {
        response.setContentType("application/json");
        response.getWriter().print(obj);
    }

    public static JSONObject readJSONObject(HttpServletRequest request) {
        StringBuilder sBuilder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while((line = reader.readLine()) != null) {
                sBuilder.append(line);
            }
            return new JSONObject(sBuilder.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new JSONObject();
    }



}
