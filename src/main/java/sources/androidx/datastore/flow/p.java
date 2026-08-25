package androidx.datastore.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.w;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class p {

    public static final class a extends p {

        /* renamed from: a, reason: collision with root package name */
        private final Function2 f7474a;

        /* renamed from: b, reason: collision with root package name */
        private final w f7475b;

        /* renamed from: c, reason: collision with root package name */
        private final v f7476c;

        /* renamed from: d, reason: collision with root package name */
        private final CoroutineContext f7477d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function2 function2, w wVar, v vVar, CoroutineContext coroutineContext) {
            super(null);
            Intrinsics.h(function2, "transform");
            Intrinsics.h(wVar, "ack");
            Intrinsics.h(coroutineContext, "callerContext");
            this.f7474a = function2;
            this.f7475b = wVar;
            this.f7476c = vVar;
            this.f7477d = coroutineContext;
        }

        public final w a() {
            return this.f7475b;
        }

        public final CoroutineContext b() {
            return this.f7477d;
        }

        public v c() {
            return this.f7476c;
        }

        public final Function2 d() {
            return this.f7474a;
        }
    }

    private p() {
    }

    public /* synthetic */ p(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
