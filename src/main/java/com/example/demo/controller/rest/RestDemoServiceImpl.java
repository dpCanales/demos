package com.example.demo.controller.rest;

import com.example.demo.bean.Formato;
import com.example.demo.config.DespliegueConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestDemoServiceImpl implements RestDemoService {

    @Autowired
    DespliegueConfig config;

    @Override
    public ObjectNode find() {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.instance);
        try {
            ArrayNode node = new ArrayNode(JsonNodeFactory.instance);
            ObjectMapper mapper = new ObjectMapper();

            JSONArray json = readJsonFromUrl(config.getUrl());
            for (int i = 0; i < json.length(); i++) {
                Formato formato = (Formato) mapper.readValue(json.getJSONObject(i).toString(), Formato.class);
                String dato = formato.getUserId().toString()
                        .concat("-" + formato.getId().toString())
                        .concat("-" + formato.getTitle())
                        .concat("-" + formato.getBody());
                node.add(dato);
            }

            objectNode.set("data", node);

        } catch (IOException | JSONException ex) {
            Logger.getLogger("Error en la reestructuraciónF").log(Level.SEVERE, null, ex);
        }
        return objectNode;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
            Logger.getLogger("Error en la ruta");
        }
    }
}
