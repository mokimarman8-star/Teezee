package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f12510a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12511b;

    /* renamed from: c, reason: collision with root package name */
    private final String f12512c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        Intrinsics.h(intent, "intent");
    }

    public g(Uri uri, String str, String str2) {
        this.f12510a = uri;
        this.f12511b = str;
        this.f12512c = str2;
    }

    public String a() {
        return this.f12511b;
    }

    public String b() {
        return this.f12512c;
    }

    public Uri c() {
        return this.f12510a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (c() != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(c()));
        }
        if (a() != null) {
            sb.append(" action=");
            sb.append(a());
        }
        if (b() != null) {
            sb.append(" mimetype=");
            sb.append(b());
        }
        sb.append(" }");
        String sb2 = sb.toString();
        Intrinsics.g(sb2, "sb.toString()");
        return sb2;
    }
}
