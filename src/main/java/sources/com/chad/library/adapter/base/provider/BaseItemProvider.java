package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import u6.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class BaseItemProvider {
    public Context a;
    private WeakReference b;
    private final Lazy c;
    private final Lazy d;

    public BaseItemProvider() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.c = LazyKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$clickViewIds$2
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.d = LazyKt.a(lazyThreadSafetyMode, new Function0<ArrayList<Integer>>() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$longClickViewIds$2
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
    }

    private final ArrayList j() {
        return (ArrayList) this.c.getValue();
    }

    private final ArrayList n() {
        return (ArrayList) this.d.getValue();
    }

    public abstract void b(BaseViewHolder baseViewHolder, Object obj);

    public void f(BaseViewHolder baseViewHolder, Object obj, List list) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(list, "payloads");
    }

    public BaseProviderMultiAdapter g() {
        WeakReference weakReference = this.b;
        if (weakReference != null) {
            return (BaseProviderMultiAdapter) weakReference.get();
        }
        return null;
    }

    public final ArrayList h() {
        return j();
    }

    public final ArrayList i() {
        return n();
    }

    public final Context k() {
        Context context = this.a;
        if (context != null) {
            return context;
        }
        Intrinsics.y("context");
        return null;
    }

    public abstract int l();

    public abstract int m();

    public void o(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(view, "view");
    }

    public boolean p(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(view, "view");
        return false;
    }

    public void q(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(view, "view");
    }

    public BaseViewHolder r(ViewGroup viewGroup, int i) {
        Intrinsics.h(viewGroup, "parent");
        return new BaseViewHolder(a.a(viewGroup, m()));
    }

    public boolean s(BaseViewHolder baseViewHolder, View view, Object obj, int i) {
        Intrinsics.h(baseViewHolder, "helper");
        Intrinsics.h(view, "view");
        return false;
    }

    public void t(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
    }

    public void u(BaseViewHolder baseViewHolder) {
        Intrinsics.h(baseViewHolder, "holder");
    }

    public void v(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.h(baseViewHolder, "viewHolder");
    }

    public final void w(BaseProviderMultiAdapter baseProviderMultiAdapter) {
        Intrinsics.h(baseProviderMultiAdapter, "adapter");
        this.b = new WeakReference(baseProviderMultiAdapter);
    }

    public final void x(Context context) {
        Intrinsics.h(context, "<set-?>");
        this.a = context;
    }
}
