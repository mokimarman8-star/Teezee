package com.mbridge.msdk.tracker;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e implements Serializable {
    private String a;
    private JSONObject d;
    private h i;
    private int b = 0;
    private int c = 0;
    private long g = 0;
    private long h = 604800000;
    private boolean j = false;
    private boolean k = false;
    private long f = System.currentTimeMillis();
    private String e = UUID.randomUUID().toString();

    public e(String str) {
        this.a = str;
    }

    public long a() {
        return this.g;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.g = j;
    }

    public void a(h hVar) {
        this.i = hVar;
    }

    void a(String str) {
        this.e = str;
    }

    public void a(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public String b() {
        return this.a;
    }

    public void b(int i) {
        this.b = i;
    }

    void b(long j) {
        this.h = j;
    }

    public int c() {
        return this.c;
    }

    public void c(long j) {
        this.f = j;
    }

    public JSONObject d() {
        JSONObject jSONObject = this.d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.d = jSONObject2;
        return jSONObject2;
    }

    public h e() {
        return this.i;
    }

    public long f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public int h() {
        return this.b;
    }

    public String i() {
        return this.e;
    }

    public boolean j() {
        return this.k;
    }

    public boolean k() {
        return this.j;
    }
}
