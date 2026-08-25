package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.h0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c extends h0.a {
    private final String a;
    private final String b;
    private final String c;

    c(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0.a
    public String c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0.a
    public String d() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.h0.a
    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h0.a)) {
            return false;
        }
        h0.a aVar = (h0.a) obj;
        if (this.a.equals(aVar.c()) && ((str = this.b) != null ? str.equals(aVar.e()) : aVar.e() == null)) {
            String str2 = this.c;
            if (str2 == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (str2.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        return hashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.a + ", firebaseInstallationId=" + this.b + ", firebaseAuthenticationToken=" + this.c + "}";
    }
}
