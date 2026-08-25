package com.transsion.shorttv_pugc.utils;

import androidx.annotation.Keep;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/transsion/shorttv_pugc/utils/ShortTvVideoCtrBean;", "Ljava/io/Serializable;", "content", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(FLjava/lang/String;)V", "getContent", "()F", "getName", "()Ljava/lang/String;", "isSelect", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "setSelect", "(Z)V", "component1", "component2", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class ShortTvVideoCtrBean implements Serializable {
    private final float content;
    private boolean isSelect;
    private final String name;

    public ShortTvVideoCtrBean(float f, String name) {
        Intrinsics.h(name, "name");
        this.content = f;
        this.name = name;
    }

    public static /* synthetic */ ShortTvVideoCtrBean copy$default(ShortTvVideoCtrBean shortTvVideoCtrBean, float f, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            f = shortTvVideoCtrBean.content;
        }
        if ((i & 2) != 0) {
            str = shortTvVideoCtrBean.name;
        }
        return shortTvVideoCtrBean.copy(f, str);
    }

    /* renamed from: component1, reason: from getter */
    public final float getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ShortTvVideoCtrBean copy(float content, String name) {
        Intrinsics.h(name, "name");
        return new ShortTvVideoCtrBean(content, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShortTvVideoCtrBean)) {
            return false;
        }
        ShortTvVideoCtrBean shortTvVideoCtrBean = (ShortTvVideoCtrBean) other;
        return Float.compare(this.content, shortTvVideoCtrBean.content) == 0 && Intrinsics.c(this.name, shortTvVideoCtrBean.name);
    }

    public final float getContent() {
        return this.content;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.content) * 31) + this.name.hashCode();
    }

    /* renamed from: isSelect, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public String toString() {
        return "ShortTvVideoCtrBean(content=" + this.content + ", name=" + this.name + ")";
    }
}
