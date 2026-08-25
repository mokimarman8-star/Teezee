package androidx.coroutines;

import android.app.Notification;

/* renamed from: androidx.work.e, reason: case insensitive filesystem */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class C0211e {

    /* renamed from: a, reason: collision with root package name */
    private final int f13926a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13927b;

    /* renamed from: c, reason: collision with root package name */
    private final Notification f13928c;

    public C0211e(int i5, Notification notification, int i6) {
        this.f13926a = i5;
        this.f13928c = notification;
        this.f13927b = i6;
    }

    public int a() {
        return this.f13927b;
    }

    public Notification b() {
        return this.f13928c;
    }

    public int c() {
        return this.f13926a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0211e.class != obj.getClass()) {
            return false;
        }
        C0211e c0211e = (C0211e) obj;
        if (this.f13926a == c0211e.f13926a && this.f13927b == c0211e.f13927b) {
            return this.f13928c.equals(c0211e.f13928c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f13926a * 31) + this.f13927b) * 31) + this.f13928c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f13926a + ", mForegroundServiceType=" + this.f13927b + ", mNotification=" + this.f13928c + '}';
    }
}
