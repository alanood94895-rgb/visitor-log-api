package com.example.visitorlog;

import com.example.visitorlog.model.Visitor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")

public class VisitorController {

    private final List<Visitor> visitors = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    // GET /api/visitors
    @GetMapping("/visitors")
    public List<Visitor> getAllVisitors() {
        return visitors;
    }

    // GET /api/visitors/{id}
    @GetMapping("/visitors/{id}")
    public Visitor getVisitorById(@PathVariable Long id) {

        return visitors.stream()
                .filter(visitor -> visitor.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Visitor not found"));
    }

    // POST /api/visitors
    @PostMapping("/visitors")
    @ResponseStatus(HttpStatus.CREATED)
    public Visitor addVisitor(@RequestBody Visitor visitor) {

        visitor.setId(counter.incrementAndGet());
        visitors.add(visitor);

        return visitor;
    }

    // DELETE /api/visitors/{id}
    @DeleteMapping("/visitors/{id}")
    public void deleteVisitor(@PathVariable Long id) {

        Visitor visitor = visitors.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Visitor not found"));

        visitors.remove(visitor);
    }

    // GET /api/visitors/count
    @GetMapping("/visitors/count")
    public Map<String, Integer> getVisitorCount() {

        Map<String, Integer> response = new HashMap<>();
        response.put("total", visitors.size());

        return response;
    }

    // GET /api/health
    @GetMapping("/health")
    public Map<String, String> health() {

        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("developer", "Your Name");

        return response;
    }

}

