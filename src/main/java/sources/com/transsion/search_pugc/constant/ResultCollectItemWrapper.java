package com.transsion.search_pugc.constant;

import com.transsion.gslb.BuildConfig;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ResultCollectItemWrapper {
    private final UGCVideo a;
    private final Type b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/transsion/search_pugc/constant/ResultCollectItemWrapper$Type;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DATA", "FOOTER", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DATA = new Type("DATA", 0);
        public static final Type FOOTER = new Type("FOOTER", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DATA, FOOTER};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.a($values);
        }

        private Type(String str, int i) {
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ResultCollectItemWrapper() {
        this(r0, r0, 3, r0);
        UGCVideo uGCVideo = null;
    }

    public ResultCollectItemWrapper(UGCVideo uGCVideo, Type type) {
        Intrinsics.h(type, "type");
        this.a = uGCVideo;
        this.b = type;
    }

    public /* synthetic */ ResultCollectItemWrapper(UGCVideo uGCVideo, Type type, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uGCVideo, (i & 2) != 0 ? Type.DATA : type);
    }

    public final UGCVideo a() {
        return this.a;
    }

    public final Type b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultCollectItemWrapper)) {
            return false;
        }
        ResultCollectItemWrapper resultCollectItemWrapper = (ResultCollectItemWrapper) obj;
        return Intrinsics.c(this.a, resultCollectItemWrapper.a) && this.b == resultCollectItemWrapper.b;
    }

    public int hashCode() {
        UGCVideo uGCVideo = this.a;
        return ((uGCVideo == null ? 0 : uGCVideo.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ResultCollectItemWrapper(data=" + this.a + ", type=" + this.b + ")";
    }
}
