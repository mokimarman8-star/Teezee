package com.transsion.member.bean.request;

import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/transsion/member/bean/request/InviteUserShareInfoReq;", "Ljava/io/Serializable;", "type", BuildConfig.FLAVOR, "scene", "utmSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getScene", "getUtmSource", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class InviteUserShareInfoReq implements Serializable {
    public static final int $stable = 0;
    private final String scene;
    private final String type;
    private final String utmSource;

    public InviteUserShareInfoReq(String str, String str2, String str3) {
        Intrinsics.h(str, "type");
        Intrinsics.h(str2, "scene");
        Intrinsics.h(str3, "utmSource");
        this.type = str;
        this.scene = str2;
        this.utmSource = str3;
    }

    public /* synthetic */ InviteUserShareInfoReq(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "fissionInvite" : str, str2, (i & 4) != 0 ? str2 : str3);
    }

    public static /* synthetic */ InviteUserShareInfoReq copy$default(InviteUserShareInfoReq inviteUserShareInfoReq, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inviteUserShareInfoReq.type;
        }
        if ((i & 2) != 0) {
            str2 = inviteUserShareInfoReq.scene;
        }
        if ((i & 4) != 0) {
            str3 = inviteUserShareInfoReq.utmSource;
        }
        return inviteUserShareInfoReq.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUtmSource() {
        return this.utmSource;
    }

    public final InviteUserShareInfoReq copy(String type, String scene, String utmSource) {
        Intrinsics.h(type, "type");
        Intrinsics.h(scene, "scene");
        Intrinsics.h(utmSource, "utmSource");
        return new InviteUserShareInfoReq(type, scene, utmSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteUserShareInfoReq)) {
            return false;
        }
        InviteUserShareInfoReq inviteUserShareInfoReq = (InviteUserShareInfoReq) other;
        return Intrinsics.c(this.type, inviteUserShareInfoReq.type) && Intrinsics.c(this.scene, inviteUserShareInfoReq.scene) && Intrinsics.c(this.utmSource, inviteUserShareInfoReq.utmSource);
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUtmSource() {
        return this.utmSource;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.scene.hashCode()) * 31) + this.utmSource.hashCode();
    }

    public String toString() {
        return "InviteUserShareInfoReq(type=" + this.type + ", scene=" + this.scene + ", utmSource=" + this.utmSource + ")";
    }
}
