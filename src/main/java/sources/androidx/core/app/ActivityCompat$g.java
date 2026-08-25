package androidx.core.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.a0;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class ActivityCompat$g extends SharedElementCallback {

    /* renamed from: a, reason: collision with root package name */
    private final a0 f6796a;

    ActivityCompat$g(a0 a0Var) {
        this.f6796a = a0Var;
    }

    @Override // android.app.SharedElementCallback
    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.f6796a.b(view, matrix, rectF);
    }

    @Override // android.app.SharedElementCallback
    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.f6796a.c(context, parcelable);
    }

    @Override // android.app.SharedElementCallback
    public void onMapSharedElements(List list, Map map) {
        this.f6796a.d(list, map);
    }

    @Override // android.app.SharedElementCallback
    public void onRejectSharedElements(List list) {
        this.f6796a.e(list);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementEnd(List list, List list2, List list3) {
        this.f6796a.f(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementStart(List list, List list2, List list3) {
        this.f6796a.g(list, list2, list3);
    }

    @Override // android.app.SharedElementCallback
    public void onSharedElementsArrived(List list, List list2, final SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f6796a.h(list, list2, new a0.a() { // from class: androidx.core.app.b
            @Override // androidx.core.app.a0.a
            public final void a() {
                ActivityCompat$b.a(onSharedElementsReadyListener);
            }
        });
    }
}
