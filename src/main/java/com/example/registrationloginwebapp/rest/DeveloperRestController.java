package com.example.registrationloginwebapp.rest;

import com.example.registrationloginwebapp.models.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api")
public class DeveloperRestController {

    private List<Developer> developers = Stream.of(
            new Developer(1L, "Ivan", "Ivanov"),
            new Developer(2L, "Sergey", "Sergeev"),
            new Developer(3L, "Petr", "Petrov")
    ).collect(Collectors.toList());

    @GetMapping("/developers")
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return developers.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id) {
        developers.removeIf(developer -> developer.getId().equals(id));
    }
}
