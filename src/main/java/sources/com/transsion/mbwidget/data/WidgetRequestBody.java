package com.transsion.mbwidget.data;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/transsion/mbwidget/data/WidgetRequestBody;", "Ljava/io/Serializable;", "hotListCnt", BuildConfig.FLAVOR, "userInterestsCnt", "<init>", "(II)V", "getHotListCnt", "()I", "getUserInterestsCnt", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class WidgetRequestBody implements Serializable {
    private final int hotListCnt;
    private final int userInterestsCnt;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WidgetRequestBody() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public WidgetRequestBody(int i, int i2) {
        this.hotListCnt = i;
        this.userInterestsCnt = i2;
    }

    public /* synthetic */ WidgetRequestBody(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 8 : i2);
    }

    public final int getHotListCnt() {
        return this.hotListCnt;
    }

    public final int getUserInterestsCnt() {
        return this.userInterestsCnt;
    }
}
