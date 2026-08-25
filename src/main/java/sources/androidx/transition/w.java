package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class w {

    /* renamed from: b, reason: collision with root package name */
    public View f13585b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f13584a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f13586c = new ArrayList();

    @Deprecated
    public w() {
    }

    public w(View view) {
        this.f13585b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f13585b == wVar.f13585b && this.f13584a.equals(wVar.f13584a);
    }

    public int hashCode() {
        return (this.f13585b.hashCode() * 31) + this.f13584a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f13585b + "\n") + "    values:";
        for (String str2 : this.f13584a.keySet()) {
            str = str + "    " + str2 + ": " + this.f13584a.get(str2) + "\n";
        }
        return str;
    }
}
