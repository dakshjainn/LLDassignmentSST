package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        // === DECORATOR IMPLEMENTATIONS ===
        
        System.out.println("\n--- Base + SpeedBoost ---");
        Character speedBoosted = new SpeedBoost(base, 3);
        speedBoosted.move();
        speedBoosted.attack();
        
        System.out.println("\n--- Base + SpeedBoost + DamageBoost ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        buffed.move();
        buffed.attack();
        System.out.println("Stats: Speed=" + buffed.getSpeed() + ", Damage=" + buffed.getDamage() + ", Sprite=" + buffed.getSprite());
        
        System.out.println("\n--- Add GoldenAura (Base + SpeedBoost + DamageBoost + GoldenAura) ---");
        Character shiny = new GoldenAura(buffed);
        shiny.move();
        shiny.attack();
        System.out.println("Stats: Speed=" + shiny.getSpeed() + ", Damage=" + shiny.getDamage() + ", Sprite=" + shiny.getSprite());
        
        System.out.println("\n--- Remove GoldenAura by recomposition (back to SpeedBoost + DamageBoost) ---");
        Character withoutAura = new DamageBoost(new SpeedBoost(base, 3), 15); // rebuilt without GoldenAura
        withoutAura.move();
        withoutAura.attack();
        System.out.println("Stats: Speed=" + withoutAura.getSpeed() + ", Damage=" + withoutAura.getDamage() + ", Sprite=" + withoutAura.getSprite());
        
        System.out.println("\n--- Multiple GoldenAura stacking ---");
        Character doubleGolden = new GoldenAura(new GoldenAura(base));
        doubleGolden.move();
        doubleGolden.attack();
        System.out.println("Stats: Speed=" + doubleGolden.getSpeed() + ", Damage=" + doubleGolden.getDamage() + ", Sprite=" + doubleGolden.getSprite());
        
    }
}
