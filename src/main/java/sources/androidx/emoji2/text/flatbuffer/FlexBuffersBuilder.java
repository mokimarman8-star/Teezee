package androidx.emoji2.text.flatbuffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class FlexBuffersBuilder {

    /* renamed from: a, reason: collision with root package name */
    private final d f7884a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f7885b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f7886c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f7887d;

    /* renamed from: e, reason: collision with root package name */
    private final int f7888e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f7889f;

    /* renamed from: g, reason: collision with root package name */
    private Comparator f7890g;

    private static class a {
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(int i5) {
        this(new androidx.emoji2.text.flatbuffer.a(i5), 1);
    }

    public FlexBuffersBuilder(d dVar, int i5) {
        this.f7885b = new ArrayList();
        this.f7886c = new HashMap();
        this.f7887d = new HashMap();
        this.f7889f = false;
        this.f7890g = new Comparator<a>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            /* renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(a aVar, a aVar2) {
                throw null;
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                android.support.v4.media.session.c.a(aVar);
                android.support.v4.media.session.c.a(aVar2);
                return compare2((a) null, (a) null);
            }
        };
        this.f7884a = dVar;
        this.f7888e = i5;
    }
}
