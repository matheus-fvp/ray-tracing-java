package org.example.geometry;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sphere {

    private Vec3 center;
    private BigDecimal radius;

    public Sphere(Vec3 center, BigDecimal radius) {
        this.center = center;
        this.radius = radius;
    }

    public Vec3 getCenter() {
        return center;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public BigDecimal hit(Ray ray) {
        Vec3 oc = ray.getOrigin().subtraction(center);
        BigDecimal a = ray.getDirection().lengthSquared();
        BigDecimal halfB = oc.dot(ray.getDirection());
        BigDecimal c = oc.lengthSquared().subtract(radius.pow(2));
        BigDecimal discriminant = halfB.pow(2).subtract(a.multiply(c));

        if(discriminant.compareTo(BigDecimal.ZERO) < 0) return BigDecimal.valueOf(-1.0);
        return  (halfB.multiply(BigDecimal.valueOf(-1.0)).subtract(BigDecimal.valueOf(Math.sqrt(discriminant.doubleValue()))))
                .divide(a, 17, RoundingMode.HALF_DOWN);
    }

    public Vec3 normal(Vec3 point) {
        return point.subtraction(this.center).unitVector();
    }

}
