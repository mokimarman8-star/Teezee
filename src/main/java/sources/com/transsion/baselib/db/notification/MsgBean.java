package com.transsion.baselib.db.notification;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\bY\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010/J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010/J\t\u0010c\u001a\u00020\u0012HÆ\u0003J\t\u0010d\u001a\u00020\u0012HÆ\u0003J\t\u0010e\u001a\u00020\u0012HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003JÂ\u0001\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010hJ\u0006\u0010i\u001a\u00020\u0003J\u0013\u0010j\u001a\u00020\u00122\b\u0010k\u001a\u0004\u0018\u00010lHÖ\u0003J\t\u0010m\u001a\u00020\u0003HÖ\u0001J\t\u0010n\u001a\u00020\u0005HÖ\u0001J\u0016\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u0003R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR \u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b5\u0010/\"\u0004\b6\u00101R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R\u001e\u0010\u0014\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0019\"\u0004\b@\u0010\u001bR$\u0010A\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010C\u001a\u0004\bA\u00108\"\u0004\bD\u0010:R$\u0010E\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010C\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR$\u0010I\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010C\u001a\u0004\bK\u0010\u0019\"\u0004\bL\u0010\u001bR$\u0010M\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010C\u001a\u0004\bO\u0010\u0019\"\u0004\bP\u0010\u001bR$\u0010Q\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bR\u0010C\u001a\u0004\bQ\u00108\"\u0004\bS\u0010:R$\u0010T\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bU\u0010C\u001a\u0004\bT\u00108\"\u0004\bV\u0010:¨\u0006t"}, d2 = {"Lcom/transsion/baselib/db/notification/MsgBean;", "Landroid/os/Parcelable;", "id", BuildConfig.FLAVOR, "deeplink", BuildConfig.FLAVOR, "desc", "imageList", "messageId", "source", "style", "title", "type", "receiveTime", BuildConfig.FLAVOR, "msgStatus", "showTime", "forceShow", BuildConfig.FLAVOR, "hasScreenOn", "builtIn", "permanentMsgStatus", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/Long;ZZZI)V", "getId", "()I", "setId", "(I)V", "getDeeplink", "()Ljava/lang/String;", "setDeeplink", "(Ljava/lang/String;)V", "getDesc", "setDesc", "getImageList", "setImageList", "getMessageId", "setMessageId", "getSource", "setSource", "getStyle", "setStyle", "getTitle", "setTitle", "getType", "setType", "getReceiveTime", "()Ljava/lang/Long;", "setReceiveTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getMsgStatus", "setMsgStatus", "getShowTime", "setShowTime", "getForceShow", "()Z", "setForceShow", "(Z)V", "getHasScreenOn", "setHasScreenOn", "getBuiltIn", "setBuiltIn", "getPermanentMsgStatus", "setPermanentMsgStatus", "isPermanent", "isPermanent$annotations", "()V", "setPermanent", "triggerSource", "getTriggerSource$annotations", "getTriggerSource", "setTriggerSource", "permanentMsgPosition", "getPermanentMsgPosition$annotations", "getPermanentMsgPosition", "setPermanentMsgPosition", "permanentMsgSize", "getPermanentMsgSize$annotations", "getPermanentMsgSize", "setPermanentMsgSize", "isRefresh", "isRefresh$annotations", "setRefresh", "isFloat", "isFloat$annotations", "setFloat", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/Long;ZZZI)Lcom/transsion/baselib/db/notification/MsgBean;", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class MsgBean implements Parcelable {
    public static final Parcelable.Creator<MsgBean> CREATOR = new a();
    private boolean builtIn;
    private String deeplink;
    private String desc;
    private boolean forceShow;
    private boolean hasScreenOn;
    private int id;
    private String imageList;
    private boolean isFloat;
    private boolean isPermanent;
    private boolean isRefresh;
    private String messageId;
    private int msgStatus;
    private int permanentMsgPosition;
    private int permanentMsgSize;
    private int permanentMsgStatus;
    private Long receiveTime;
    private Long showTime;
    private String source;
    private String style;
    private String title;
    private int triggerSource;
    private String type;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MsgBean createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new MsgBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MsgBean[] newArray(int i) {
            return new MsgBean[i];
        }
    }

    public MsgBean() {
        this(0, null, null, null, null, null, null, null, null, null, 0, null, false, false, false, 0, 65535, null);
    }

    public MsgBean(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l, int i2, Long l2, boolean z, boolean z2, boolean z3, int i3) {
        this.id = i;
        this.deeplink = str;
        this.desc = str2;
        this.imageList = str3;
        this.messageId = str4;
        this.source = str5;
        this.style = str6;
        this.title = str7;
        this.type = str8;
        this.receiveTime = l;
        this.msgStatus = i2;
        this.showTime = l2;
        this.forceShow = z;
        this.hasScreenOn = z2;
        this.builtIn = z3;
        this.permanentMsgStatus = i3;
        this.permanentMsgPosition = 1;
        this.permanentMsgSize = 1;
    }

    public /* synthetic */ MsgBean(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Long l, int i2, Long l2, boolean z, boolean z2, boolean z3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? null : str5, (i4 & 64) != 0 ? null : str6, (i4 & 128) != 0 ? null : str7, (i4 & 256) == 0 ? str8 : null, (i4 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? 0L : l, (i4 & 1024) != 0 ? 0 : i2, (i4 & 2048) != 0 ? 0L : l2, (i4 & 4096) != 0 ? false : z, (i4 & 8192) != 0 ? false : z2, (i4 & 16384) != 0 ? false : z3, (i4 & 32768) != 0 ? 0 : i3);
    }

    public static /* synthetic */ void getPermanentMsgPosition$annotations() {
    }

    public static /* synthetic */ void getPermanentMsgSize$annotations() {
    }

    public static /* synthetic */ void getTriggerSource$annotations() {
    }

    public static /* synthetic */ void isFloat$annotations() {
    }

    public static /* synthetic */ void isPermanent$annotations() {
    }

    public static /* synthetic */ void isRefresh$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getReceiveTime() {
        return this.receiveTime;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMsgStatus() {
        return this.msgStatus;
    }

    /* renamed from: component12, reason: from getter */
    public final Long getShowTime() {
        return this.showTime;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getForceShow() {
        return this.forceShow;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getHasScreenOn() {
        return this.hasScreenOn;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    /* renamed from: component16, reason: from getter */
    public final int getPermanentMsgStatus() {
        return this.permanentMsgStatus;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeeplink() {
        return this.deeplink;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component4, reason: from getter */
    public final String getImageList() {
        return this.imageList;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStyle() {
        return this.style;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component9, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final MsgBean copy(int id, String deeplink, String desc, String imageList, String messageId, String source, String style, String title, String type, Long receiveTime, int msgStatus, Long showTime, boolean forceShow, boolean hasScreenOn, boolean builtIn, int permanentMsgStatus) {
        return new MsgBean(id, deeplink, desc, imageList, messageId, source, style, title, type, receiveTime, msgStatus, showTime, forceShow, hasScreenOn, builtIn, permanentMsgStatus);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgBean)) {
            return false;
        }
        MsgBean msgBean = (MsgBean) other;
        return this.id == msgBean.id && Intrinsics.c(this.deeplink, msgBean.deeplink) && Intrinsics.c(this.desc, msgBean.desc) && Intrinsics.c(this.imageList, msgBean.imageList) && Intrinsics.c(this.messageId, msgBean.messageId) && Intrinsics.c(this.source, msgBean.source) && Intrinsics.c(this.style, msgBean.style) && Intrinsics.c(this.title, msgBean.title) && Intrinsics.c(this.type, msgBean.type) && Intrinsics.c(this.receiveTime, msgBean.receiveTime) && this.msgStatus == msgBean.msgStatus && Intrinsics.c(this.showTime, msgBean.showTime) && this.forceShow == msgBean.forceShow && this.hasScreenOn == msgBean.hasScreenOn && this.builtIn == msgBean.builtIn && this.permanentMsgStatus == msgBean.permanentMsgStatus;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getForceShow() {
        return this.forceShow;
    }

    public final boolean getHasScreenOn() {
        return this.hasScreenOn;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImageList() {
        return this.imageList;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final int getMsgStatus() {
        return this.msgStatus;
    }

    public final int getPermanentMsgPosition() {
        return this.permanentMsgPosition;
    }

    public final int getPermanentMsgSize() {
        return this.permanentMsgSize;
    }

    public final int getPermanentMsgStatus() {
        return this.permanentMsgStatus;
    }

    public final Long getReceiveTime() {
        return this.receiveTime;
    }

    public final Long getShowTime() {
        return this.showTime;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStyle() {
        return this.style;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getTriggerSource() {
        return this.triggerSource;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.deeplink;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageList;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.messageId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.source;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.style;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.title;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.type;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l = this.receiveTime;
        int hashCode9 = (((hashCode8 + (l == null ? 0 : l.hashCode())) * 31) + this.msgStatus) * 31;
        Long l2 = this.showTime;
        return ((((((((hashCode9 + (l2 != null ? l2.hashCode() : 0)) * 31) + e.a(this.forceShow)) * 31) + e.a(this.hasScreenOn)) * 31) + e.a(this.builtIn)) * 31) + this.permanentMsgStatus;
    }

    /* renamed from: isFloat, reason: from getter */
    public final boolean getIsFloat() {
        return this.isFloat;
    }

    /* renamed from: isPermanent, reason: from getter */
    public final boolean getIsPermanent() {
        return this.isPermanent;
    }

    /* renamed from: isRefresh, reason: from getter */
    public final boolean getIsRefresh() {
        return this.isRefresh;
    }

    public final void setBuiltIn(boolean z) {
        this.builtIn = z;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setFloat(boolean z) {
        this.isFloat = z;
    }

    public final void setForceShow(boolean z) {
        this.forceShow = z;
    }

    public final void setHasScreenOn(boolean z) {
        this.hasScreenOn = z;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setImageList(String str) {
        this.imageList = str;
    }

    public final void setMessageId(String str) {
        this.messageId = str;
    }

    public final void setMsgStatus(int i) {
        this.msgStatus = i;
    }

    public final void setPermanent(boolean z) {
        this.isPermanent = z;
    }

    public final void setPermanentMsgPosition(int i) {
        this.permanentMsgPosition = i;
    }

    public final void setPermanentMsgSize(int i) {
        this.permanentMsgSize = i;
    }

    public final void setPermanentMsgStatus(int i) {
        this.permanentMsgStatus = i;
    }

    public final void setReceiveTime(Long l) {
        this.receiveTime = l;
    }

    public final void setRefresh(boolean z) {
        this.isRefresh = z;
    }

    public final void setShowTime(Long l) {
        this.showTime = l;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final void setStyle(String str) {
        this.style = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTriggerSource(int i) {
        this.triggerSource = i;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MsgBean(id=" + this.id + ", deeplink=" + this.deeplink + ", desc=" + this.desc + ", imageList=" + this.imageList + ", messageId=" + this.messageId + ", source=" + this.source + ", style=" + this.style + ", title=" + this.title + ", type=" + this.type + ", receiveTime=" + this.receiveTime + ", msgStatus=" + this.msgStatus + ", showTime=" + this.showTime + ", forceShow=" + this.forceShow + ", hasScreenOn=" + this.hasScreenOn + ", builtIn=" + this.builtIn + ", permanentMsgStatus=" + this.permanentMsgStatus + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeInt(this.id);
        dest.writeString(this.deeplink);
        dest.writeString(this.desc);
        dest.writeString(this.imageList);
        dest.writeString(this.messageId);
        dest.writeString(this.source);
        dest.writeString(this.style);
        dest.writeString(this.title);
        dest.writeString(this.type);
        Long l = this.receiveTime;
        if (l == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l.longValue());
        }
        dest.writeInt(this.msgStatus);
        Long l2 = this.showTime;
        if (l2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l2.longValue());
        }
        dest.writeInt(this.forceShow ? 1 : 0);
        dest.writeInt(this.hasScreenOn ? 1 : 0);
        dest.writeInt(this.builtIn ? 1 : 0);
        dest.writeInt(this.permanentMsgStatus);
    }
}
