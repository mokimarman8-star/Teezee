package com.google.firebase.datastorage;

import androidx.datastore.preferences.core.c;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {
    public static final Object a(androidx.datastore.preferences.core.c cVar, c.a aVar, Object obj) {
        Intrinsics.h(cVar, "<this>");
        Intrinsics.h(aVar, "key");
        Object b = cVar.b(aVar);
        return b == null ? obj : b;
    }
}
