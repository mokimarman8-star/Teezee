package com.transsion.memberapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\bj\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lcom/transsion/memberapi/MemberSource;", "Landroid/os/Parcelable;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "dest", BuildConfig.FLAVOR, "flags", BuildConfig.FLAVOR, "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Ljava/lang/String;", "getValue", "Companion", "a", "SOURCE_HDDL", "SOURCE_MULTI_DL", "SOURCE_AD_DIALOG", "SOURCE_DOWNLOAD_DIALOG", "SOURCE_LANDSCAPE_PLAY", "SOURCE_OTHER_DOWNLOAD_DIALOG", "SOURCE_AD", "THREE_IN_ONE_POPUP", "SOURCE_STREAM_RESOLUTION_DIALOG", "SOURCE_STREAM_RESOLUTION_TIP", "SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR", "SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG", "SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT", "MemberApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberSource implements Parcelable {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MemberSource[] $VALUES;
    public static final Parcelable.Creator<MemberSource> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String value;
    public static final MemberSource SOURCE_HDDL = new MemberSource("SOURCE_HDDL", 0, "HDDL");
    public static final MemberSource SOURCE_MULTI_DL = new MemberSource("SOURCE_MULTI_DL", 1, "Multi_DL_DIALOG");
    public static final MemberSource SOURCE_AD_DIALOG = new MemberSource("SOURCE_AD_DIALOG", 2, "AD_DIALOG");
    public static final MemberSource SOURCE_DOWNLOAD_DIALOG = new MemberSource("SOURCE_DOWNLOAD_DIALOG", 3, "DOWNLOAD_DIALOG");
    public static final MemberSource SOURCE_LANDSCAPE_PLAY = new MemberSource("SOURCE_LANDSCAPE_PLAY", 4, "LANDSCAPE_PLAY");
    public static final MemberSource SOURCE_OTHER_DOWNLOAD_DIALOG = new MemberSource("SOURCE_OTHER_DOWNLOAD_DIALOG", 5, "OTHER_DOWNLOAD_DIALOG");
    public static final MemberSource SOURCE_AD = new MemberSource("SOURCE_AD", 6, "SOURCE_AD");
    public static final MemberSource THREE_IN_ONE_POPUP = new MemberSource("THREE_IN_ONE_POPUP", 7, "THREE_IN_ONE_POPUP");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_DIALOG = new MemberSource("SOURCE_STREAM_RESOLUTION_DIALOG", 8, "STREAM_RESOLUTION_DIALOG");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_TIP = new MemberSource("SOURCE_STREAM_RESOLUTION_TIP", 9, "STREAM_RESOLUTION_TIP");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR = new MemberSource("SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR", 10, "SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG = new MemberSource("SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG", 11, "SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG");
    public static final MemberSource SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT = new MemberSource("SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT", 12, "SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT");

    /* renamed from: com.transsion.memberapi.MemberSource$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final MemberSource a(String str) {
            Intrinsics.h(str, "value");
            switch (str.hashCode()) {
                case -1829735462:
                    if (str.equals("THREE_IN_ONE_POPUP")) {
                        return MemberSource.THREE_IN_ONE_POPUP;
                    }
                    break;
                case -440595233:
                    if (str.equals("DOWNLOAD_DIALOG")) {
                        return MemberSource.SOURCE_DOWNLOAD_DIALOG;
                    }
                    break;
                case -420306344:
                    if (str.equals("LANDSCAPE_PLAY")) {
                        return MemberSource.SOURCE_LANDSCAPE_PLAY;
                    }
                    break;
                case -292643118:
                    if (str.equals("SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR")) {
                        return MemberSource.SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR;
                    }
                    break;
                case -63224452:
                    if (str.equals("SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG")) {
                        return MemberSource.SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG;
                    }
                    break;
                case 2212484:
                    if (str.equals("HDDL")) {
                        return MemberSource.SOURCE_HDDL;
                    }
                    break;
                case 30702908:
                    if (str.equals("STREAM_RESOLUTION_DIALOG")) {
                        return MemberSource.SOURCE_STREAM_RESOLUTION_DIALOG;
                    }
                    break;
                case 148144095:
                    if (str.equals("SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT")) {
                        return MemberSource.SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT;
                    }
                    break;
                case 684919184:
                    if (str.equals("OTHER_DOWNLOAD_DIALOG")) {
                        return MemberSource.SOURCE_OTHER_DOWNLOAD_DIALOG;
                    }
                    break;
                case 702700807:
                    if (str.equals("STREAM_RESOLUTION_TIP")) {
                        return MemberSource.SOURCE_STREAM_RESOLUTION_TIP;
                    }
                    break;
                case 1088214727:
                    if (str.equals("SOURCE_AD")) {
                        return MemberSource.SOURCE_AD;
                    }
                    break;
                case 1456277732:
                    if (str.equals("AD_DIALOG")) {
                        return MemberSource.SOURCE_AD_DIALOG;
                    }
                    break;
                case 1758712121:
                    if (str.equals("Multi_DL_DIALOG")) {
                        return MemberSource.SOURCE_MULTI_DL;
                    }
                    break;
            }
            throw new IllegalArgumentException();
        }
    }

    private static final /* synthetic */ MemberSource[] $values() {
        return new MemberSource[]{SOURCE_HDDL, SOURCE_MULTI_DL, SOURCE_AD_DIALOG, SOURCE_DOWNLOAD_DIALOG, SOURCE_LANDSCAPE_PLAY, SOURCE_OTHER_DOWNLOAD_DIALOG, SOURCE_AD, THREE_IN_ONE_POPUP, SOURCE_STREAM_RESOLUTION_DIALOG, SOURCE_STREAM_RESOLUTION_TIP, SOURCE_STREAM_RESOLUTION_START_PLAY_ERROR, SOURCE_STREAM_RESOLUTION_ACTIVATE_DIALOG, SOURCE_STREAM_RESOLUTION_ACTIVATE_DOWNLOAD_INTERCEPT};
    }

    static {
        MemberSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
        INSTANCE = new Companion(null);
        CREATOR = new Parcelable.Creator() { // from class: com.transsion.memberapi.MemberSource.b
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MemberSource createFromParcel(Parcel parcel) {
                Intrinsics.h(parcel, "parcel");
                return MemberSource.valueOf(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MemberSource[] newArray(int i) {
                return new MemberSource[i];
            }
        };
    }

    private MemberSource(String str, int i, String str2) {
        this.value = str2;
    }

    public static EnumEntries<MemberSource> getEntries() {
        return $ENTRIES;
    }

    public static MemberSource valueOf(String str) {
        return (MemberSource) Enum.valueOf(MemberSource.class, str);
    }

    public static MemberSource[] values() {
        return (MemberSource[]) $VALUES.clone();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(name());
    }
}
