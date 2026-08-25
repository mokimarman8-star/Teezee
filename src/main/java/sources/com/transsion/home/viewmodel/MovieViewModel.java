package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.b;
import androidx.lifecycle.b0;
import androidx.lifecycle.u0;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;
import yk.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class MovieViewModel extends b {
    public static final a f = new a((DefaultConstructorMarker) null);
    public static final int g = 8;
    private final Lazy b;
    private final Lazy c;
    private final Lazy d;
    private final c e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.j
            public final Object invoke() {
                b0 g2;
                g2 = MovieViewModel.g();
                return g2;
            }
        });
        this.c = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.k
            public final Object invoke() {
                b0 o;
                o = MovieViewModel.o();
                return o;
            }
        });
        this.d = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.l
            public final Object invoke() {
                b0 p;
                p = MovieViewModel.p();
                return p;
            }
        });
        this.e = (c) kg.c.e.a().h(c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 g() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 o() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 p() {
        return new b0();
    }

    public final void h(Integer num, String str) {
        Intrinsics.h(str, "version");
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new getFilterItems.1(this, num, str, (Continuation) null), 2, (Object) null);
    }

    public final LiveData i() {
        return j();
    }

    public final b0 j() {
        return (b0) this.b.getValue();
    }

    public final void k(int i, int i2, String str, Map map, boolean z) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", Integer.valueOf(i));
        jsonObject.addProperty("perPage", Integer.valueOf(i2));
        jsonObject.addProperty("channelId", str);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                if (StringsKt.c0((CharSequence) entry.getValue(), ",", false, 2, (Object) null)) {
                    JsonArray jsonArray = new JsonArray();
                    Iterator it = StringsKt.S0((CharSequence) entry.getValue(), new String[]{","}, false, 0, 6, (Object) null).iterator();
                    while (it.hasNext()) {
                        jsonArray.add((String) it.next());
                    }
                    jsonObject.add((String) entry.getKey(), jsonArray);
                } else {
                    jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        i.d(u0.a(this), y0.b(), (CoroutineStart) null, new getMovieList.2(jsonObject, this, z, str, map, (Continuation) null), 2, (Object) null);
    }

    public final LiveData l() {
        return m();
    }

    public final b0 m() {
        return (b0) this.c.getValue();
    }

    public final b0 n() {
        return (b0) this.d.getValue();
    }
}
