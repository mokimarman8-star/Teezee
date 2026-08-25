package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {

    /* renamed from: f, reason: collision with root package name */
    public static int f6131f = -1;

    /* renamed from: a, reason: collision with root package name */
    int f6132a;

    /* renamed from: b, reason: collision with root package name */
    int f6133b;

    /* renamed from: c, reason: collision with root package name */
    String f6134c;

    /* renamed from: d, reason: collision with root package name */
    protected int f6135d;

    /* renamed from: e, reason: collision with root package name */
    HashMap f6136e;

    public d() {
        int i5 = f6131f;
        this.f6132a = i5;
        this.f6133b = i5;
        this.f6134c = null;
    }

    public abstract void a(HashMap hashMap);

    @Override // 
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract d clone();

    public d c(d dVar) {
        this.f6132a = dVar.f6132a;
        this.f6133b = dVar.f6133b;
        this.f6134c = dVar.f6134c;
        this.f6135d = dVar.f6135d;
        this.f6136e = dVar.f6136e;
        return this;
    }

    abstract void d(HashSet hashSet);

    abstract void e(Context context, AttributeSet attributeSet);

    boolean f(String str) {
        String str2 = this.f6134c;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void g(int i5) {
        this.f6132a = i5;
    }

    public void h(HashMap hashMap) {
    }

    public d i(int i5) {
        this.f6133b = i5;
        return this;
    }

    boolean j(Object obj) {
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(obj.toString());
    }

    float k(Object obj) {
        return obj instanceof Float ? ((Float) obj).floatValue() : Float.parseFloat(obj.toString());
    }

    int l(Object obj) {
        return obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
    }
}
