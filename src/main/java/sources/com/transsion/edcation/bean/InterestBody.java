package com.transsion.edcation.bean;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/transsion/edcation/bean/InterestBody;", "Ljava/io/Serializable;", "ids", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;)V", "getIds", "()Ljava/util/List;", "Education_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class InterestBody implements Serializable {
    private final List<String> ids;

    public InterestBody(List<String> list) {
        Intrinsics.h(list, "ids");
        this.ids = list;
    }

    public final List<String> getIds() {
        return this.ids;
    }
}
