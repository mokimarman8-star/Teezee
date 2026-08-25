package com.transsion.member.bean.request;

import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/transsion/member/bean/request/MemberPromoCodeReq;", "Ljava/io/Serializable;", "code", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MemberPromoCodeReq implements Serializable {
    public static final int $stable = 0;
    private final String code;

    public MemberPromoCodeReq(String str) {
        Intrinsics.h(str, "code");
        this.code = str;
    }

    public static /* synthetic */ MemberPromoCodeReq copy$default(MemberPromoCodeReq memberPromoCodeReq, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = memberPromoCodeReq.code;
        }
        return memberPromoCodeReq.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    public final MemberPromoCodeReq copy(String code) {
        Intrinsics.h(code, "code");
        return new MemberPromoCodeReq(code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MemberPromoCodeReq) && Intrinsics.c(this.code, ((MemberPromoCodeReq) other).code);
    }

    public final String getCode() {
        return this.code;
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        return "MemberPromoCodeReq(code=" + this.code + ")";
    }
}
