package fa;

import da.i;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class c implements i {
    private final List a;

    public c(List list) {
        this.a = list;
    }

    @Override // da.i
    public List getCues(long j) {
        return this.a;
    }

    @Override // da.i
    public long getEventTime(int i) {
        return 0L;
    }

    @Override // da.i
    public int getEventTimeCount() {
        return 1;
    }

    @Override // da.i
    public int getNextEventTimeIndex(long j) {
        return -1;
    }
}
