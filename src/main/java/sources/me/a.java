package me;

import java.util.HashSet;
import me.b;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a extends b {
    protected final HashSet c;
    protected final JSONObject d;
    protected final long e;

    public a(b.InterfaceC0192b interfaceC0192b, HashSet hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0192b);
        this.c = new HashSet(hashSet);
        this.d = jSONObject;
        this.e = j;
    }
}
