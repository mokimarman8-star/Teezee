package com.alibaba.fastjson.asm;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final int f14694a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14695b;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f14698e;

    /* renamed from: d, reason: collision with root package name */
    private final StringBuilder f14697d = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    private int f14696c = 0;

    protected g(int i5, int i6) {
        this.f14695b = i5;
        this.f14694a = i6;
        this.f14698e = i6 == 0;
    }

    protected String a() {
        return this.f14697d.length() != 0 ? this.f14697d.substring(1) : "";
    }

    protected void b(String str, int i5) {
        int i6 = this.f14695b;
        if (i5 < i6 || i5 >= i6 + this.f14694a) {
            return;
        }
        if (!str.equals("arg" + this.f14696c)) {
            this.f14698e = true;
        }
        this.f14697d.append(',');
        this.f14697d.append(str);
        this.f14696c++;
    }
}
