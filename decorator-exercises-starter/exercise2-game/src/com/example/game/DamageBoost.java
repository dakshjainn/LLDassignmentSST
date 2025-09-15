package com.example.game;

/**
 * Concrete decorator that boosts the character's damage.
 */
public class DamageBoost extends CharacterDecorator {
    private final int damageIncrease;

    public DamageBoost(Character character, int damageIncrease) {
        super(character);
        this.damageIncrease = damageIncrease;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " [DAMAGE BOOSTED!]");
    }

    @Override
    public int getDamage() {
        return wrappedCharacter.getDamage() + damageIncrease;
    }
}
