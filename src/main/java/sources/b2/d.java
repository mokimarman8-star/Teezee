package b2;

import androidx.media3.exoplayer.offline.q;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d implements q {

    /* renamed from: a, reason: collision with root package name */
    public final String f14165a;

    /* renamed from: b, reason: collision with root package name */
    public final List f14166b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14167c;

    protected d(String str, List list, boolean z5) {
        this.f14165a = str;
        this.f14166b = Collections.unmodifiableList(list);
        this.f14167c = z5;
    }
}
