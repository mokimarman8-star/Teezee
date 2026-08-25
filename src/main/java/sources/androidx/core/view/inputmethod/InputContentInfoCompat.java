package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class InputContentInfoCompat {
    private final c mImpl;

    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final InputContentInfo f7246a;

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f7246a = new InputContentInfo(uri, clipDescription, uri2);
        }

        a(Object obj) {
            this.f7246a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public Object a() {
            return this.f7246a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public Uri b() {
            return this.f7246a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public Uri c() {
            return this.f7246a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void d() {
            this.f7246a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void e() {
            this.f7246a.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public ClipDescription getDescription() {
            return this.f7246a.getDescription();
        }
    }

    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f7247a;

        /* renamed from: b, reason: collision with root package name */
        private final ClipDescription f7248b;

        /* renamed from: c, reason: collision with root package name */
        private final Uri f7249c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f7247a = uri;
            this.f7248b = clipDescription;
            this.f7249c = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public Object a() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public Uri b() {
            return this.f7249c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public Uri c() {
            return this.f7247a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void d() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public void e() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.c
        public ClipDescription getDescription() {
            return this.f7248b;
        }
    }

    private interface c {
        Object a();

        Uri b();

        Uri c();

        void d();

        void e();

        ClipDescription getDescription();
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.mImpl = new a(uri, clipDescription, uri2);
        } else {
            this.mImpl = new b(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(c cVar) {
        this.mImpl = cVar;
    }

    public static InputContentInfoCompat wrap(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new InputContentInfoCompat(new a(obj));
        }
        return null;
    }

    public Uri getContentUri() {
        return this.mImpl.c();
    }

    public ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    public Uri getLinkUri() {
        return this.mImpl.b();
    }

    public void releasePermission() {
        this.mImpl.e();
    }

    public void requestPermission() {
        this.mImpl.d();
    }

    public Object unwrap() {
        return this.mImpl.a();
    }
}
