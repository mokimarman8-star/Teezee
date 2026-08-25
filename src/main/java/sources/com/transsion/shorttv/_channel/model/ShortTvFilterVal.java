package com.transsion.shorttv._channel.model;

import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/transsion/shorttv/_channel/model/ShortTvFilterVal;", "Ljava/io/Serializable;", "id", BuildConfig.FLAVOR, "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class ShortTvFilterVal implements Serializable {
    private final String id;
    private final String name;

    public ShortTvFilterVal(String str, String str2) {
        Intrinsics.h(str, "id");
        Intrinsics.h(str2, "name");
        this.id = str;
        this.name = str2;
    }

    public static /* synthetic */ ShortTvFilterVal copy$default(ShortTvFilterVal shortTvFilterVal, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shortTvFilterVal.id;
        }
        if ((i & 2) != 0) {
            str2 = shortTvFilterVal.name;
        }
        return shortTvFilterVal.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final ShortTvFilterVal copy(String id, String name) {
        Intrinsics.h(id, "id");
        Intrinsics.h(name, "name");
        return new ShortTvFilterVal(id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShortTvFilterVal)) {
            return false;
        }
        ShortTvFilterVal shortTvFilterVal = (ShortTvFilterVal) other;
        return Intrinsics.c(this.id, shortTvFilterVal.id) && Intrinsics.c(this.name, shortTvFilterVal.name);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "ShortTvFilterVal(id=" + this.id + ", name=" + this.name + ")";
    }
}
