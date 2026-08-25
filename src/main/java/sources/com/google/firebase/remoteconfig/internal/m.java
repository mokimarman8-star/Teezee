package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import com.google.android.gms.common.util.BiConsumer;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class m {
    public static final Charset e = Charset.forName(C.UTF8_NAME);
    static final Pattern f = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    static final Pattern g = Pattern.compile("^(0|false|f|no|n|off|)$", 2);
    private final Set a = new HashSet();
    private final Executor b;
    private final e c;
    private final e d;

    public m(Executor executor, e eVar, e eVar2) {
        this.b = executor;
        this.c = eVar;
        this.d = eVar2;
    }

    private void c(final String str, final f fVar) {
        if (fVar == null) {
            return;
        }
        synchronized (this.a) {
            try {
                for (final BiConsumer biConsumer : this.a) {
                    this.b.execute(new Runnable() { // from class: com.google.firebase.remoteconfig.internal.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            biConsumer.accept(str, fVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static f e(e eVar) {
        return eVar.f();
    }

    private static Set f(e eVar) {
        HashSet hashSet = new HashSet();
        f e2 = e(eVar);
        if (e2 == null) {
            return hashSet;
        }
        Iterator<String> keys = e2.g().keys();
        while (keys.hasNext()) {
            hashSet.add(keys.next());
        }
        return hashSet;
    }

    private static TreeSet h(String str, f fVar) {
        TreeSet treeSet = new TreeSet();
        Iterator<String> keys = fVar.g().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.startsWith(str)) {
                treeSet.add(next);
            }
        }
        return treeSet;
    }

    private static Long j(e eVar, String str) {
        f e2 = e(eVar);
        if (e2 == null) {
            return null;
        }
        try {
            return Long.valueOf(e2.g().getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static String l(e eVar, String str) {
        f e2 = e(eVar);
        if (e2 == null) {
            return null;
        }
        try {
            return e2.g().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void o(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public void b(BiConsumer biConsumer) {
        synchronized (this.a) {
            this.a.add(biConsumer);
        }
    }

    public Map d() {
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(f(this.c));
        hashSet.addAll(f(this.d));
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            hashMap.put(str, m(str));
        }
        return hashMap;
    }

    public Set g(String str) {
        if (str == null) {
            str = TtmlNode.ANONYMOUS_REGION_ID;
        }
        TreeSet treeSet = new TreeSet();
        f e2 = e(this.c);
        if (e2 != null) {
            treeSet.addAll(h(str, e2));
        }
        f e3 = e(this.d);
        if (e3 != null) {
            treeSet.addAll(h(str, e3));
        }
        return treeSet;
    }

    public long i(String str) {
        Long j = j(this.c, str);
        if (j != null) {
            c(str, e(this.c));
            return j.longValue();
        }
        Long j2 = j(this.d, str);
        if (j2 != null) {
            return j2.longValue();
        }
        o(str, "Long");
        return 0L;
    }

    public String k(String str) {
        String l = l(this.c, str);
        if (l != null) {
            c(str, e(this.c));
            return l;
        }
        String l2 = l(this.d, str);
        if (l2 != null) {
            return l2;
        }
        o(str, "String");
        return TtmlNode.ANONYMOUS_REGION_ID;
    }

    public ad.k m(String str) {
        String l = l(this.c, str);
        if (l != null) {
            c(str, e(this.c));
            return new t(l, 2);
        }
        String l2 = l(this.d, str);
        if (l2 != null) {
            return new t(l2, 1);
        }
        o(str, "FirebaseRemoteConfigValue");
        return new t(TtmlNode.ANONYMOUS_REGION_ID, 0);
    }
}
