package dev.rontran.java.tutorials.lombok.with.jackson.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    private static final ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private static final ObjectReader reader = new ObjectMapper().reader();

    @Test
    void shouldDeserializeJsonToObjectSuccessfully() {
        var json = "{\"data\":\"Hello, Lombok!\"}";
        var response = assertDoesNotThrow(() -> reader.readValue(json, Response.class));
        assertNotNull(response);
        assertEquals("Hello, Lombok!", response.getData());
    }

    @Test
    void shouldSerializeObjectToJsonSuccessfully() {
        var response = new Response("Hello, Jackson!");
        var json = assertDoesNotThrow(() -> writer.writeValueAsString(response));
        assertEquals(
            """
            {
              "data" : "Hello, Jackson!"
            }
            """.stripTrailing(),
            json);
    }
}