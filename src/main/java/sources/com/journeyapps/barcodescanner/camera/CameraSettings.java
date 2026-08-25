package com.journeyapps.barcodescanner.camera;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class CameraSettings {
    private int a = -1;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private FocusMode i = FocusMode.AUTO;

    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public FocusMode a() {
        return this.i;
    }

    public int b() {
        return this.a;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.c;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.d;
    }

    public boolean h() {
        return this.b;
    }

    public void i(int i) {
        this.a = i;
    }
}
