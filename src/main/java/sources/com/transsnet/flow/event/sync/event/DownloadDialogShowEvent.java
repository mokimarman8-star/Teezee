package com.transsnet.flow.event.sync.event;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import java.io.Serializable;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/transsnet/flow/event/sync/event/DownloadDialogShowEvent;", "Ljava/io/Serializable;", "show", "", "<init>", "(Z)V", "getShow", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "FlowEvent_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final /* data */ class DownloadDialogShowEvent implements Serializable {
    private final boolean show;

    public DownloadDialogShowEvent(boolean z) {
        this.show = z;
    }

    public static /* synthetic */ DownloadDialogShowEvent copy$default(DownloadDialogShowEvent downloadDialogShowEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = downloadDialogShowEvent.show;
        }
        return downloadDialogShowEvent.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    public final DownloadDialogShowEvent copy(boolean show) {
        return new DownloadDialogShowEvent(show);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DownloadDialogShowEvent) && this.show == ((DownloadDialogShowEvent) other).show;
    }

    public final boolean getShow() {
        return this.show;
    }

    public int hashCode() {
        return e.a(this.show);
    }

    public String toString() {
        return "DownloadDialogShowEvent(show=" + this.show + ")";
    }
}
