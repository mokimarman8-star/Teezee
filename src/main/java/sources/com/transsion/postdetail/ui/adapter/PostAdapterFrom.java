package com.transsion.postdetail.ui.adapter;

import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/transsion/postdetail/ui/adapter/PostAdapterFrom;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NEARBY", "DEFAULT", "STAGGERED", "DETAIL", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PostAdapterFrom {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PostAdapterFrom[] $VALUES;
    public static final PostAdapterFrom NEARBY = new PostAdapterFrom("NEARBY", 0);
    public static final PostAdapterFrom DEFAULT = new PostAdapterFrom("DEFAULT", 1);
    public static final PostAdapterFrom STAGGERED = new PostAdapterFrom("STAGGERED", 2);
    public static final PostAdapterFrom DETAIL = new PostAdapterFrom("DETAIL", 3);

    private static final /* synthetic */ PostAdapterFrom[] $values() {
        return new PostAdapterFrom[]{NEARBY, DEFAULT, STAGGERED, DETAIL};
    }

    static {
        PostAdapterFrom[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private PostAdapterFrom(String str, int i) {
    }

    public static EnumEntries<PostAdapterFrom> getEntries() {
        return $ENTRIES;
    }

    public static PostAdapterFrom valueOf(String str) {
        return (PostAdapterFrom) Enum.valueOf(PostAdapterFrom.class, str);
    }

    public static PostAdapterFrom[] values() {
        return (PostAdapterFrom[]) $VALUES.clone();
    }
}
