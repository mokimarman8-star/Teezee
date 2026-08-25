package com.chad.library.adapter.base.binder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.e;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class BaseItemBinder {
    private final Lazy a;
    private final Lazy b;
    private e c;
    private Context d;

    public BaseItemBinder() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.a = LazyKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.binder.BaseItemBinder$clickViewIds$2
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.b = LazyKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.binder.BaseItemBinder$longClickViewIds$2
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
    }

    private final ArrayList e() {
        return (ArrayList) this.a.getValue();
    }

    private final ArrayList f() {
        return (ArrayList) this.b.getValue();
    }

    public abstract void a(BaseViewHolder baseViewHolder, Object obj);

    public void b(BaseViewHolder baseViewHolder, Object obj, List list) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(list, "payloads");
    }

    public final ArrayList c() {
        return e();
    }

    public final ArrayList d() {
        return f();
    }

    public void g(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(view, "view");
    }

    public boolean h(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(view, "view");
        return false;
    }

    public void i(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(view, "view");
    }

    public abstract BaseViewHolder j(ViewGroup viewGroup, int i);

    public boolean k(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
        return false;
    }

    public boolean l(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "holder");
        Intrinsics.h(view, "view");
        return false;
    }

    public void m(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
    }

    public void n(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
    }

    public final void o(e eVar) {
        this.c = eVar;
    }

    public final void p(Context context) {
        this.d = context;
    }
}
