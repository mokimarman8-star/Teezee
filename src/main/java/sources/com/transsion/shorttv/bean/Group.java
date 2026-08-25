package com.transsion.shorttv.bean;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b:\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010<\u001a\u00020\u000bJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0003J°\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u000b2\b\u0010M\u001a\u0004\u0018\u00010NHÖ\u0003J\t\u0010O\u001a\u00020PHÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010\u0019R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006R"}, d2 = {"Lcom/transsion/shorttv/bean/Group;", "Ljava/io/Serializable;", "avatar", BuildConfig.FLAVOR, "groupId", "name", "userCount", BuildConfig.FLAVOR, "postCount", "level", "hasJoin", BuildConfig.FLAVOR, "desc", "avatarAverageHueLight", "avatarAverageHueDark", "newPostCount", "cover", "Lcom/transsion/shorttv/bean/Cover;", "tags", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/shorttv/bean/Cover;Ljava/util/List;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getGroupId", "setGroupId", "getName", "setName", "getUserCount", "()Ljava/lang/Long;", "setUserCount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getPostCount", "setPostCount", "getLevel", "setLevel", "getHasJoin", "()Ljava/lang/Boolean;", "setHasJoin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDesc", "setDesc", "getAvatarAverageHueLight", "setAvatarAverageHueLight", "getAvatarAverageHueDark", "setAvatarAverageHueDark", "getNewPostCount", "setNewPostCount", "getCover", "()Lcom/transsion/shorttv/bean/Cover;", "setCover", "(Lcom/transsion/shorttv/bean/Cover;)V", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "showAdultRestricted", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/shorttv/bean/Cover;Ljava/util/List;)Lcom/transsion/shorttv/bean/Group;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class Group implements Serializable {

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("avatarAverageHueDark")
    private String avatarAverageHueDark;

    @SerializedName("avatarAverageHueLight")
    private String avatarAverageHueLight;

    @SerializedName("cover")
    private Cover cover;

    @SerializedName("description")
    private String desc;

    @SerializedName("groupId")
    private String groupId;

    @SerializedName("hasJoin")
    private Boolean hasJoin;

    @SerializedName("level")
    private String level;

    @SerializedName("name")
    private String name;

    @SerializedName("newPostCount")
    private String newPostCount;

    @SerializedName("postCount")
    private Long postCount;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("userCount")
    private Long userCount;

    public Group(String str, String str2, String str3, Long l, Long l2, String str4, Boolean bool, String str5, String str6, String str7, String str8, Cover cover, List<String> list) {
        this.avatar = str;
        this.groupId = str2;
        this.name = str3;
        this.userCount = l;
        this.postCount = l2;
        this.level = str4;
        this.hasJoin = bool;
        this.desc = str5;
        this.avatarAverageHueLight = str6;
        this.avatarAverageHueDark = str7;
        this.newPostCount = str8;
        this.cover = cover;
        this.tags = list;
    }

    /* renamed from: component1, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component10, reason: from getter */
    public final String getAvatarAverageHueDark() {
        return this.avatarAverageHueDark;
    }

    /* renamed from: component11, reason: from getter */
    public final String getNewPostCount() {
        return this.newPostCount;
    }

    /* renamed from: component12, reason: from getter */
    public final Cover getCover() {
        return this.cover;
    }

    public final List<String> component13() {
        return this.tags;
    }

    /* renamed from: component2, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getUserCount() {
        return this.userCount;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getPostCount() {
        return this.postCount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getHasJoin() {
        return this.hasJoin;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAvatarAverageHueLight() {
        return this.avatarAverageHueLight;
    }

    public final Group copy(String avatar, String groupId, String name, Long userCount, Long postCount, String level, Boolean hasJoin, String desc, String avatarAverageHueLight, String avatarAverageHueDark, String newPostCount, Cover cover, List<String> tags) {
        return new Group(avatar, groupId, name, userCount, postCount, level, hasJoin, desc, avatarAverageHueLight, avatarAverageHueDark, newPostCount, cover, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Group)) {
            return false;
        }
        Group group = (Group) other;
        return Intrinsics.c(this.avatar, group.avatar) && Intrinsics.c(this.groupId, group.groupId) && Intrinsics.c(this.name, group.name) && Intrinsics.c(this.userCount, group.userCount) && Intrinsics.c(this.postCount, group.postCount) && Intrinsics.c(this.level, group.level) && Intrinsics.c(this.hasJoin, group.hasJoin) && Intrinsics.c(this.desc, group.desc) && Intrinsics.c(this.avatarAverageHueLight, group.avatarAverageHueLight) && Intrinsics.c(this.avatarAverageHueDark, group.avatarAverageHueDark) && Intrinsics.c(this.newPostCount, group.newPostCount) && Intrinsics.c(this.cover, group.cover) && Intrinsics.c(this.tags, group.tags);
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatarAverageHueDark() {
        return this.avatarAverageHueDark;
    }

    public final String getAvatarAverageHueLight() {
        return this.avatarAverageHueLight;
    }

    public final Cover getCover() {
        return this.cover;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Boolean getHasJoin() {
        return this.hasJoin;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNewPostCount() {
        return this.newPostCount;
    }

    public final Long getPostCount() {
        return this.postCount;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final Long getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.groupId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.userCount;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.postCount;
        int hashCode5 = (hashCode4 + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str4 = this.level;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.hasJoin;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.desc;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.avatarAverageHueLight;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.avatarAverageHueDark;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.newPostCount;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Cover cover = this.cover;
        int hashCode12 = (hashCode11 + (cover == null ? 0 : cover.hashCode())) * 31;
        List<String> list = this.tags;
        return hashCode12 + (list != null ? list.hashCode() : 0);
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setAvatarAverageHueDark(String str) {
        this.avatarAverageHueDark = str;
    }

    public final void setAvatarAverageHueLight(String str) {
        this.avatarAverageHueLight = str;
    }

    public final void setCover(Cover cover) {
        this.cover = cover;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setHasJoin(Boolean bool) {
        this.hasJoin = bool;
    }

    public final void setLevel(String str) {
        this.level = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setNewPostCount(String str) {
        this.newPostCount = str;
    }

    public final void setPostCount(Long l) {
        this.postCount = l;
    }

    public final void setTags(List<String> list) {
        this.tags = list;
    }

    public final void setUserCount(Long l) {
        this.userCount = l;
    }

    public final boolean showAdultRestricted() {
        return TextUtils.equals(this.level, "LIMIT");
    }

    public String toString() {
        return "Group(avatar=" + this.avatar + ", groupId=" + this.groupId + ", name=" + this.name + ", userCount=" + this.userCount + ", postCount=" + this.postCount + ", level=" + this.level + ", hasJoin=" + this.hasJoin + ", desc=" + this.desc + ", avatarAverageHueLight=" + this.avatarAverageHueLight + ", avatarAverageHueDark=" + this.avatarAverageHueDark + ", newPostCount=" + this.newPostCount + ", cover=" + this.cover + ", tags=" + this.tags + ")";
    }
}
