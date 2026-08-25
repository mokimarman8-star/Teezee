package androidx.activity.result;

import androidx.lifecycle.Lifecycle;
import androidx.view.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class ActivityResultRegistry$c {

    /* renamed from: a, reason: collision with root package name */
    private final Lifecycle f117a;

    /* renamed from: b, reason: collision with root package name */
    private final List f118b;

    public ActivityResultRegistry$c(Lifecycle lifecycle) {
        Intrinsics.h(lifecycle, "lifecycle");
        this.f117a = lifecycle;
        this.f118b = new ArrayList();
    }

    public final void a(r rVar) {
        Intrinsics.h(rVar, "observer");
        this.f117a.a(rVar);
        this.f118b.add(rVar);
    }

    public final void b() {
        Iterator it = this.f118b.iterator();
        while (it.hasNext()) {
            this.f117a.d((r) it.next());
        }
        this.f118b.clear();
    }
}
