package androidx.compose.ui.text.font;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5145b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final p f5146c;

    /* renamed from: d, reason: collision with root package name */
    private static final p f5147d;

    /* renamed from: e, reason: collision with root package name */
    private static final p f5148e;

    /* renamed from: f, reason: collision with root package name */
    private static final p f5149f;

    /* renamed from: g, reason: collision with root package name */
    private static final p f5150g;

    /* renamed from: h, reason: collision with root package name */
    private static final p f5151h;

    /* renamed from: i, reason: collision with root package name */
    private static final p f5152i;

    /* renamed from: j, reason: collision with root package name */
    private static final p f5153j;

    /* renamed from: k, reason: collision with root package name */
    private static final p f5154k;

    /* renamed from: l, reason: collision with root package name */
    private static final p f5155l;

    /* renamed from: m, reason: collision with root package name */
    private static final p f5156m;

    /* renamed from: n, reason: collision with root package name */
    private static final p f5157n;

    /* renamed from: o, reason: collision with root package name */
    private static final p f5158o;

    /* renamed from: p, reason: collision with root package name */
    private static final p f5159p;

    /* renamed from: q, reason: collision with root package name */
    private static final p f5160q;

    /* renamed from: r, reason: collision with root package name */
    private static final p f5161r;

    /* renamed from: s, reason: collision with root package name */
    private static final p f5162s;

    /* renamed from: t, reason: collision with root package name */
    private static final p f5163t;

    /* renamed from: u, reason: collision with root package name */
    private static final List f5164u;

    /* renamed from: a, reason: collision with root package name */
    private final int f5165a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a() {
            return p.f5158o;
        }

        public final p b() {
            return p.f5149f;
        }

        public final p c() {
            return p.f5150g;
        }

        public final p d() {
            return p.f5151h;
        }

        public final p e() {
            return p.f5152i;
        }
    }

    static {
        p pVar = new p(100);
        f5146c = pVar;
        p pVar2 = new p(200);
        f5147d = pVar2;
        p pVar3 = new p(300);
        f5148e = pVar3;
        p pVar4 = new p(400);
        f5149f = pVar4;
        p pVar5 = new p(500);
        f5150g = pVar5;
        p pVar6 = new p(600);
        f5151h = pVar6;
        p pVar7 = new p(700);
        f5152i = pVar7;
        p pVar8 = new p(800);
        f5153j = pVar8;
        p pVar9 = new p(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
        f5154k = pVar9;
        f5155l = pVar;
        f5156m = pVar2;
        f5157n = pVar3;
        f5158o = pVar4;
        f5159p = pVar5;
        f5160q = pVar6;
        f5161r = pVar7;
        f5162s = pVar8;
        f5163t = pVar9;
        f5164u = CollectionsKt.o(new p[]{pVar, pVar2, pVar3, pVar4, pVar5, pVar6, pVar7, pVar8, pVar9});
    }

    public p(int i5) {
        this.f5165a = i5;
        if (1 > i5 || i5 >= 1001) {
            throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + i5).toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && this.f5165a == ((p) obj).f5165a;
    }

    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(p pVar) {
        return Intrinsics.j(this.f5165a, pVar.f5165a);
    }

    public final int h() {
        return this.f5165a;
    }

    public int hashCode() {
        return this.f5165a;
    }

    public String toString() {
        return "FontWeight(weight=" + this.f5165a + ')';
    }
}
