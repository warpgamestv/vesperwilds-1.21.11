package com.warpgames.vesperwilds.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;

public class VelvetFallingLeafParticle extends FallingLeavesParticle {

    // Custom variables for our own physics
    private float rotationSpeed;
    private final float spinAcceleration;

    protected VelvetFallingLeafParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        // Pass standard values to super, but we will override the behavior in tick() anyway
        super(level, x, y, z, spriteSet.get(level.random), 0.12F, 2.0F, false, true, 1.0F, 0.0F);

        this.lifetime = 600; // 30 Seconds max life
        this.gravity = 0.04F; // Low gravity for floaty effect
        this.friction = 0.98F; // Slight air resistance

        // Initialize custom spin
        this.rotationSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -3.0 : 3.0);
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -0.2 : 0.2);
    }

    @Override
    public void tick() {
        // 1. Handle Lifetime
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
            return;
        }

        if (this.removed) return;

        // 2. Add Gravity
        this.yd -= this.gravity;

        // 3. Add Wind / Drift (Simulated)
        // This adds a gentle random push every tick so it never stops moving
        this.xd += (this.random.nextFloat() - 0.5F) * 0.01F;
        this.zd += (this.random.nextFloat() - 0.5F) * 0.01F;

        // 4. Handle Spinning
        this.oRoll = this.roll;
        this.roll += this.rotationSpeed;
        this.rotationSpeed += this.spinAcceleration;
        // Dampen the spin so it doesn't get crazy fast
        this.rotationSpeed *= 0.98F;

        // 5. Move!
        this.move(this.xd, this.yd, this.zd);

        // 6. Kill ONLY if on the ground
        if (this.onGround) {
            this.remove();
        }

        // 7. Apply Friction (Slow down air movement)
        this.xd *= this.friction;
        this.yd *= this.friction;
        this.zd *= this.friction;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, RandomSource random) {
            return new VelvetFallingLeafParticle(level, x, y, z, this.spriteSet);
        }
    }
}