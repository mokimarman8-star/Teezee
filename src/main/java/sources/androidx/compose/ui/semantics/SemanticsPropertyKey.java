package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SemanticsPropertyKey {

    /* renamed from: a, reason: collision with root package name */
    private final String f4945a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f4946b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4947c;

    public SemanticsPropertyKey(String str, Function2 function2) {
        this.f4945a = str;
        this.f4946b = function2;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i5 & 2) != 0 ? new Function2<Object, Object, Object>() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            public final Object invoke(Object obj, Object obj2) {
                return obj == null ? obj2 : obj;
            }
        } : function2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SemanticsPropertyKey(String str, boolean z5) {
        this(str, r0, 2, r0);
        Function2 function2 = null;
        this.f4947c = z5;
    }

    public SemanticsPropertyKey(String str, boolean z5, Function2 function2) {
        this(str, function2);
        this.f4947c = z5;
    }

    public final String a() {
        return this.f4945a;
    }

    public final boolean b() {
        return this.f4947c;
    }

    public final Object c(Object obj, Object obj2) {
        return this.f4946b.invoke(obj, obj2);
    }

    public final void d(n nVar, KProperty kProperty, Object obj) {
        nVar.a(this, obj);
    }

    public String toString() {
        return "AccessibilityKey: " + this.f4945a;
    }
}
