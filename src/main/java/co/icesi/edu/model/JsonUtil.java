package co.icesi.edu.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T deserializeFromJson(String json, TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(json, typeReference);
    }

    public static String serializeToJson(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    public static void writeValue(OutputStream outputStream, Object object) throws IOException {
        objectMapper.writeValue(outputStream, object);
    }

    public static <T> T readValue(InputStream inputStream, Class<T> clazz) throws IOException {
        return objectMapper.readValue(inputStream, clazz);
    }

}
