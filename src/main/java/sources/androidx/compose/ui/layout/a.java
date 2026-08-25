package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0031a f4155b = new C0031a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Function2 f4156a;

    /* renamed from: androidx.compose.ui.layout.a$a, reason: collision with other inner class name */
    public static final class C0031a {
        private C0031a() {
        }

        public /* synthetic */ C0031a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private a(Function2 function2) {
        this.f4156a = function2;
    }

    public /* synthetic */ a(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2);
    }

    public final Function2 a() {
        return this.f4156a;
    }
}
