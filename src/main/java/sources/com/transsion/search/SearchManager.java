package com.transsion.search;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.NetResponse;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SearchManager {
    public static final a f = new a(null);
    private static final Lazy g = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.search.d
        public final Object invoke() {
            SearchManager e;
            e = SearchManager.e();
            return e;
        }
    });
    private int d;
    private final String b = "kv_search_group";
    private final String c = "kv_search_work";
    private List e = new ArrayList();
    private MMKV a = MMKV.I("kv_search_list");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchManager a() {
            return (SearchManager) SearchManager.g.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchManager e() {
        return new SearchManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SearchManager searchManager) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(searchManager.e);
        a.a.f(wf.a.a, "VS_SM", "add" + arrayList, false, 4, (Object) null);
        int i = searchManager.d;
        if (i != 1) {
            if (i == 2) {
                MMKV mmkv = searchManager.a;
                if (mmkv != null) {
                    mmkv.putString(searchManager.b, o.j(arrayList));
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
        }
        MMKV mmkv2 = searchManager.a;
        if (mmkv2 != null) {
            mmkv2.putString(searchManager.c, o.j(arrayList));
        }
    }

    private final void i(Runnable runnable) {
        h.b.a().d(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SearchManager searchManager) {
        searchManager.e.clear();
        int i = searchManager.d;
        if (i != 1) {
            if (i == 2) {
                MMKV mmkv = searchManager.a;
                if (mmkv != null) {
                    mmkv.putString(searchManager.b, BuildConfig.FLAVOR);
                    return;
                }
                return;
            }
            if (i != 3) {
                return;
            }
        }
        MMKV mmkv2 = searchManager.a;
        if (mmkv2 != null) {
            mmkv2.putString(searchManager.c, BuildConfig.FLAVOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SearchManager searchManager, com.transsion.search.a aVar) {
        aVar.a(searchManager.l());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        if (r0 != 3) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(String str) {
        Intrinsics.h(str, "keyword");
        if (this.e.contains(str)) {
            this.e.remove(str);
            this.e.add(str);
        } else {
            int i = this.d;
            if (i != 1) {
                if (i == 2) {
                    if (this.e.size() >= 30) {
                        this.e.remove(0);
                    }
                }
                this.e.add(str);
            }
            if (this.e.size() >= 30) {
                this.e.remove(0);
            }
            this.e.add(str);
        }
        if (this.e.isEmpty()) {
            return;
        }
        i(new Runnable() { // from class: com.transsion.search.b
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.h(SearchManager.this);
            }
        });
    }

    public final void j() {
        i(new Runnable() { // from class: com.transsion.search.e
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.k(SearchManager.this);
            }
        });
    }

    public final List l() {
        List arrayList;
        String str = null;
        if (this.d == 2) {
            MMKV mmkv = this.a;
            if (mmkv != null) {
                str = mmkv.getString(this.b, BuildConfig.FLAVOR);
            }
        } else {
            MMKV mmkv2 = this.a;
            if (mmkv2 != null) {
                str = mmkv2.getString(this.c, BuildConfig.FLAVOR);
            }
        }
        a.a.f(wf.a.a, "VS_SM", "findSearch" + str, false, 4, (Object) null);
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, NetResponse.EMPTY_RESPONSE)) {
            arrayList = new ArrayList();
        } else {
            Object e = o.e(str, new TypeToken<List<String>>() { // from class: com.transsion.search.SearchManager$findSearch$list$type$1
            }.getType());
            Intrinsics.e(e);
            arrayList = (List) e;
        }
        arrayList.isEmpty();
        this.e = arrayList;
        return arrayList;
    }

    public final void m(int i, final com.transsion.search.a aVar) {
        Intrinsics.h(aVar, "callback");
        this.d = i;
        i(new Runnable() { // from class: com.transsion.search.c
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.n(SearchManager.this, aVar);
            }
        });
    }
}
