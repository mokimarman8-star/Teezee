package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class JsonNull extends u {
    public static final JsonNull c = new JsonNull();
    private static final String d = "null";
    private static final /* synthetic */ Lazy e = LazyKt.a(LazyThreadSafetyMode.PUBLICATION, new Function0<kotlinx.serialization.b>() { // from class: kotlinx.serialization.json.JsonNull$$cachedSerializer$delegate$1
        @Override // kotlin.jvm.functions.Function0
        public final kotlinx.serialization.b invoke() {
            return r.a;
        }
    });

    private JsonNull() {
        super(null);
    }

    @Override // kotlinx.serialization.json.u
    public String a() {
        return d;
    }
}
