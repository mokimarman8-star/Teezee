package com.transsion.shorttv_pugc.bean;

import androidx.annotation.Keep;
import androidx.collection.s;
import androidx.compose.foundation.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okio.internal.Buffer;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\bb\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u000bHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0006HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00105J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010>J\t\u0010f\u001a\u00020\u0014HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0006HÆ\u0003J\u0010\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00105J\u0010\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00105J\t\u0010m\u001a\u00020\u0014HÆ\u0003J\t\u0010n\u001a\u00020\u0014HÆ\u0003J\t\u0010o\u001a\u00020\u0014HÆ\u0003J\u009a\u0002\u0010p\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u0014HÆ\u0001¢\u0006\u0002\u0010qJ\u0013\u0010r\u001a\u00020\u00142\b\u0010s\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010t\u001a\u00020\u000bHÖ\u0001J\t\u0010u\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010!\"\u0004\b2\u00103R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010!\"\u0004\b<\u00103R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010!\"\u0004\bG\u00103R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010!\"\u0004\bI\u00103R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010!\"\u0004\bK\u00103R\u001a\u0010\u0018\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010$\"\u0004\bM\u0010&R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u00108\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R\u001a\u0010\u001b\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010C\"\u0004\bS\u0010ER\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010C\"\u0004\bU\u0010ER\u001a\u0010\u001d\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010C\"\u0004\bW\u0010E¨\u0006v"}, d2 = {"Lcom/transsion/shorttv_pugc/bean/ShortTvInnerPlayBean;", HttpUrl.FRAGMENT_ENCODE_SET, "collectionId", HttpUrl.FRAGMENT_ENCODE_SET, "ugcVideoId", "progress", HttpUrl.FRAGMENT_ENCODE_SET, "title", "coverUrl", "thumbnail", "position", HttpUrl.FRAGMENT_ENCODE_SET, "type", "timeStamp", "subtitleSelectId", "totalDuration", "subjectDurationSeconds", "averageHueLight", "subjectType", "hasDelete", HttpUrl.FRAGMENT_ENCODE_SET, "downloadUrl", "downloadResid", "downloadFilePath", "downloadSize", "lastAdStartTimeStamp", "lastAdEndTimeStamp", "rewardPlayed", "rewardUnlock", "rewardFree", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;ZZZ)V", "getCollectionId", "()Ljava/lang/String;", "getUgcVideoId", "getProgress", "()J", "setProgress", "(J)V", "getTitle", "getCoverUrl", "getThumbnail", "getPosition", "()I", "setPosition", "(I)V", "getType", "getTimeStamp", "setTimeStamp", "getSubtitleSelectId", "setSubtitleSelectId", "(Ljava/lang/String;)V", "getTotalDuration", "()Ljava/lang/Long;", "setTotalDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSubjectDurationSeconds", "setSubjectDurationSeconds", "getAverageHueLight", "setAverageHueLight", "getSubjectType", "()Ljava/lang/Integer;", "setSubjectType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHasDelete", "()Z", "setHasDelete", "(Z)V", "getDownloadUrl", "setDownloadUrl", "getDownloadResid", "setDownloadResid", "getDownloadFilePath", "setDownloadFilePath", "getDownloadSize", "setDownloadSize", "getLastAdStartTimeStamp", "setLastAdStartTimeStamp", "getLastAdEndTimeStamp", "setLastAdEndTimeStamp", "getRewardPlayed", "setRewardPlayed", "getRewardUnlock", "setRewardUnlock", "getRewardFree", "setRewardFree", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;ZZZ)Lcom/transsion/shorttv_pugc/bean/ShortTvInnerPlayBean;", "equals", "other", "hashCode", "toString", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class ShortTvInnerPlayBean {
    private String averageHueLight;
    private final String collectionId;
    private final String coverUrl;
    private String downloadFilePath;
    private String downloadResid;
    private long downloadSize;
    private String downloadUrl;
    private boolean hasDelete;
    private Long lastAdEndTimeStamp;
    private Long lastAdStartTimeStamp;
    private int position;
    private long progress;
    private boolean rewardFree;
    private boolean rewardPlayed;
    private boolean rewardUnlock;
    private Long subjectDurationSeconds;
    private Integer subjectType;
    private String subtitleSelectId;
    private final String thumbnail;
    private long timeStamp;
    private final String title;
    private Long totalDuration;
    private final String type;
    private final String ugcVideoId;

    public ShortTvInnerPlayBean(String collectionId, String ugcVideoId, long j, String str, String str2, String str3, int i, String str4, long j2, String str5, Long l, Long l2, String str6, Integer num, boolean z, String str7, String str8, String str9, long j3, Long l3, Long l4, boolean z2, boolean z3, boolean z4) {
        Intrinsics.h(collectionId, "collectionId");
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        this.collectionId = collectionId;
        this.ugcVideoId = ugcVideoId;
        this.progress = j;
        this.title = str;
        this.coverUrl = str2;
        this.thumbnail = str3;
        this.position = i;
        this.type = str4;
        this.timeStamp = j2;
        this.subtitleSelectId = str5;
        this.totalDuration = l;
        this.subjectDurationSeconds = l2;
        this.averageHueLight = str6;
        this.subjectType = num;
        this.hasDelete = z;
        this.downloadUrl = str7;
        this.downloadResid = str8;
        this.downloadFilePath = str9;
        this.downloadSize = j3;
        this.lastAdStartTimeStamp = l3;
        this.lastAdEndTimeStamp = l4;
        this.rewardPlayed = z2;
        this.rewardUnlock = z3;
        this.rewardFree = z4;
    }

    public /* synthetic */ ShortTvInnerPlayBean(String str, String str2, long j, String str3, String str4, String str5, int i, String str6, long j2, String str7, Long l, Long l2, String str8, Integer num, boolean z, String str9, String str10, String str11, long j3, Long l3, Long l4, boolean z2, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? 0L : j2, (i2 & 512) != 0 ? null : str7, (i2 & 1024) != 0 ? 0L : l, (i2 & 2048) != 0 ? 0L : l2, (i2 & Buffer.SEGMENTING_THRESHOLD) != 0 ? null : str8, (i2 & 8192) != 0 ? 1 : num, (i2 & 16384) != 0 ? false : z, (32768 & i2) != 0 ? null : str9, (65536 & i2) != 0 ? null : str10, (131072 & i2) != 0 ? null : str11, (262144 & i2) != 0 ? 0L : j3, (524288 & i2) != 0 ? null : l3, (1048576 & i2) != 0 ? null : l4, (2097152 & i2) != 0 ? false : z2, (4194304 & i2) != 0 ? false : z3, (i2 & 8388608) != 0 ? false : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getTotalDuration() {
        return this.totalDuration;
    }

    /* renamed from: component12, reason: from getter */
    public final Long getSubjectDurationSeconds() {
        return this.subjectDurationSeconds;
    }

    /* renamed from: component13, reason: from getter */
    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getSubjectType() {
        return this.subjectType;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getHasDelete() {
        return this.hasDelete;
    }

    /* renamed from: component16, reason: from getter */
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    /* renamed from: component17, reason: from getter */
    public final String getDownloadResid() {
        return this.downloadResid;
    }

    /* renamed from: component18, reason: from getter */
    public final String getDownloadFilePath() {
        return this.downloadFilePath;
    }

    /* renamed from: component19, reason: from getter */
    public final long getDownloadSize() {
        return this.downloadSize;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUgcVideoId() {
        return this.ugcVideoId;
    }

    /* renamed from: component20, reason: from getter */
    public final Long getLastAdStartTimeStamp() {
        return this.lastAdStartTimeStamp;
    }

    /* renamed from: component21, reason: from getter */
    public final Long getLastAdEndTimeStamp() {
        return this.lastAdEndTimeStamp;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getRewardPlayed() {
        return this.rewardPlayed;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getRewardUnlock() {
        return this.rewardUnlock;
    }

    /* renamed from: component24, reason: from getter */
    public final boolean getRewardFree() {
        return this.rewardFree;
    }

    /* renamed from: component3, reason: from getter */
    public final long getProgress() {
        return this.progress;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: component8, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component9, reason: from getter */
    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final ShortTvInnerPlayBean copy(String collectionId, String ugcVideoId, long progress, String title, String coverUrl, String thumbnail, int position, String type, long timeStamp, String subtitleSelectId, Long totalDuration, Long subjectDurationSeconds, String averageHueLight, Integer subjectType, boolean hasDelete, String downloadUrl, String downloadResid, String downloadFilePath, long downloadSize, Long lastAdStartTimeStamp, Long lastAdEndTimeStamp, boolean rewardPlayed, boolean rewardUnlock, boolean rewardFree) {
        Intrinsics.h(collectionId, "collectionId");
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        return new ShortTvInnerPlayBean(collectionId, ugcVideoId, progress, title, coverUrl, thumbnail, position, type, timeStamp, subtitleSelectId, totalDuration, subjectDurationSeconds, averageHueLight, subjectType, hasDelete, downloadUrl, downloadResid, downloadFilePath, downloadSize, lastAdStartTimeStamp, lastAdEndTimeStamp, rewardPlayed, rewardUnlock, rewardFree);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShortTvInnerPlayBean)) {
            return false;
        }
        ShortTvInnerPlayBean shortTvInnerPlayBean = (ShortTvInnerPlayBean) other;
        return Intrinsics.c(this.collectionId, shortTvInnerPlayBean.collectionId) && Intrinsics.c(this.ugcVideoId, shortTvInnerPlayBean.ugcVideoId) && this.progress == shortTvInnerPlayBean.progress && Intrinsics.c(this.title, shortTvInnerPlayBean.title) && Intrinsics.c(this.coverUrl, shortTvInnerPlayBean.coverUrl) && Intrinsics.c(this.thumbnail, shortTvInnerPlayBean.thumbnail) && this.position == shortTvInnerPlayBean.position && Intrinsics.c(this.type, shortTvInnerPlayBean.type) && this.timeStamp == shortTvInnerPlayBean.timeStamp && Intrinsics.c(this.subtitleSelectId, shortTvInnerPlayBean.subtitleSelectId) && Intrinsics.c(this.totalDuration, shortTvInnerPlayBean.totalDuration) && Intrinsics.c(this.subjectDurationSeconds, shortTvInnerPlayBean.subjectDurationSeconds) && Intrinsics.c(this.averageHueLight, shortTvInnerPlayBean.averageHueLight) && Intrinsics.c(this.subjectType, shortTvInnerPlayBean.subjectType) && this.hasDelete == shortTvInnerPlayBean.hasDelete && Intrinsics.c(this.downloadUrl, shortTvInnerPlayBean.downloadUrl) && Intrinsics.c(this.downloadResid, shortTvInnerPlayBean.downloadResid) && Intrinsics.c(this.downloadFilePath, shortTvInnerPlayBean.downloadFilePath) && this.downloadSize == shortTvInnerPlayBean.downloadSize && Intrinsics.c(this.lastAdStartTimeStamp, shortTvInnerPlayBean.lastAdStartTimeStamp) && Intrinsics.c(this.lastAdEndTimeStamp, shortTvInnerPlayBean.lastAdEndTimeStamp) && this.rewardPlayed == shortTvInnerPlayBean.rewardPlayed && this.rewardUnlock == shortTvInnerPlayBean.rewardUnlock && this.rewardFree == shortTvInnerPlayBean.rewardFree;
    }

    public final String getAverageHueLight() {
        return this.averageHueLight;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final String getDownloadFilePath() {
        return this.downloadFilePath;
    }

    public final String getDownloadResid() {
        return this.downloadResid;
    }

    public final long getDownloadSize() {
        return this.downloadSize;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final boolean getHasDelete() {
        return this.hasDelete;
    }

    public final Long getLastAdEndTimeStamp() {
        return this.lastAdEndTimeStamp;
    }

    public final Long getLastAdStartTimeStamp() {
        return this.lastAdStartTimeStamp;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final boolean getRewardFree() {
        return this.rewardFree;
    }

    public final boolean getRewardPlayed() {
        return this.rewardPlayed;
    }

    public final boolean getRewardUnlock() {
        return this.rewardUnlock;
    }

    public final Long getSubjectDurationSeconds() {
        return this.subjectDurationSeconds;
    }

    public final Integer getSubjectType() {
        return this.subjectType;
    }

    public final String getSubtitleSelectId() {
        return this.subtitleSelectId;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getTotalDuration() {
        return this.totalDuration;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUgcVideoId() {
        return this.ugcVideoId;
    }

    public int hashCode() {
        int hashCode = ((((this.collectionId.hashCode() * 31) + this.ugcVideoId.hashCode()) * 31) + s.a(this.progress)) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.coverUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.thumbnail;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.position) * 31;
        String str4 = this.type;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + s.a(this.timeStamp)) * 31;
        String str5 = this.subtitleSelectId;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l = this.totalDuration;
        int hashCode7 = (hashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.subjectDurationSeconds;
        int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str6 = this.averageHueLight;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num = this.subjectType;
        int hashCode10 = (((hashCode9 + (num == null ? 0 : num.hashCode())) * 31) + e.a(this.hasDelete)) * 31;
        String str7 = this.downloadUrl;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.downloadResid;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.downloadFilePath;
        int hashCode13 = (((hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31) + s.a(this.downloadSize)) * 31;
        Long l3 = this.lastAdStartTimeStamp;
        int hashCode14 = (hashCode13 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.lastAdEndTimeStamp;
        return ((((((hashCode14 + (l4 != null ? l4.hashCode() : 0)) * 31) + e.a(this.rewardPlayed)) * 31) + e.a(this.rewardUnlock)) * 31) + e.a(this.rewardFree);
    }

    public final void setAverageHueLight(String str) {
        this.averageHueLight = str;
    }

    public final void setDownloadFilePath(String str) {
        this.downloadFilePath = str;
    }

    public final void setDownloadResid(String str) {
        this.downloadResid = str;
    }

    public final void setDownloadSize(long j) {
        this.downloadSize = j;
    }

    public final void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public final void setHasDelete(boolean z) {
        this.hasDelete = z;
    }

    public final void setLastAdEndTimeStamp(Long l) {
        this.lastAdEndTimeStamp = l;
    }

    public final void setLastAdStartTimeStamp(Long l) {
        this.lastAdStartTimeStamp = l;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setProgress(long j) {
        this.progress = j;
    }

    public final void setRewardFree(boolean z) {
        this.rewardFree = z;
    }

    public final void setRewardPlayed(boolean z) {
        this.rewardPlayed = z;
    }

    public final void setRewardUnlock(boolean z) {
        this.rewardUnlock = z;
    }

    public final void setSubjectDurationSeconds(Long l) {
        this.subjectDurationSeconds = l;
    }

    public final void setSubjectType(Integer num) {
        this.subjectType = num;
    }

    public final void setSubtitleSelectId(String str) {
        this.subtitleSelectId = str;
    }

    public final void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public final void setTotalDuration(Long l) {
        this.totalDuration = l;
    }

    public String toString() {
        return "ShortTvInnerPlayBean(collectionId=" + this.collectionId + ", ugcVideoId=" + this.ugcVideoId + ", progress=" + this.progress + ", title=" + this.title + ", coverUrl=" + this.coverUrl + ", thumbnail=" + this.thumbnail + ", position=" + this.position + ", type=" + this.type + ", timeStamp=" + this.timeStamp + ", subtitleSelectId=" + this.subtitleSelectId + ", totalDuration=" + this.totalDuration + ", subjectDurationSeconds=" + this.subjectDurationSeconds + ", averageHueLight=" + this.averageHueLight + ", subjectType=" + this.subjectType + ", hasDelete=" + this.hasDelete + ", downloadUrl=" + this.downloadUrl + ", downloadResid=" + this.downloadResid + ", downloadFilePath=" + this.downloadFilePath + ", downloadSize=" + this.downloadSize + ", lastAdStartTimeStamp=" + this.lastAdStartTimeStamp + ", lastAdEndTimeStamp=" + this.lastAdEndTimeStamp + ", rewardPlayed=" + this.rewardPlayed + ", rewardUnlock=" + this.rewardUnlock + ", rewardFree=" + this.rewardFree + ")";
    }
}
