package androidx.media3.common;

import android.view.View;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final View f8462a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8463b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8464c;

    /* renamed from: androidx.media3.common.a$a, reason: collision with other inner class name */
    public static final class C0069a {

        /* renamed from: a, reason: collision with root package name */
        private final View f8465a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8466b;

        /* renamed from: c, reason: collision with root package name */
        private String f8467c;

        public C0069a(View view, int i5) {
            this.f8465a = view;
            this.f8466b = i5;
        }

        public a a() {
            return new a(this.f8465a, this.f8466b, this.f8467c);
        }

        public C0069a b(String str) {
            this.f8467c = str;
            return this;
        }
    }

    public a(View view, int i5, String str) {
        this.f8462a = view;
        this.f8463b = i5;
        this.f8464c = str;
    }
}
