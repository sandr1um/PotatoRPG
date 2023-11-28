package com.example.potatorpg.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class GameModelAssembler implements RepresentationModelAssembler<EventEntity, EntityModel<EventEntity>> {
    @Override
    public EntityModel<EventEntity> toModel(EventEntity entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(GameController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(GameController.class).all()).withRel("events"));
    }
}
