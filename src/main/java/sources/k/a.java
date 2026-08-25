package k;

import java.util.HashMap;
import java.util.Map;
import k.b;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class a extends b {

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f15981e = new HashMap();

    @Override // k.b
    protected b.c b(Object obj) {
        return (b.c) this.f15981e.get(obj);
    }

    public boolean contains(Object obj) {
        return this.f15981e.containsKey(obj);
    }

    @Override // k.b
    public Object g(Object obj, Object obj2) {
        b.c b5 = b(obj);
        if (b5 != null) {
            return b5.f15987b;
        }
        this.f15981e.put(obj, f(obj, obj2));
        return null;
    }

    @Override // k.b
    public Object i(Object obj) {
        Object i5 = super.i(obj);
        this.f15981e.remove(obj);
        return i5;
    }

    public Map.Entry j(Object obj) {
        if (contains(obj)) {
            return ((b.c) this.f15981e.get(obj)).f15989d;
        }
        return null;
    }
}
