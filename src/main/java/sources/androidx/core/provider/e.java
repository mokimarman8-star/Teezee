package androidx.core.provider;

import android.util.Base64;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f7048a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7049b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7050c;

    /* renamed from: d, reason: collision with root package name */
    private final List f7051d;

    /* renamed from: e, reason: collision with root package name */
    private final int f7052e = 0;

    /* renamed from: f, reason: collision with root package name */
    private final String f7053f;

    public e(String str, String str2, String str3, List list) {
        this.f7048a = (String) androidx.core.util.i.g(str);
        this.f7049b = (String) androidx.core.util.i.g(str2);
        this.f7050c = (String) androidx.core.util.i.g(str3);
        this.f7051d = (List) androidx.core.util.i.g(list);
        this.f7053f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List b() {
        return this.f7051d;
    }

    public int c() {
        return this.f7052e;
    }

    String d() {
        return this.f7053f;
    }

    public String e() {
        return this.f7048a;
    }

    public String f() {
        return this.f7049b;
    }

    public String g() {
        return this.f7050c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f7048a + ", mProviderPackage: " + this.f7049b + ", mQuery: " + this.f7050c + ", mCertificates:");
        for (int i5 = 0; i5 < this.f7051d.size(); i5++) {
            sb.append(" [");
            List list = (List) this.f7051d.get(i5);
            for (int i6 = 0; i6 < list.size(); i6++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list.get(i6), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f7052e);
        return sb.toString();
    }
}
