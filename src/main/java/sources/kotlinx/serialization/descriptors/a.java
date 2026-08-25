package kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    private final String a;
    private List b;
    private final List c;
    private final Set d;
    private final List e;
    private final List f;
    private final List g;

    public a(String serialName) {
        Intrinsics.h(serialName, "serialName");
        this.a = serialName;
        this.b = CollectionsKt.l();
        this.c = new ArrayList();
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static /* synthetic */ void b(a aVar, String str, f fVar, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.l();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        aVar.a(str, fVar, list, z);
    }

    public final void a(String elementName, f descriptor, List annotations, boolean z) {
        Intrinsics.h(elementName, "elementName");
        Intrinsics.h(descriptor, "descriptor");
        Intrinsics.h(annotations, "annotations");
        if (!this.d.add(elementName)) {
            throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered").toString());
        }
        this.c.add(elementName);
        this.e.add(descriptor);
        this.f.add(annotations);
        this.g.add(Boolean.valueOf(z));
    }

    public final List c() {
        return this.b;
    }

    public final List d() {
        return this.f;
    }

    public final List e() {
        return this.e;
    }

    public final List f() {
        return this.c;
    }

    public final List g() {
        return this.g;
    }

    public final void h(List list) {
        Intrinsics.h(list, "<set-?>");
        this.b = list;
    }
}
