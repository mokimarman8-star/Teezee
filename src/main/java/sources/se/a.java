package se;

import java.util.HashSet;
import org.json.JSONObject;
import se.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a extends b {
    protected final HashSet c;
    protected final JSONObject d;
    protected final long e;

    public a(b.InterfaceC0200b interfaceC0200b, HashSet hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0200b);
        this.c = new HashSet(hashSet);
        this.d = jSONObject;
        this.e = j;
    }
}
