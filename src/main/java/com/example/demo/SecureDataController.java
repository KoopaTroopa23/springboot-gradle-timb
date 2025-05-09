package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecureDataController {

    private static final String VALID_USERNAME = "kw";
    private static final String VALID_PASSWORD = "bigT";

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            return ResponseEntity.ok("✅ Access granted. Welcome, kw! Secure data will be shown here.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("❌ Invalid credentials.");
        }
    }

    // Example protected resource
    @GetMapping("/profile")
    public ResponseEntity<String> profile() {
        return ResponseEntity.ok("🔒 This is your protected profile. You can add secure JSON here later.");
    }

    // Public welcome
    @GetMapping("/")
    public String welcome() {
        return "Hello, welcome to the secure API.";
    }
}
