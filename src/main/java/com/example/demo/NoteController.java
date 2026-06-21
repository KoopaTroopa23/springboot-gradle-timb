package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @PostMapping
    public Note create(@RequestParam String content) {
        return noteRepository.save(new Note(content));
    }
}
