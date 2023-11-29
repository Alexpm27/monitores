package com.example.terminal.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.FollowComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.example.terminal.factory.types.Type;

public class Factory implements EntityFactory {

    @Spawns("Person")
    public Entity newPlayer(SpawnData data) {
        FollowComponent followComponent = new FollowComponent();
        followComponent.setSpeed(1);
        return FXGL.entityBuilder(data)
                .type(Type.PERSON)
                .view("person.png")
                .with(followComponent)
                .buildAndAttach();
    }

    @Spawns("Boletos")
    public Entity newTickets(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);
        return FXGL.entityBuilder(data)
                .type(Type.TICKETS)
                .view("vendedor.png")
                .with(physics)
                .build();
    }

    @Spawns("Bus")
    public Entity newPolice(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);
        return FXGL.entityBuilder(data)
                .view("bus.png")
                .type(Type.DRIVER)
                .with(physics)
                .build();
    }

    @Spawns("Target")
    public Entity newTarget(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(Type.TARGET)
                .at(100, 80)
                .buildAndAttach();
    }
}
