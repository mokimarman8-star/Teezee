package ye;

import java.util.HashSet;
import org.json.JSONObject;
import ye.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a extends b {
    protected final HashSet c;
    protected final JSONObject d;
    protected final long e;

    public a(b.InterfaceC0204b interfaceC0204b, HashSet hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0204b);
        this.c = new HashSet(hashSet);
        this.d = jSONObject;
        this.e = j;
    }
}
