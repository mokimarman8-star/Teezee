package com.bykv.vk.openvk.preload.geckox.a.a;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.List;

@SuppressLint({"CI_StaticFieldLeak"})
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class b {
    public static final b a = new d();
    public static final b b;
    protected a c;
    protected File d;
    protected List<String> e;

    static {
        new f();
        b = new e();
    }

    public abstract void a();

    public void a(a aVar, File file, List<String> list) {
        this.c = aVar;
        this.d = file;
        this.e = list;
    }
}
