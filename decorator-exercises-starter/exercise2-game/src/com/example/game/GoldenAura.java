package com.example.game;

/**
 * Concrete decorator that adds a golden aura effect, changing the sprite
 * and providing small buffs to both speed and damage.
 */
public class GoldenAura extends CharacterDecorator {
    private static final int AURA_SPEED_BUFF = 2;
    private static final int AURA_DAMAGE_BUFF = 5;
    private static final String GOLDEN_SPRITE = "golden_aura.png";

    public GoldenAura(Character character) {
        super(character);
    }

    @Override
    public void move() {
        System.out.println("✨ Golden aura shimmers ✨");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite() + " [GOLDEN AURA ACTIVE]");
    }

    @Override
    public void attack() {
        System.out.println("⚡ Golden energy surges ⚡");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " [GOLDEN AURA ACTIVE]");
    }

    @Override
    public int getSpeed() {
        return wrappedCharacter.getSpeed() + AURA_SPEED_BUFF;
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage() + AURA_DAMAGE_BUFF;
    }

    @Override
    public String getSprite() {
        return GOLDEN_SPRITE;
    }
}
