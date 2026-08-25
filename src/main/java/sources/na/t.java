package na;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class t extends c {
    private final int h;
    private final Object i;

    public t(v9.w wVar, int i, int i2) {
        this(wVar, i, i2, 0, null);
    }

    public t(v9.w wVar, int i, int i2, int i3, Object obj) {
        super(wVar, new int[]{i}, i2);
        this.h = i3;
        this.i = obj;
    }

    @Override // na.s
    public void f(long j, long j2, long j3, List list, x9.o[] oVarArr) {
    }

    @Override // na.s
    public int getSelectedIndex() {
        return 0;
    }

    @Override // na.s
    public Object getSelectionData() {
        return this.i;
    }

    @Override // na.s
    public int getSelectionReason() {
        return this.h;
    }
}
