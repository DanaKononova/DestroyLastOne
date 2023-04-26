import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.ArrayList;

public class ProxySerialization {
    public void serializeToTextFile(String filename, ArrayList<GameFigure> figures, Settings settings) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (GameFigure figure : figures) {
            figure.serializeToTextFile(filename);
        }
        settings.serializeToTextFile(filename);
    }

    public void deserializeFromTextFile(String filename, ArrayList<GameFigure> figures, Settings settings) {
        figures.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (true) {
                String className = reader.readLine();
                if (className == null) break;
                if (className.equals("Settings")) {
                    settings.deserializeFromTextFile(reader.readLine());
                } else {
                    Class<?> clazz = Class.forName(className);
                    GameFigure date = (GameFigure) clazz.newInstance();
                    date.deserializeFromTextFile(reader.readLine());
                    figures.add(date);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void serializeToJsonFile(String filename, ArrayList<GameFigure> figures, Settings settings) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        ObjectNode settingsNode = mapper.valueToTree(settings);
        root.set("settings", settingsNode);

        ArrayNode objectsNode = root.putArray("objects");
        for (GameFigure figure : figures) {
            ObjectNode objectNode = mapper.valueToTree(figure);
            objectNode.put("type", figure.getClass().getName());
            objectsNode.add(objectNode);
        }
        try {
            File file = new File(filename);
            mapper.writeValue(file, root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeFromJsonFile(String filename, ArrayList<GameFigure> figures, Settings settings) {
        figures.clear();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filename));
            JsonNode settingsNode = rootNode.get("settings");
            settings.setVolume(settingsNode.get("volume").asInt());
            settings.setBrightness(settingsNode.get("brightness").asInt());
            settings.setDifficulty(settingsNode.get("difficulty").asInt());
            JsonNode objectsNode = rootNode.get("objects");
            for (JsonNode objectNode : objectsNode) {
                String className = objectNode.get("type").asText();
                Class<?> clazz = Class.forName(className);
                GameFigure object = (GameFigure) mapper.readValue(objectNode.toString(), clazz);
                figures.add(object);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
