package com.transsion.baselib.db.audio;

import androidx.annotation.Keep;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b:\b\u0087\b\u0018\u0000 q2\u00020\u0001:\u0001rBã\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001cJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001cJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0012\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b&\u0010\u001fJ\u0012\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b'\u0010\u001fJ\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u001cJ\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u001cJ\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\u001cJ\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u001cJ\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u001cJ\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u001cJ\u0010\u0010.\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u001cJ\u0010\u00101\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b1\u0010/J\u0010\u00102\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b2\u0010/Jø\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b5\u0010\u001cJ\u0010\u00106\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b6\u0010/J\u001a\u0010:\u001a\u0002092\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010\u001c\"\u0004\b>\u0010?R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010<\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010?R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010B\u001a\u0004\bC\u0010\u001f\"\u0004\bD\u0010ER$\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010B\u001a\u0004\bF\u0010\u001f\"\u0004\bG\u0010ER$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010<\u001a\u0004\bH\u0010\u001c\"\u0004\bI\u0010?R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010<\u001a\u0004\bJ\u0010\u001c\"\u0004\bK\u0010?R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010<\u001a\u0004\bL\u0010\u001c\"\u0004\bM\u0010?R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010N\u001a\u0004\bO\u0010%\"\u0004\bP\u0010QR$\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010B\u001a\u0004\bR\u0010\u001f\"\u0004\bS\u0010ER$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010B\u001a\u0004\bT\u0010\u001f\"\u0004\bU\u0010ER$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010<\u001a\u0004\bV\u0010\u001c\"\u0004\bW\u0010?R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010<\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010?R$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010<\u001a\u0004\bZ\u0010\u001c\"\u0004\b[\u0010?R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010<\u001a\u0004\b\\\u0010\u001c\"\u0004\b]\u0010?R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010<\u001a\u0004\b^\u0010\u001c\"\u0004\b_\u0010?R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010<\u001a\u0004\b`\u0010\u001c\"\u0004\ba\u0010?R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010b\u001a\u0004\bc\u0010/\"\u0004\bd\u0010eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010<\u001a\u0004\bf\u0010\u001c\"\u0004\bg\u0010?R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010b\u001a\u0004\bh\u0010/\"\u0004\bi\u0010eR\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010b\u001a\u0004\bj\u0010/\"\u0004\bk\u0010eR\"\u0010l\u001a\u0002098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bl\u0010n\"\u0004\bo\u0010p¨\u0006s"}, d2 = {"Lcom/transsion/baselib/db/audio/AudioBean;", "Ljava/io/Serializable;", "", "audioUrl", "cover", "", "duration", "size", "url", "title", "desc", "", "bitrate", "updateTimeStamp", "readProcess", "localPath", "ops", "resourceId", "postId", "subjectId", "groupId", "status", "subjectTitle", "se", "ep", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/lang/Long;", "component4", "component5", "component6", "component7", "component8", "()Ljava/lang/Integer;", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "()I", "component18", "component19", "component20", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)Lcom/transsion/baselib/db/audio/AudioBean;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAudioUrl", "setAudioUrl", "(Ljava/lang/String;)V", "getCover", "setCover", "Ljava/lang/Long;", "getDuration", "setDuration", "(Ljava/lang/Long;)V", "getSize", "setSize", "getUrl", "setUrl", "getTitle", "setTitle", "getDesc", "setDesc", "Ljava/lang/Integer;", "getBitrate", "setBitrate", "(Ljava/lang/Integer;)V", "getUpdateTimeStamp", "setUpdateTimeStamp", "getReadProcess", "setReadProcess", "getLocalPath", "setLocalPath", "getOps", "setOps", "getResourceId", "setResourceId", "getPostId", "setPostId", "getSubjectId", "setSubjectId", "getGroupId", "setGroupId", "I", "getStatus", "setStatus", "(I)V", "getSubjectTitle", "setSubjectTitle", "getSe", "setSe", "getEp", "setEp", "isChangeToLocalPath", "Z", "()Z", "setChangeToLocalPath", "(Z)V", "Companion", "a", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final /* data */ class AudioBean implements Serializable {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final int STATUS_ERROR = 7;
    public static final int STATUS_FINISHED = 6;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_NO_OPEN = 1;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_PLAYING = 3;
    private String audioUrl;
    private Integer bitrate;
    private String cover;
    private String desc;
    private Long duration;
    private int ep;
    private String groupId;
    private boolean isChangeToLocalPath;
    private String localPath;
    private String ops;
    private String postId;
    private Long readProcess;
    private String resourceId;
    private int se;
    private Long size;
    private int status;
    private String subjectId;
    private String subjectTitle;
    private String title;
    private Long updateTimeStamp;
    private String url;

    public AudioBean(String str, String str2, Long l, Long l2, String str3, String str4, String str5, Integer num, Long l3, Long l4, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12, int i2, int i3) {
        Intrinsics.h(str, "audioUrl");
        this.audioUrl = str;
        this.cover = str2;
        this.duration = l;
        this.size = l2;
        this.url = str3;
        this.title = str4;
        this.desc = str5;
        this.bitrate = num;
        this.updateTimeStamp = l3;
        this.readProcess = l4;
        this.localPath = str6;
        this.ops = str7;
        this.resourceId = str8;
        this.postId = str9;
        this.subjectId = str10;
        this.groupId = str11;
        this.status = i;
        this.subjectTitle = str12;
        this.se = i2;
        this.ep = i3;
    }

    public /* synthetic */ AudioBean(String str, String str2, Long l, Long l2, String str3, String str4, String str5, Integer num, Long l3, Long l4, String str6, String str7, String str8, String str9, String str10, String str11, int i, String str12, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, l, l2, str3, str4, (i4 & 64) != 0 ? "" : str5, (i4 & ASTNode.ASSIGN) != 0 ? 0 : num, (i4 & ASTNode.COLLECTION) != 0 ? 0L : l3, (i4 & ASTNode.THISREF) != 0 ? 0L : l4, (i4 & 1024) != 0 ? "" : str6, (i4 & ASTNode.BLOCK_IF) != 0 ? "" : str7, (i4 & 4096) != 0 ? "" : str8, (i4 & 8192) != 0 ? "" : str9, (i4 & ASTNode.BLOCK_UNTIL) != 0 ? "" : str10, (32768 & i4) != 0 ? "" : str11, (65536 & i4) != 0 ? 1 : i, (131072 & i4) != 0 ? "" : str12, (262144 & i4) != 0 ? 0 : i2, (i4 & ASTNode.OPT_SUBTR) != 0 ? 0 : i3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAudioUrl() {
        return this.audioUrl;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getReadProcess() {
        return this.readProcess;
    }

    /* renamed from: component11, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: component12, reason: from getter */
    public final String getOps() {
        return this.ops;
    }

    /* renamed from: component13, reason: from getter */
    public final String getResourceId() {
        return this.resourceId;
    }

    /* renamed from: component14, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component16, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component17, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component18, reason: from getter */
    public final String getSubjectTitle() {
        return this.subjectTitle;
    }

    /* renamed from: component19, reason: from getter */
    public final int getSe() {
        return this.se;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCover() {
        return this.cover;
    }

    /* renamed from: component20, reason: from getter */
    public final int getEp() {
        return this.ep;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final AudioBean copy(String audioUrl, String cover, Long duration, Long size, String url, String title, String desc, Integer bitrate, Long updateTimeStamp, Long readProcess, String localPath, String ops, String resourceId, String postId, String subjectId, String groupId, int status, String subjectTitle, int se, int ep2) {
        Intrinsics.h(audioUrl, "audioUrl");
        return new AudioBean(audioUrl, cover, duration, size, url, title, desc, bitrate, updateTimeStamp, readProcess, localPath, ops, resourceId, postId, subjectId, groupId, status, subjectTitle, se, ep2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudioBean)) {
            return false;
        }
        AudioBean audioBean = (AudioBean) other;
        return Intrinsics.c(this.audioUrl, audioBean.audioUrl) && Intrinsics.c(this.cover, audioBean.cover) && Intrinsics.c(this.duration, audioBean.duration) && Intrinsics.c(this.size, audioBean.size) && Intrinsics.c(this.url, audioBean.url) && Intrinsics.c(this.title, audioBean.title) && Intrinsics.c(this.desc, audioBean.desc) && Intrinsics.c(this.bitrate, audioBean.bitrate) && Intrinsics.c(this.updateTimeStamp, audioBean.updateTimeStamp) && Intrinsics.c(this.readProcess, audioBean.readProcess) && Intrinsics.c(this.localPath, audioBean.localPath) && Intrinsics.c(this.ops, audioBean.ops) && Intrinsics.c(this.resourceId, audioBean.resourceId) && Intrinsics.c(this.postId, audioBean.postId) && Intrinsics.c(this.subjectId, audioBean.subjectId) && Intrinsics.c(this.groupId, audioBean.groupId) && this.status == audioBean.status && Intrinsics.c(this.subjectTitle, audioBean.subjectTitle) && this.se == audioBean.se && this.ep == audioBean.ep;
    }

    public final String getAudioUrl() {
        return this.audioUrl;
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final int getEp() {
        return this.ep;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getOps() {
        return this.ops;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final Long getReadProcess() {
        return this.readProcess;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final int getSe() {
        return this.se;
    }

    public final Long getSize() {
        return this.size;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final String getSubjectTitle() {
        return this.subjectTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getUpdateTimeStamp() {
        return this.updateTimeStamp;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = this.audioUrl.hashCode() * 31;
        String str = this.cover;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.duration;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.size;
        int hashCode4 = (hashCode3 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str2 = this.url;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.desc;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.bitrate;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Long l3 = this.updateTimeStamp;
        int hashCode9 = (hashCode8 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.readProcess;
        int hashCode10 = (hashCode9 + (l4 == null ? 0 : l4.hashCode())) * 31;
        String str5 = this.localPath;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.ops;
        int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.resourceId;
        int hashCode13 = (hashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.postId;
        int hashCode14 = (hashCode13 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.subjectId;
        int hashCode15 = (hashCode14 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.groupId;
        int hashCode16 = (((hashCode15 + (str10 == null ? 0 : str10.hashCode())) * 31) + this.status) * 31;
        String str11 = this.subjectTitle;
        return ((((hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31) + this.se) * 31) + this.ep;
    }

    /* renamed from: isChangeToLocalPath, reason: from getter */
    public final boolean getIsChangeToLocalPath() {
        return this.isChangeToLocalPath;
    }

    public final void setAudioUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.audioUrl = str;
    }

    public final void setBitrate(Integer num) {
        this.bitrate = num;
    }

    public final void setChangeToLocalPath(boolean z) {
        this.isChangeToLocalPath = z;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setDuration(Long l) {
        this.duration = l;
    }

    public final void setEp(int i) {
        this.ep = i;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setLocalPath(String str) {
        this.localPath = str;
    }

    public final void setOps(String str) {
        this.ops = str;
    }

    public final void setPostId(String str) {
        this.postId = str;
    }

    public final void setReadProcess(Long l) {
        this.readProcess = l;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final void setSe(int i) {
        this.se = i;
    }

    public final void setSize(Long l) {
        this.size = l;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setSubjectId(String str) {
        this.subjectId = str;
    }

    public final void setSubjectTitle(String str) {
        this.subjectTitle = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setUpdateTimeStamp(Long l) {
        this.updateTimeStamp = l;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public String toString() {
        return "AudioBean(audioUrl=" + this.audioUrl + ", cover=" + this.cover + ", duration=" + this.duration + ", size=" + this.size + ", url=" + this.url + ", title=" + this.title + ", desc=" + this.desc + ", bitrate=" + this.bitrate + ", updateTimeStamp=" + this.updateTimeStamp + ", readProcess=" + this.readProcess + ", localPath=" + this.localPath + ", ops=" + this.ops + ", resourceId=" + this.resourceId + ", postId=" + this.postId + ", subjectId=" + this.subjectId + ", groupId=" + this.groupId + ", status=" + this.status + ", subjectTitle=" + this.subjectTitle + ", se=" + this.se + ", ep=" + this.ep + ")";
    }
}
