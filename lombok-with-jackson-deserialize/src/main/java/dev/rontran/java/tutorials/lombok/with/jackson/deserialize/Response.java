package dev.rontran.java.tutorials.lombok.with.jackson.deserialize;

import lombok.*;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Response {
    String data;
}
