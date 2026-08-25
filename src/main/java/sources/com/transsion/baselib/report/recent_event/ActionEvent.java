package com.transsion.baselib.report.recent_event;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00012BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u000eJV\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0011J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u000eJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u000e\"\u0004\b!\u0010\"R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\"R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010(R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010(R\"\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010%\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010(R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\"R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u001f\u001a\u0004\b/\u0010\u000e\"\u0004\b0\u0010\"¨\u00063"}, d2 = {"Lcom/transsion/baselib/report/recent_event/ActionEvent;", "Ljava/io/Serializable;", "", "id", "source", "", "postId", "subjectId", "groupId", "playDuration", "playCount", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "component1", "()I", "component2", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/transsion/baselib/report/recent_event/ActionEvent;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getId", "setId", "(I)V", "getSource", "setSource", "Ljava/lang/String;", "getPostId", "setPostId", "(Ljava/lang/String;)V", "getSubjectId", "setSubjectId", "getGroupId", "setGroupId", "getPlayDuration", "setPlayDuration", "getPlayCount", "setPlayCount", "Companion", "a", "BaseLib_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final /* data */ class ActionEvent implements Serializable {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final int GroupList = 2;
    public static final int PostDetail = 4;
    public static final int SubjectList = 3;
    public static final int TrendingList = 1;
    public static final int UnknownSource = 0;
    public static final int checkin = 10;
    public static final int checkout = 11;
    public static final int comment = 13;
    public static final int coverclick = 1;
    public static final int create_post = 9;
    public static final int delete_comment = 14;
    public static final int dislike = 4;
    public static final int download = 12;
    public static final int download_subject = 21;
    public static final int i_have_seen = 6;
    public static final int like = 3;
    public static final int pageview = 15;
    public static final int rankscore = 7;
    public static final int search_cover_click = 20;
    public static final int search_cover_expose = 19;
    public static final int share = 8;
    public static final int unknow = 0;
    public static final int view = 2;
    public static final int want_to_see = 5;
    public static final int want_to_see_cancel = 17;
    private String groupId;
    private int id;
    private int playCount;
    private int playDuration;
    private String postId;
    private int source;
    private String subjectId;

    public ActionEvent(int i, int i2, String str, String str2, String str3, int i3, int i4) {
        Intrinsics.h(str, "postId");
        Intrinsics.h(str2, "subjectId");
        Intrinsics.h(str3, "groupId");
        this.id = i;
        this.source = i2;
        this.postId = str;
        this.subjectId = str2;
        this.groupId = str3;
        this.playDuration = i3;
        this.playCount = i4;
    }

    public /* synthetic */ ActionEvent(int i, int i2, String str, String str2, String str3, int i3, int i4, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? "0" : str, (i6 & 8) != 0 ? "0" : str2, (i6 & 16) == 0 ? str3 : "0", (i6 & 32) != 0 ? 0 : i3, (i6 & 64) == 0 ? i4 : 0);
    }

    public static /* synthetic */ ActionEvent copy$default(ActionEvent actionEvent, int i, int i2, String str, String str2, String str3, int i3, int i4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = actionEvent.id;
        }
        if ((i6 & 2) != 0) {
            i2 = actionEvent.source;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            str = actionEvent.postId;
        }
        String str4 = str;
        if ((i6 & 8) != 0) {
            str2 = actionEvent.subjectId;
        }
        String str5 = str2;
        if ((i6 & 16) != 0) {
            str3 = actionEvent.groupId;
        }
        String str6 = str3;
        if ((i6 & 32) != 0) {
            i3 = actionEvent.playDuration;
        }
        int i8 = i3;
        if ((i6 & 64) != 0) {
            i4 = actionEvent.playCount;
        }
        return actionEvent.copy(i, i7, str4, str5, str6, i8, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPostId() {
        return this.postId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component6, reason: from getter */
    public final int getPlayDuration() {
        return this.playDuration;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPlayCount() {
        return this.playCount;
    }

    public final ActionEvent copy(int id, int source, String postId, String subjectId, String groupId, int playDuration, int playCount) {
        Intrinsics.h(postId, "postId");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(groupId, "groupId");
        return new ActionEvent(id, source, postId, subjectId, groupId, playDuration, playCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionEvent)) {
            return false;
        }
        ActionEvent actionEvent = (ActionEvent) other;
        return this.id == actionEvent.id && this.source == actionEvent.source && Intrinsics.c(this.postId, actionEvent.postId) && Intrinsics.c(this.subjectId, actionEvent.subjectId) && Intrinsics.c(this.groupId, actionEvent.groupId) && this.playDuration == actionEvent.playDuration && this.playCount == actionEvent.playCount;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPlayCount() {
        return this.playCount;
    }

    public final int getPlayDuration() {
        return this.playDuration;
    }

    public final String getPostId() {
        return this.postId;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public int hashCode() {
        return (((((((((((this.id * 31) + this.source) * 31) + this.postId.hashCode()) * 31) + this.subjectId.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.playDuration) * 31) + this.playCount;
    }

    public final void setGroupId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.groupId = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setPlayCount(int i) {
        this.playCount = i;
    }

    public final void setPlayDuration(int i) {
        this.playDuration = i;
    }

    public final void setPostId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.postId = str;
    }

    public final void setSource(int i) {
        this.source = i;
    }

    public final void setSubjectId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.subjectId = str;
    }

    public String toString() {
        return "ActionEvent(id=" + this.id + ", source=" + this.source + ", postId=" + this.postId + ", subjectId=" + this.subjectId + ", groupId=" + this.groupId + ", playDuration=" + this.playDuration + ", playCount=" + this.playCount + ")";
    }
}
