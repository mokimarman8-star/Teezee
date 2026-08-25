package x6;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class z {
    private String info;
    private long layerId;
    private long requestTime;

    public z() {
        this(0L, 0L, null, 7, null);
    }

    public z(long j, long j2, String str) {
        this.layerId = j;
        this.requestTime = j2;
        this.info = str;
    }

    public /* synthetic */ z(long j, long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? null : str);
    }

    public final String getInfo() {
        return this.info;
    }

    public final long getLayerId() {
        return this.layerId;
    }

    public final long getRequestTime() {
        return this.requestTime;
    }

    public final void setInfo(String str) {
        this.info = str;
    }

    public final void setLayerId(long j) {
        this.layerId = j;
    }

    public final void setRequestTime(long j) {
        this.requestTime = j;
    }
}
