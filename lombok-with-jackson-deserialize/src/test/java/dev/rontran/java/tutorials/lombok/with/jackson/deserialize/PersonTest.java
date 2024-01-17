package dev.rontran.java.tutorials.lombok.with.jackson.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private static final ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
    private static final ObjectReader reader = new ObjectMapper().reader();

    @Test
    void shouldParseJsonToObjectSuccessfully() {
        var json = "{\"firstName\":\"Ron\",\"lastName\":\"Tran\"}";
        var person = assertDoesNotThrow(() -> reader.readValue(json, Person.class));
        assertNotNull(person);
        assertEquals("Ron", person.getFirstName());
        assertEquals("Tran", person.getLastName());
    }

    @Test
    void shouldParseObjectToJsonSuccessfully() {
        var person = Person.builder().firstName("Ron").lastName("Tran").build();
        var json = assertDoesNotThrow(() -> writer.writeValueAsString(person));
        assertEquals(
                """
                {
                  "firstName" : "Ron",
                  "lastName" : "Tran"
                }
                """.stripTrailing(),
                json);
    }
}