package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final String f6984a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f6985b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence[] f6986c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f6987d;

    /* renamed from: e, reason: collision with root package name */
    private final int f6988e;

    /* renamed from: f, reason: collision with root package name */
    private final Bundle f6989f;

    /* renamed from: g, reason: collision with root package name */
    private final Set f6990g;

    static class a {
        public static RemoteInput a(y yVar) {
            Set d5;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(yVar.i()).setLabel(yVar.h()).setChoices(yVar.e()).setAllowFreeFormInput(yVar.c()).addExtras(yVar.g());
            if (Build.VERSION.SDK_INT >= 26 && (d5 = yVar.d()) != null) {
                Iterator it = d5.iterator();
                while (it.hasNext()) {
                    b.a(addExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                c.a(addExtras, yVar.f());
            }
            return addExtras.build();
        }
    }

    static class b {
        static RemoteInput.Builder a(RemoteInput.Builder builder, String str, boolean z5) {
            return builder.setAllowDataType(str, z5);
        }
    }

    static class c {
        static RemoteInput.Builder a(RemoteInput.Builder builder, int i5) {
            return builder.setEditChoicesBeforeSending(i5);
        }
    }

    y(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z5, int i5, Bundle bundle, Set set) {
        this.f6984a = str;
        this.f6985b = charSequence;
        this.f6986c = charSequenceArr;
        this.f6987d = z5;
        this.f6988e = i5;
        this.f6989f = bundle;
        this.f6990g = set;
        if (f() == 2 && !c()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    static RemoteInput a(y yVar) {
        return a.a(yVar);
    }

    static RemoteInput[] b(y[] yVarArr) {
        if (yVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[yVarArr.length];
        for (int i5 = 0; i5 < yVarArr.length; i5++) {
            remoteInputArr[i5] = a(yVarArr[i5]);
        }
        return remoteInputArr;
    }

    public boolean c() {
        return this.f6987d;
    }

    public Set d() {
        return this.f6990g;
    }

    public CharSequence[] e() {
        return this.f6986c;
    }

    public int f() {
        return this.f6988e;
    }

    public Bundle g() {
        return this.f6989f;
    }

    public CharSequence h() {
        return this.f6985b;
    }

    public String i() {
        return this.f6984a;
    }

    public boolean j() {
        return (c() || (e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
