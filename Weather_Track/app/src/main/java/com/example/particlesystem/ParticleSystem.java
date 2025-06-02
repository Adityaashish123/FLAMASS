package com.example.particlesystem;

import android.opengl.GLES20;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticleSystem {
    private final List<Particle> particles = new ArrayList<>();
    private FloatBuffer vertexBuffer;

    public ParticleSystem() {
        for (int i = 0; i < 300; i++) {
            particles.add(new Particle(0, 0));
        }

        ByteBuffer bb = ByteBuffer.allocateDirect(2 * 4);
        bb.order(ByteOrder.nativeOrder());
        vertexBuffer = bb.asFloatBuffer();
    }

    public void update() {
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.update();
            if (!p.isAlive()) {
                it.remove();
                particles.add(new Particle(0, 0));
            }
        }
    }

    public void draw(float[] projectionMatrix) {
        for (Particle p : particles) {
            float[] coords = {p.x, p.y};
            vertexBuffer.put(coords);
            vertexBuffer.position(0);

            GLES20.glEnableVertexAttribArray(0);
            GLES20.glVertexAttribPointer(0, 2, GLES20.GL_FLOAT, false, 0, vertexBuffer);
            GLES20.glUniform4f(1, p.red, p.green, p.blue, p.alpha);
            GLES20.glDrawArrays(GLES20.GL_POINTS, 0, 1);
        }
    }
}