package androidx.compose.runtime.saveable;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class SaverKt {

    /* renamed from: a, reason: collision with root package name */
    private static final d f2904a = a(new Function2<e, Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$1
        public final Object invoke(e eVar, Object obj) {
            return obj;
        }
    }, new Function1<Object, Object>() { // from class: androidx.compose.runtime.saveable.SaverKt$AutoSaver$2
        public final Object invoke(Object obj) {
            return obj;
        }
    });

    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f2905a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f2906b;

        a(Function2 function2, Function1 function1) {
            this.f2905a = function2;
            this.f2906b = function1;
        }

        @Override // androidx.compose.runtime.saveable.d
        public Object a(e eVar, Object obj) {
            return this.f2905a.invoke(eVar, obj);
        }

        @Override // androidx.compose.runtime.saveable.d
        public Object b(Object obj) {
            return this.f2906b.invoke(obj);
        }
    }

    public static final d a(Function2 function2, Function1 function1) {
        return new a(function2, function1);
    }

    public static final d b() {
        d dVar = f2904a;
        Intrinsics.f(dVar, "null cannot be cast to non-null type androidx.compose.runtime.saveable.Saver<T of androidx.compose.runtime.saveable.SaverKt.autoSaver, kotlin.Any>");
        return dVar;
    }
}
