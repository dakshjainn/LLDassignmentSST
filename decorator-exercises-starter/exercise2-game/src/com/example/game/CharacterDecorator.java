package com.example.game;

/**
 * Base decorator class that implements Character and wraps another Character.
 * This provides a foundation for concrete decorators to extend and modify behavior.
 */
public abstract class CharacterDecorator implements Character {
    protected Character wrappedCharacter;

    public CharacterDecorator(Character character) {
        this.wrappedCharacter = character;
    }

    @Override
    public void move() {
        wrappedCharacter.move();
    }

    @Override
    public void attack() {
        wrappedCharacter.attack();
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed();
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage();
    }

    @Override
    public String getSprite() {
        return wrappedCharacter.getSprite();
    }
}
