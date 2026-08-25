package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class z0 {
    private static final Pattern d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
    private final String a;
    private final String b;
    private final String c;

    private z0(String str, String str2) {
        this.a = d(str2, str);
        this.b = str;
        this.c = str + "!" + str2;
    }

    static z0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new z0(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", str2));
            str = str.substring(8);
        }
        if (str == null || !d.matcher(str).matches()) {
            throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", str, "[a-zA-Z0-9-_.~%]{1,900}"));
        }
        return str;
    }

    public static z0 f(String str) {
        return new z0("S", str);
    }

    public static z0 g(String str) {
        return new z0("U", str);
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.a.equals(z0Var.a) && this.b.equals(z0Var.b);
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.b, this.a});
    }
}
