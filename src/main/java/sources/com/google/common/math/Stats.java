package com.google.common.math;

import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    Stats(long j, double d, double d2, double d3, double d4) {
        this.count = j;
        this.mean = d;
        this.sumOfSquaresOfDeltas = d2;
        this.min = d3;
        this.max = d4;
    }

    public static Stats fromByteArray(byte[] bArr) {
        m.o(bArr);
        m.g(bArr.length == BYTES, "Expected Stats.BYTES = %s remaining , got %s", BYTES, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static double meanOf(Iterator<? extends Number> it) {
        m.d(it.hasNext());
        double doubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = it.next().doubleValue();
            j++;
            doubleValue = (Doubles.f(doubleValue2) && Doubles.f(doubleValue)) ? doubleValue + ((doubleValue2 - doubleValue) / j) : h.g(doubleValue, doubleValue2);
        }
        return doubleValue;
    }

    public static double meanOf(double... dArr) {
        m.d(dArr.length > 0);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d2 = dArr[i];
            d = (Doubles.f(d2) && Doubles.f(d)) ? d + ((d2 - d) / (i + 1)) : h.g(d, d2);
        }
        return d;
    }

    public static double meanOf(int... iArr) {
        m.d(iArr.length > 0);
        double d = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d2 = iArr[i];
            d = (Doubles.f(d2) && Doubles.f(d)) ? d + ((d2 - d) / (i + 1)) : h.g(d, d2);
        }
        return d;
    }

    public static double meanOf(long... jArr) {
        m.d(jArr.length > 0);
        double d = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d2 = jArr[i];
            d = (Doubles.f(d2) && Doubles.f(d)) ? d + ((d2 - d) / (i + 1)) : h.g(d, d2);
        }
        return d;
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        h hVar = new h();
        hVar.b(iterable);
        return hVar.h();
    }

    public static Stats of(Iterator<? extends Number> it) {
        h hVar = new h();
        hVar.c(it);
        return hVar.h();
    }

    public static Stats of(double... dArr) {
        h hVar = new h();
        hVar.d(dArr);
        return hVar.h();
    }

    public static Stats of(int... iArr) {
        h hVar = new h();
        hVar.e(iArr);
        return hVar.h();
    }

    public static Stats of(long... jArr) {
        h hVar = new h();
        hVar.f(jArr);
        return hVar.h();
    }

    static Stats readFrom(ByteBuffer byteBuffer) {
        m.o(byteBuffer);
        m.g(byteBuffer.remaining() >= BYTES, "Expected at least Stats.BYTES = %s remaining , got %s", BYTES, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return j.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        m.u(this.count != 0);
        return this.max;
    }

    public double mean() {
        m.u(this.count != 0);
        return this.mean;
    }

    public double min() {
        m.u(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        m.u(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return c.a(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        m.u(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return c.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer order = ByteBuffer.allocate(BYTES).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(order);
        return order.array();
    }

    public String toString() {
        return count() > 0 ? com.google.common.base.h.b(this).c("count", this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString() : com.google.common.base.h.b(this).c("count", this.count).toString();
    }

    void writeTo(ByteBuffer byteBuffer) {
        m.o(byteBuffer);
        m.g(byteBuffer.remaining() >= BYTES, "Expected at least Stats.BYTES = %s remaining , got %s", BYTES, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }
}
