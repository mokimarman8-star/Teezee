package com.transsion.home.bean;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/transsion/home/bean/RefreshBaseDto;", "T", "Lcom/tn/lib/net/bean/BaseDto;", "msg", BuildConfig.FLAVOR, "code", "data", "reason", "isRefresh", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Z)V", "()Z", "setRefresh", "(Z)V", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class RefreshBaseDto<T> extends BaseDto<T> {
    public static final int $stable = 8;
    private boolean isRefresh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RefreshBaseDto(String str, String str2, T t, String str3, boolean z) {
        super(str, str2, t, str3);
        Intrinsics.h(str, "msg");
        Intrinsics.h(str2, "code");
        Intrinsics.h(str3, "reason");
        this.isRefresh = z;
    }

    /* renamed from: isRefresh, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }
}
