package com.cloud.tmc.integration.model;

import android.os.SystemClock;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.utils.GenerateIdUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/cloud/tmc/integration/model/ForegroundTime;", "", "()V", "endTime", "", "foregroundRandomId", "", "foregroundStartCount", "", "startTime", "addStartCount", "", "resetStartCount", "setEndTime", "Lcom/cloud/tmc/integration/model/ForegroundRangTime;", "setStartTime", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ForegroundTime {
    private long endTime;
    private String foregroundRandomId = GenerateIdUtils.INSTANCE.generateRandomId();
    private int foregroundStartCount;
    private long startTime;

    public final void addStartCount() {
        this.foregroundStartCount++;
    }

    public final void resetStartCount() {
        this.foregroundStartCount = 0;
    }

    public final ForegroundRangTime setEndTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.endTime = elapsedRealtime;
        long j = this.startTime;
        return new ForegroundRangTime(j, elapsedRealtime, elapsedRealtime - j, this.foregroundStartCount, this.foregroundRandomId);
    }

    public final void setStartTime() {
        this.startTime = SystemClock.elapsedRealtime();
    }
}
