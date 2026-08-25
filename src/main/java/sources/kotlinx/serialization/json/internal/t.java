package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class t {
    public static final Map a(int i) {
        return new ConcurrentHashMap(i);
    }
}
