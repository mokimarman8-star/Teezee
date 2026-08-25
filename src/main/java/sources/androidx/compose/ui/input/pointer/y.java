package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final long f4071a;

    /* renamed from: b, reason: collision with root package name */
    private final List f4072b;

    /* renamed from: c, reason: collision with root package name */
    private final MotionEvent f4073c;

    public y(long j5, List list, MotionEvent motionEvent) {
        this.f4071a = j5;
        this.f4072b = list;
        this.f4073c = motionEvent;
    }

    public final MotionEvent a() {
        return this.f4073c;
    }

    public final List b() {
        return this.f4072b;
    }
}
