package androidx.coroutines.impl;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final /* synthetic */ class p implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Processor f14072a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f14073b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f14074c;

    public /* synthetic */ p(Processor processor, ArrayList arrayList, String str) {
        this.f14072a = processor;
        this.f14073b = arrayList;
        this.f14074c = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return Processor.f(this.f14072a, this.f14073b, this.f14074c);
    }
}
