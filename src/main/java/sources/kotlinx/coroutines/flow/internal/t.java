package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.h1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class t extends SharedFlowImpl implements h1 {
    public t(int i) {
        super(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
        b(Integer.valueOf(i));
    }

    @Override // kotlinx.coroutines.flow.h1
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public Integer getValue() {
        Integer valueOf;
        synchronized (this) {
            valueOf = Integer.valueOf(((Number) M()).intValue());
        }
        return valueOf;
    }

    public final boolean a0(int i) {
        boolean b;
        synchronized (this) {
            b = b(Integer.valueOf(((Number) M()).intValue() + i));
        }
        return b;
    }
}
