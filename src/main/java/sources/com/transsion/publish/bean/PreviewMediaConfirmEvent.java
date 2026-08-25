package com.transsion.publish.bean;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/transsion/publish/bean/PreviewMediaConfirmEvent;", "Ljava/io/Serializable;", "type", BuildConfig.FLAVOR, "<init>", "(I)V", "getType", "()I", "setType", "from", "getFrom", "setFrom", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PreviewMediaConfirmEvent implements Serializable {
    private int from;
    private int type;

    public PreviewMediaConfirmEvent() {
        this(0, 1, null);
    }

    public PreviewMediaConfirmEvent(int i) {
        this.type = i;
    }

    public /* synthetic */ PreviewMediaConfirmEvent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getFrom() {
        return this.from;
    }

    public final int getType() {
        return this.type;
    }

    public final void setFrom(int i) {
        this.from = i;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
