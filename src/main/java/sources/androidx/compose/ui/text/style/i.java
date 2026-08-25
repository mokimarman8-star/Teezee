package androidx.compose.ui.text.style;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5405b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final i f5406c = new i(0);

    /* renamed from: d, reason: collision with root package name */
    private static final i f5407d = new i(1);

    /* renamed from: e, reason: collision with root package name */
    private static final i f5408e = new i(2);

    /* renamed from: a, reason: collision with root package name */
    private final int f5409a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a(List list) {
            Integer num = 0;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                num = Integer.valueOf(num.intValue() | ((i) list.get(i5)).e());
            }
            return new i(num.intValue());
        }

        public final i b() {
            return i.f5408e;
        }

        public final i c() {
            return i.f5406c;
        }

        public final i d() {
            return i.f5407d;
        }
    }

    public i(int i5) {
        this.f5409a = i5;
    }

    public final boolean d(i iVar) {
        int i5 = this.f5409a;
        return (iVar.f5409a | i5) == i5;
    }

    public final int e() {
        return this.f5409a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f5409a == ((i) obj).f5409a;
    }

    public int hashCode() {
        return this.f5409a;
    }

    public String toString() {
        if (this.f5409a == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.f5409a & f5407d.f5409a) != 0) {
            arrayList.add("Underline");
        }
        if ((this.f5409a & f5408e.f5409a) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + q0.a.d(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
