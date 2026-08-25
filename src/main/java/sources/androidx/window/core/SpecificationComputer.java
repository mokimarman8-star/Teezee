package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class SpecificationComputer {

    /* renamed from: a, reason: collision with root package name */
    public static final a f13752a = new a(null);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/window/core/SpecificationComputer$VerificationMode;", "", "(Ljava/lang/String;I)V", "STRICT", "LOG", "QUIET", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ SpecificationComputer b(a aVar, Object obj, String str, VerificationMode verificationMode, e eVar, int i5, Object obj2) {
            if ((i5 & 2) != 0) {
                verificationMode = c.f13768a.a();
            }
            if ((i5 & 4) != 0) {
                eVar = androidx.window.core.a.f13763a;
            }
            return aVar.a(obj, str, verificationMode, eVar);
        }

        public final SpecificationComputer a(Object obj, String str, VerificationMode verificationMode, e eVar) {
            Intrinsics.h(obj, "<this>");
            Intrinsics.h(str, "tag");
            Intrinsics.h(verificationMode, "verificationMode");
            Intrinsics.h(eVar, "logger");
            return new f(obj, str, verificationMode, eVar);
        }
    }

    public abstract Object a();

    protected final String b(Object obj, String str) {
        Intrinsics.h(obj, "value");
        Intrinsics.h(str, "message");
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer c(String str, Function1 function1);
}
