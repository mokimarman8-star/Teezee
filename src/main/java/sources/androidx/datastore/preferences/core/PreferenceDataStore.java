package androidx.datastore.preferences.core;

import androidx.datastore.flow.g;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class PreferenceDataStore implements g {

    /* renamed from: a, reason: collision with root package name */
    private final g f7507a;

    public PreferenceDataStore(g gVar) {
        Intrinsics.h(gVar, "delegate");
        this.f7507a = gVar;
    }

    @Override // androidx.datastore.flow.g
    public Object a(Function2 function2, Continuation continuation) {
        return this.f7507a.a(new PreferenceDataStore$updateData$2(function2, null), continuation);
    }

    @Override // androidx.datastore.flow.g
    public kotlinx.coroutines.flow.a getData() {
        return this.f7507a.getData();
    }
}
