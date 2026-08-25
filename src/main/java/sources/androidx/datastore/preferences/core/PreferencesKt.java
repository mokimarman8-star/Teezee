package androidx.datastore.preferences.core;

import androidx.datastore.flow.g;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class PreferencesKt {
    public static final Object a(g gVar, Function2 function2, Continuation continuation) {
        return gVar.a(new PreferencesKt$edit$2(function2, null), continuation);
    }
}
