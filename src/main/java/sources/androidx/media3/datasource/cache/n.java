package androidx.media3.datasource.cache;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private final Map f9535a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final List f9536b = new ArrayList();

    private n a(String str, Object obj) {
        this.f9535a.put((String) androidx.media3.common.util.a.e(str), androidx.media3.common.util.a.e(obj));
        this.f9536b.remove(str);
        return this;
    }

    public static n g(n nVar, long j5) {
        return nVar.e("exo_len", j5);
    }

    public static n h(n nVar, Uri uri) {
        return uri == null ? nVar.d("exo_redir") : nVar.f("exo_redir", uri.toString());
    }

    public Map b() {
        HashMap hashMap = new HashMap(this.f9535a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List c() {
        return Collections.unmodifiableList(new ArrayList(this.f9536b));
    }

    public n d(String str) {
        this.f9536b.add(str);
        this.f9535a.remove(str);
        return this;
    }

    public n e(String str, long j5) {
        return a(str, Long.valueOf(j5));
    }

    public n f(String str, String str2) {
        return a(str, str2);
    }
}
