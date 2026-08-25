package androidx.core.view;

import android.os.Build;
import android.view.ScrollFeedbackProvider;
import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ScrollFeedbackProviderCompat {
    private final d mImpl;

    private static class b implements d {

        /* renamed from: a, reason: collision with root package name */
        private final ScrollFeedbackProvider f7150a;

        b(View view) {
            this.f7150a = ScrollFeedbackProvider.createProvider(view);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void a(int i5, int i6, int i7, boolean z5) {
            this.f7150a.onScrollLimit(i5, i6, i7, z5);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void b(int i5, int i6, int i7, int i8) {
            this.f7150a.onScrollProgress(i5, i6, i7, i8);
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void c(int i5, int i6, int i7) {
            this.f7150a.onSnapToItem(i5, i6, i7);
        }
    }

    private static class c implements d {
        private c() {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void a(int i5, int i6, int i7, boolean z5) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void b(int i5, int i6, int i7, int i8) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.d
        public void c(int i5, int i6, int i7) {
        }
    }

    private interface d {
        void a(int i5, int i6, int i7, boolean z5);

        void b(int i5, int i6, int i7, int i8);

        void c(int i5, int i6, int i7);
    }

    private ScrollFeedbackProviderCompat(View view) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.mImpl = new b(view);
        } else {
            this.mImpl = new c();
        }
    }

    public static ScrollFeedbackProviderCompat createProvider(View view) {
        return new ScrollFeedbackProviderCompat(view);
    }

    public void onScrollLimit(int i5, int i6, int i7, boolean z5) {
        this.mImpl.a(i5, i6, i7, z5);
    }

    public void onScrollProgress(int i5, int i6, int i7, int i8) {
        this.mImpl.b(i5, i6, i7, i8);
    }

    public void onSnapToItem(int i5, int i6, int i7) {
        this.mImpl.c(i5, i6, i7);
    }
}
