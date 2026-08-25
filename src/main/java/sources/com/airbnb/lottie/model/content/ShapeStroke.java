package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.List;
import o4.t;
import s4.a;
import s4.b;
import s4.d;
import t4.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class ShapeStroke implements c {
    private final String a;
    private final b b;
    private final List c;
    private final a d;
    private final d e;
    private final b f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;
    private final boolean j;

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.a[ordinal()];
            return i != 1 ? i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public ShapeStroke(String str, b bVar, List list, a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.a = str;
        this.b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
        this.j = z;
    }

    public o4.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new t(lottieDrawable, aVar, this);
    }

    public LineCapType b() {
        return this.g;
    }

    public a c() {
        return this.d;
    }

    public b d() {
        return this.b;
    }

    public LineJoinType e() {
        return this.h;
    }

    public List f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public d i() {
        return this.e;
    }

    public b j() {
        return this.f;
    }

    public boolean k() {
        return this.j;
    }
}
