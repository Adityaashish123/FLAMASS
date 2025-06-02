package com.example.particlesystem;

public class Particle {
    public float x, y;
    public float velocityX, velocityY;
    public float lifetime;
    public float red, green, blue, alpha;

    public Particle(float x, float y) {
        this.x = x;
        this.y = y;

        float angle = (float) (Math.random() * 2 * Math.PI);
        float speed = (float) (Math.random() * 0.02f + 0.01f);
        velocityX = (float) Math.cos(angle) * speed;
        velocityY = (float) Math.sin(angle) * speed;

        red = (float) Math.random();
        green = (float) Math.random();
        blue = (float) Math.random();
        alpha = 1.0f;

        lifetime = 1.0f;
    }

    public void update() {
        x += velocityX;
        y += velocityY;
        velocityY -= 0.001f;
        lifetime -= 0.01f;
        alpha = lifetime;
    }

    public boolean isAlive() {
        return lifetime > 0;
    }
}