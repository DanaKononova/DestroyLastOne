import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.beans.Transient;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ProxySerialization {
    public void serializeField(String filename, Object obj) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(obj.getClass().getName());
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (!Modifier.isTransient(field.getModifiers())) {
                    field.setAccessible(true);
                    Object value = field.get(obj);
                    System.out.println(field.getName() + " = " + value);
                    writer.println(field.getName() + ":" + value);
                }
            }
            for (Field field : obj.getClass().getSuperclass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(obj);
                System.out.println(field.getName() + " = " + value);
                writer.println(field.getName() + ":" + value);
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void deserializeFields(String filename, ArrayList<GameFigure> figures, Game game) {
        figures.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while (true) {
                String className = reader.readLine();
                if (className == null) break;
                Class<?> clazz = Class.forName(className);
                if (!className.equals("Settings") && !className.equals(("StatusBar"))) {
                    GameFigure figure = (GameFigure) clazz.newInstance();
                    Field[] fields = figure.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (!Modifier.isTransient(field.getModifiers())) {
                            String value = reader.readLine().split(":")[1];
                            Class<?> fieldType = field.getType();
                            Object convertedValue = null;

                            if (fieldType == int.class || fieldType == Integer.class) {
                                convertedValue = Integer.parseInt(value);
                            } else if (fieldType == double.class || fieldType == Double.class) {
                                convertedValue = Double.parseDouble(value);
                            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                                convertedValue = Boolean.parseBoolean(value);
                            }
                            field.setAccessible(true);
                            field.set(figure, convertedValue);
                        }
                    }
                    fields = figure.getClass().getSuperclass().getDeclaredFields();
                    for (Field field : fields) {
                        String value = reader.readLine().split(":")[1];
                        Class<?> fieldType = field.getType();
                        Object convertedValue = null;

                        if (fieldType == int.class || fieldType == Integer.class) {
                            convertedValue = Integer.parseInt(value);
                        } else if (fieldType == double.class || fieldType == Double.class) {
                            convertedValue = Double.parseDouble(value);
                        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                            convertedValue = Boolean.parseBoolean(value);
                        }
                        field.setAccessible(true);
                        field.set(figure, convertedValue);
                    }
                    figures.add(figure);
                } else if(!className.equals("StatusBar")){
                    Settings figure = (Settings) clazz.newInstance();
                    Field[] fields = figure.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (!Modifier.isTransient(field.getModifiers())) {
                            String value = reader.readLine().split(":")[1];
                            Class<?> fieldType = field.getType();
                            Object convertedValue = null;

                            if (fieldType == int.class || fieldType == Integer.class) {
                                convertedValue = Integer.parseInt(value);
                            } else if (fieldType == double.class || fieldType == Double.class) {
                                convertedValue = Double.parseDouble(value);
                            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                                convertedValue = Boolean.parseBoolean(value);
                            }
                            field.setAccessible(true);
                            field.set(figure, convertedValue);
                        }
                    }
                    game.setSettings(figure);
                } else {
                    StatusBar figure = (StatusBar) clazz.newInstance();
                    Field[] fields = figure.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (!Modifier.isTransient(field.getModifiers())) {
                            String value = reader.readLine().split(":")[1];
                            Class<?> fieldType = field.getType();
                            Object convertedValue = null;

                            if (fieldType == int.class || fieldType == Integer.class) {
                                convertedValue = Integer.parseInt(value);
                            } else if (fieldType == double.class || fieldType == Double.class) {
                                convertedValue = Double.parseDouble(value);
                            } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                                convertedValue = Boolean.parseBoolean(value);
                            } else if (fieldType == String.class) {
                                convertedValue = value;
                            }
                            field.setAccessible(true);
                            field.set(figure, convertedValue);
                        }
                    }
                    game.setStatusBar(figure);
                }

            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void serializeToJsonFile(String filename, ArrayList<GameFigure> figures, Settings settings, StatusBar statusBar) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        ObjectNode settingsNode = mapper.valueToTree(settings);
        root.set("settings", settingsNode);

        ObjectNode statusBarNode = mapper.valueToTree(statusBar);
        root.set("statusBar", statusBarNode);

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

    public void deserializeFromJsonFile(String filename, ArrayList<GameFigure> figures, Settings settings, StatusBar statusBar) {
        figures.clear();
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filename));
            JsonNode settingsNode = rootNode.get("settings");
            settings.setScreen(settingsNode.get("screen").asText());
            settings.setVolume(settingsNode.get("volume").asInt());
            settings.setBrightness(settingsNode.get("brightness").asInt());
            settings.setDifficulty(settingsNode.get("difficulty").asInt());

            JsonNode statusBarNode = rootNode.get("statusBar");
            statusBar.setName(statusBarNode.get("name").asText());
            statusBar.setSurname(statusBarNode.get("surname").asText());
            statusBar.setProgressBar(statusBarNode.get("progressBar").asText());
            statusBar.setTime(statusBarNode.get("time").asText());
            statusBar.setDestroyed(statusBarNode.get("destroyed").asText());

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
