package au;

import androidx.lifecycle.b0;
import java.util.LinkedList;
import kotlin.Unit;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends b0 {
    private final LinkedList l = new LinkedList();

    public void n(Object obj) {
        synchronized (this.l) {
            try {
                this.l.add(obj);
                if (this.l.size() == 1) {
                    super.n(obj);
                }
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void q(Object obj) {
        super.q(obj);
        synchronized (this.l) {
            this.l.pollFirst();
            Object peekFirst = this.l.peekFirst();
            if (peekFirst != null) {
                super.n(peekFirst);
                Unit unit = Unit.a;
            }
        }
    }
}
