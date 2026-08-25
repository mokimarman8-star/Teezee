package androidx.media3.common.util;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private String[] f9116a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f9117b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9118c;

    public q(String... strArr) {
        this.f9116a = strArr;
    }

    public synchronized boolean a() {
        if (this.f9117b) {
            return this.f9118c;
        }
        this.f9117b = true;
        try {
            for (String str : this.f9116a) {
                b(str);
            }
            this.f9118c = true;
        } catch (UnsatisfiedLinkError unused) {
            u.h("LibraryLoader", "Failed to load " + Arrays.toString(this.f9116a));
        }
        return this.f9118c;
    }

    protected abstract void b(String str);
}
