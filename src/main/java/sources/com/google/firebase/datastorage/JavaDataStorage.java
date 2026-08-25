package com.google.firebase.datastorage;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.g;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.c;
import androidx.datastore.preferences.core.d;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class JavaDataStorage {
    static final /* synthetic */ KProperty[] f = {Reflection.j(new PropertyReference2Impl(JavaDataStorage.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};
    private final Context a;
    private final String b;
    private final ThreadLocal c;
    private final ReadOnlyProperty d;
    private final g e;

    public JavaDataStorage(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, RewardPlus.NAME);
        this.a = context;
        this.b = str;
        this.c = new ThreadLocal();
        this.d = PreferenceDataStoreDelegateKt.b(str, new j1.b(new Function1() { // from class: com.google.firebase.datastorage.a
            public final Object invoke(Object obj) {
                androidx.datastore.preferences.core.c e;
                e = JavaDataStorage.e(JavaDataStorage.this, (CorruptionException) obj);
                return e;
            }
        }), new Function1() { // from class: com.google.firebase.datastorage.b
            public final Object invoke(Object obj) {
                List f2;
                f2 = JavaDataStorage.f(JavaDataStorage.this, (Context) obj);
                return f2;
            }
        }, (n0) null, 8, (Object) null);
        this.e = i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.datastore.preferences.core.c e(JavaDataStorage javaDataStorage, CorruptionException corruptionException) {
        Intrinsics.h(corruptionException, "ex");
        Log.w(Reflection.b(JavaDataStorage.class).g(), "CorruptionException in " + javaDataStorage.b + " DataStore running in process " + Process.myPid(), corruptionException);
        return d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(JavaDataStorage javaDataStorage, Context context) {
        Intrinsics.h(context, "it");
        return CollectionsKt.e(SharedPreferencesMigrationKt.b(context, javaDataStorage.b, (Set) null, 4, (Object) null));
    }

    private final g i(Context context) {
        return (g) this.d.a(context, f[0]);
    }

    public final androidx.datastore.preferences.core.c g(Function1 function1) {
        Intrinsics.h(function1, "transform");
        return (androidx.datastore.preferences.core.c) i.f((CoroutineContext) null, new JavaDataStorage$editSync$1(this, function1, null), 1, (Object) null);
    }

    public final Map h() {
        return (Map) i.f((CoroutineContext) null, new JavaDataStorage$getAllSync$1(this, null), 1, (Object) null);
    }

    public final Object j(c.a aVar, Object obj) {
        Intrinsics.h(aVar, "key");
        return i.f((CoroutineContext) null, new JavaDataStorage$getSync$1(this, aVar, obj, null), 1, (Object) null);
    }

    public final androidx.datastore.preferences.core.c k(c.a aVar, Object obj) {
        Intrinsics.h(aVar, "key");
        return (androidx.datastore.preferences.core.c) i.f((CoroutineContext) null, new JavaDataStorage$putSync$1(this, aVar, obj, null), 1, (Object) null);
    }
}
