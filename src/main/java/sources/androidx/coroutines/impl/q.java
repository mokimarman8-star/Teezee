package androidx.coroutines.impl;

import j4.m;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Processor f14075a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f14076b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f14077c;

    public /* synthetic */ q(Processor processor, m mVar, boolean z5) {
        this.f14075a = processor;
        this.f14076b = mVar;
        this.f14077c = z5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Processor.e(this.f14075a, this.f14076b, this.f14077c);
    }
}
