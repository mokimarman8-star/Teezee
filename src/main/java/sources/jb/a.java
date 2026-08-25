package jb;

import android.text.TextUtils;
import com.google.firebase.abt.AbtException;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import mb.a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private static final String[] g = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};
    static final DateFormat h = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    private final String a;
    private final String b;
    private final String c;
    private final Date d;
    private final long e;
    private final long f;

    public a(String str, String str2, String str3, Date date, long j, long j2) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = date;
        this.e = j;
        this.f = j2;
    }

    static a a(a.c cVar) {
        String str = cVar.d;
        if (str == null) {
            str = TtmlNode.ANONYMOUS_REGION_ID;
        }
        return new a(cVar.b, String.valueOf(cVar.c), str, new Date(cVar.m), cVar.e, cVar.j);
    }

    static a b(Map map) {
        g(map);
        try {
            return new a((String) map.get("experimentId"), (String) map.get("variantId"), map.containsKey("triggerEvent") ? (String) map.get("triggerEvent") : TtmlNode.ANONYMOUS_REGION_ID, h.parse((String) map.get("experimentStartTime")), Long.parseLong((String) map.get("triggerTimeoutMillis")), Long.parseLong((String) map.get("timeToLiveMillis")));
        } catch (NumberFormatException e) {
            throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e);
        } catch (ParseException e2) {
            throw new AbtException("Could not process experiment: parsing experiment start time failed.", e2);
        }
    }

    private static void g(Map map) {
        ArrayList arrayList = new ArrayList();
        for (String str : g) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", arrayList));
        }
    }

    String c() {
        return this.a;
    }

    long d() {
        return this.d.getTime();
    }

    String e() {
        return this.b;
    }

    a.c f(String str) {
        a.c cVar = new a.c();
        cVar.a = str;
        cVar.m = d();
        cVar.b = this.a;
        cVar.c = this.b;
        cVar.d = TextUtils.isEmpty(this.c) ? null : this.c;
        cVar.e = this.e;
        cVar.j = this.f;
        return cVar;
    }
}
