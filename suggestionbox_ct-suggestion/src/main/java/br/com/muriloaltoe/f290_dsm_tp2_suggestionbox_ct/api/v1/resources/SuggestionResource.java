package br.com.muriloaltoe.f290_dsm_tp2_suggestionbox_ct.api.v1.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.muriloaltoe.f290_dsm_tp2_suggestionbox_ct.model.entities.Suggestion;
import br.com.muriloaltoe.f290_dsm_tp2_suggestionbox_ct.services.SuggestionService;

@RestController
@RequestMapping("/suggestion")
public class SuggestionResource {

    @Autowired
    private SuggestionService service;

    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody Suggestion suggestion) {
        Suggestion register = service.create(suggestion);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(register.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public List<Suggestion> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Suggestion update(@PathVariable("id") Integer id, @RequestBody Suggestion suggestion) {
        return service.update(id, suggestion);
    }

    @GetMapping("/{id}")
    public Suggestion findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.deleteById(id);
    }
}
