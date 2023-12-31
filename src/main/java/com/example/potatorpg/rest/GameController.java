package com.example.potatorpg.rest;

import com.example.potatorpg.app.Dice;
import com.example.potatorpg.app.GameState;
import com.example.potatorpg.app.events.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@SpringBootApplication
@RestController
@RequestMapping("/game")
public class GameController {
    private final GameState state = new GameState();
    private final EventFactory eventFactory = new EventFactory(new Dice());
    private final GameRepository repository;
    private final GameModelAssembler assembler;

    public GameController(GameRepository repository, GameModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/events")
    CollectionModel<EntityModel<EventEntity>> all() {

        List<EntityModel<EventEntity>> events = repository.findAll().stream() //
                .map(assembler::toModel) //
                .toList();

        return CollectionModel.of(events, linkTo(methodOn(GameController.class).all()).withSelfRel());
    }

    @GetMapping("{id}")
    EntityModel<EventEntity> one(@PathVariable Long id) {

        EventEntity game = repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        return assembler.toModel(game);
    }

    @PostMapping("/apply")
    public ResponseEntity<EntityModel<EventEntity>> applyEvent() {
        Event nextEvent = eventFactory.createEvent();

        EventEntity entity = state.applyEvent(nextEvent);

        if (state.isFinished()) {
            entity.setMessage(state.generateFinalMessage());
        }

        EntityModel<EventEntity> entityModel = assembler.toModel(repository.save(entity));

        return ResponseEntity.ok(entityModel);
    }

    @PostMapping("/removeOrc")
    public ResponseEntity<EntityModel<EventEntity>> removeOrc() {

        EventEntity entity = state.applyEvent(new HurlingEvent(state.getScaling()));

        if (state.isFinished()) {
            entity.setMessage(state.generateFinalMessage());
        }

        EntityModel<EventEntity> entityModel = assembler.toModel(repository.save(entity));

        return ResponseEntity.ok(entityModel);
    }

    @PutMapping("/newGame")
    public ResponseEntity<EntityModel<EventEntity>> newGame() {
        EventEntity entity = state.startNewGame();

        EntityModel<EventEntity> entityModel = assembler.toModel(repository.save(entity));

        return ResponseEntity.ok(entityModel);
    }

}

