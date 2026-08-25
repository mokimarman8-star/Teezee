package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006)"}, d2 = {"Lcom/transsion/push/bean/TeamMatchInfoMatch;", "Landroid/os/Parcelable;", "score", BuildConfig.FLAVOR, "crtRunsScored", "crtWicketsLost", "crtOvers", "crtOversExtraBalls", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScore", "()Ljava/lang/String;", "setScore", "(Ljava/lang/String;)V", "getCrtRunsScored", "setCrtRunsScored", "getCrtWicketsLost", "setCrtWicketsLost", "getCrtOvers", "setCrtOvers", "getCrtOversExtraBalls", "setCrtOversExtraBalls", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", BuildConfig.FLAVOR, "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class TeamMatchInfoMatch implements Parcelable {
    public static final Parcelable.Creator<TeamMatchInfoMatch> CREATOR = new Creator();
    private String crtOvers;
    private String crtOversExtraBalls;
    private String crtRunsScored;
    private String crtWicketsLost;
    private String score;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TeamMatchInfoMatch> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TeamMatchInfoMatch createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new TeamMatchInfoMatch(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TeamMatchInfoMatch[] newArray(int i) {
            return new TeamMatchInfoMatch[i];
        }
    }

    public TeamMatchInfoMatch() {
        this(null, null, null, null, null, 31, null);
    }

    public TeamMatchInfoMatch(String str, String str2, String str3, String str4, String str5) {
        this.score = str;
        this.crtRunsScored = str2;
        this.crtWicketsLost = str3;
        this.crtOvers = str4;
        this.crtOversExtraBalls = str5;
    }

    public /* synthetic */ TeamMatchInfoMatch(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public static /* synthetic */ TeamMatchInfoMatch copy$default(TeamMatchInfoMatch teamMatchInfoMatch, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = teamMatchInfoMatch.score;
        }
        if ((i & 2) != 0) {
            str2 = teamMatchInfoMatch.crtRunsScored;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = teamMatchInfoMatch.crtWicketsLost;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = teamMatchInfoMatch.crtOvers;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = teamMatchInfoMatch.crtOversExtraBalls;
        }
        return teamMatchInfoMatch.copy(str, str6, str7, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getScore() {
        return this.score;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCrtRunsScored() {
        return this.crtRunsScored;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCrtWicketsLost() {
        return this.crtWicketsLost;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCrtOvers() {
        return this.crtOvers;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCrtOversExtraBalls() {
        return this.crtOversExtraBalls;
    }

    public final TeamMatchInfoMatch copy(String score, String crtRunsScored, String crtWicketsLost, String crtOvers, String crtOversExtraBalls) {
        return new TeamMatchInfoMatch(score, crtRunsScored, crtWicketsLost, crtOvers, crtOversExtraBalls);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TeamMatchInfoMatch)) {
            return false;
        }
        TeamMatchInfoMatch teamMatchInfoMatch = (TeamMatchInfoMatch) other;
        return Intrinsics.c(this.score, teamMatchInfoMatch.score) && Intrinsics.c(this.crtRunsScored, teamMatchInfoMatch.crtRunsScored) && Intrinsics.c(this.crtWicketsLost, teamMatchInfoMatch.crtWicketsLost) && Intrinsics.c(this.crtOvers, teamMatchInfoMatch.crtOvers) && Intrinsics.c(this.crtOversExtraBalls, teamMatchInfoMatch.crtOversExtraBalls);
    }

    public final String getCrtOvers() {
        return this.crtOvers;
    }

    public final String getCrtOversExtraBalls() {
        return this.crtOversExtraBalls;
    }

    public final String getCrtRunsScored() {
        return this.crtRunsScored;
    }

    public final String getCrtWicketsLost() {
        return this.crtWicketsLost;
    }

    public final String getScore() {
        return this.score;
    }

    public int hashCode() {
        String str = this.score;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.crtRunsScored;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.crtWicketsLost;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.crtOvers;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.crtOversExtraBalls;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setCrtOvers(String str) {
        this.crtOvers = str;
    }

    public final void setCrtOversExtraBalls(String str) {
        this.crtOversExtraBalls = str;
    }

    public final void setCrtRunsScored(String str) {
        this.crtRunsScored = str;
    }

    public final void setCrtWicketsLost(String str) {
        this.crtWicketsLost = str;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public String toString() {
        return "TeamMatchInfoMatch(score=" + this.score + ", crtRunsScored=" + this.crtRunsScored + ", crtWicketsLost=" + this.crtWicketsLost + ", crtOvers=" + this.crtOvers + ", crtOversExtraBalls=" + this.crtOversExtraBalls + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.score);
        dest.writeString(this.crtRunsScored);
        dest.writeString(this.crtWicketsLost);
        dest.writeString(this.crtOvers);
        dest.writeString(this.crtOversExtraBalls);
    }
}
