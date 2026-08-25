package com.transsion.flow.bean;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostItemType$a {
    private PostItemType$a() {
    }

    public /* synthetic */ PostItemType$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final PostItemType a(String str) {
        Intrinsics.h(str, "value");
        for (PostItemType postItemType : PostItemType.values()) {
            if (Intrinsics.c(postItemType.getValue(), str)) {
                return postItemType;
            }
        }
        return null;
    }
}
