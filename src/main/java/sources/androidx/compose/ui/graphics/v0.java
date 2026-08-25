package androidx.compose.ui.graphics;

import android.graphics.PathMeasure;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class v0 implements r4 {

    /* renamed from: a, reason: collision with root package name */
    private final PathMeasure f3671a;

    public v0(PathMeasure pathMeasure) {
        this.f3671a = pathMeasure;
    }

    @Override // androidx.compose.ui.graphics.r4
    public boolean a(float f5, float f6, Path path, boolean z5) {
        PathMeasure pathMeasure = this.f3671a;
        if (path instanceof u0) {
            return pathMeasure.getSegment(f5, f6, ((u0) path).p(), z5);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.r4
    public void b(Path path, boolean z5) {
        android.graphics.Path path2;
        PathMeasure pathMeasure = this.f3671a;
        if (path == null) {
            path2 = null;
        } else {
            if (!(path instanceof u0)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            path2 = ((u0) path).p();
        }
        pathMeasure.setPath(path2, z5);
    }

    @Override // androidx.compose.ui.graphics.r4
    public float getLength() {
        return this.f3671a.getLength();
    }
}
