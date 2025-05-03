package com.Ca227_12201340.Ca227_12201340;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class ResponseController {

    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity
                .ok()
                .header("X-Custom-Header", "MyValue")
                .body("Successfully");
    }

    @GetMapping("/not-found")
    public ResponseEntity<Map<String, String>> notFound() {
        Map<String, String> error = Map.of("error", "Resource not found");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createResource() {
        // In a real app, you'd save something and get its new ID.
        URI location = URI.create("/resource/123");
        return ResponseEntity
                .created(location)
                .body("Resource created with ID 123");
    }


}
