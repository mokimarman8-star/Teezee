package androidx.compose.ui.text;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {

    public static final class a extends f {

        /* renamed from: a, reason: collision with root package name */
        private final String f5094a;

        /* renamed from: b, reason: collision with root package name */
        private final a0 f5095b;

        public a(String str, a0 a0Var, g gVar) {
            super(null);
            this.f5094a = str;
            this.f5095b = a0Var;
        }

        @Override // androidx.compose.ui.text.f
        public g a() {
            return null;
        }

        public a0 b() {
            return this.f5095b;
        }

        public final String c() {
            return this.f5094a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Intrinsics.c(this.f5094a, aVar.f5094a) || !Intrinsics.c(b(), aVar.b())) {
                return false;
            }
            a();
            aVar.a();
            return Intrinsics.c((Object) null, (Object) null);
        }

        public int hashCode() {
            int hashCode = this.f5094a.hashCode() * 31;
            a0 b5 = b();
            int hashCode2 = (hashCode + (b5 != null ? b5.hashCode() : 0)) * 31;
            a();
            return hashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.f5094a + ')';
        }
    }

    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        private final String f5096a;

        /* renamed from: b, reason: collision with root package name */
        private final a0 f5097b;

        public b(String str, a0 a0Var, g gVar) {
            super(null);
            this.f5096a = str;
            this.f5097b = a0Var;
        }

        public /* synthetic */ b(String str, a0 a0Var, g gVar, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i5 & 2) != 0 ? null : a0Var, (i5 & 4) != 0 ? null : gVar);
        }

        @Override // androidx.compose.ui.text.f
        public g a() {
            return null;
        }

        public a0 b() {
            return this.f5097b;
        }

        public final String c() {
            return this.f5096a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!Intrinsics.c(this.f5096a, bVar.f5096a) || !Intrinsics.c(b(), bVar.b())) {
                return false;
            }
            a();
            bVar.a();
            return Intrinsics.c((Object) null, (Object) null);
        }

        public int hashCode() {
            int hashCode = this.f5096a.hashCode() * 31;
            a0 b5 = b();
            int hashCode2 = (hashCode + (b5 != null ? b5.hashCode() : 0)) * 31;
            a();
            return hashCode2;
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.f5096a + ')';
        }
    }

    private f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract g a();
}
