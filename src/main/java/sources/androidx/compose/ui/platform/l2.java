package androidx.compose.ui.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.sequences.Sequence;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class l2 implements Sequence {

    /* renamed from: a, reason: collision with root package name */
    private final List f4837a = new ArrayList();

    public final void b(String str, Object obj) {
        this.f4837a.add(new k2(str, obj));
    }

    public Iterator iterator() {
        return this.f4837a.iterator();
    }
}
