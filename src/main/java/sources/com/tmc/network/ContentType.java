package com.tmc.network;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tmc/network/ContentType;", TtmlNode.ANONYMOUS_REGION_ID, "value", TtmlNode.ANONYMOUS_REGION_ID, "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FORM", "MULTIPART", "JSON", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public enum ContentType {
    FORM("application/x-www-from-urlencoded"),
    MULTIPART("multipart/form-data"),
    JSON("application/json");

    private final String value;

    ContentType(String str) {
        this.value = Intrinsics.q(str, ";charset=utf-8");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
