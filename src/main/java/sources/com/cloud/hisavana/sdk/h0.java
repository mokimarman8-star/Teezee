package com.cloud.hisavana.sdk;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class h0 {
    protected Bundle a = new Bundle();
    protected int b = 0;
    protected int c = 0;

    protected void a() {
        this.a.putInt("s_material_cache", 2);
    }

    protected void b(int i) {
        if (i == 250) {
            this.c = 2;
        } else {
            this.c = 1;
        }
    }

    protected void c(boolean z) {
        if (z) {
            this.a.putInt("s_material_cache", 1);
        } else {
            this.a.putInt("s_material_cache", 2);
        }
    }

    protected void d() {
        if (this.c == 1 || this.b == 1) {
            this.a.putInt("s_material_cache", 1);
        } else {
            this.a.putInt("s_material_cache", 2);
        }
    }

    protected void e(int i) {
        if (i == 250) {
            this.a.putInt("s_material_cache", 2);
        } else {
            this.a.putInt("s_material_cache", 1);
        }
    }

    protected void f(int i) {
        if (i == 250) {
            this.b = 2;
        } else {
            this.b = 1;
        }
    }
}
