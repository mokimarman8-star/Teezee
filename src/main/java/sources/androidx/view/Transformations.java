package androidx.view;

import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class Transformations {

    static final class a implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f8279a;

        a(Function1 function1) {
            Intrinsics.h(function1, "function");
            this.f8279a = function1;
        }

        public final Function a() {
            return this.f8279a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f8279a.invoke(obj);
        }
    }

    public static final LiveData a(LiveData liveData) {
        final z zVar;
        Intrinsics.h(liveData, "<this>");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.i()) {
            booleanRef.element = false;
            zVar = new z(liveData.f());
        } else {
            zVar = new z();
        }
        zVar.r(liveData, new a(new Function1<Object, Unit>() { // from class: androidx.lifecycle.Transformations$distinctUntilChanged$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m346invoke(obj);
                return Unit.a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m346invoke(Object obj) {
                Object f5 = z.this.f();
                if (booleanRef.element || ((f5 == null && obj != null) || !(f5 == null || Intrinsics.c(f5, obj)))) {
                    booleanRef.element = false;
                    z.this.q(obj);
                }
            }
        }));
        return zVar;
    }
}
