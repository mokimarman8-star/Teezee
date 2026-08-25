package com.transsion.mbwidget.data;

import androidx.collection.s;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u000eHÆ\u0003Ji\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/transsion/mbwidget/data/SportMatch;", "Ljava/io/Serializable;", "matchId", BuildConfig.FLAVOR, "sportType", "Lcom/transsion/mbwidget/data/SportType;", "team1Name", "team1Logo", "team2Name", "team2Logo", "matchTime", BuildConfig.FLAVOR, "deeplink", "status", "Lcom/transsion/mbwidget/data/MatchStatus;", "<init>", "(Ljava/lang/String;Lcom/transsion/mbwidget/data/SportType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/transsion/mbwidget/data/MatchStatus;)V", "getMatchId", "()Ljava/lang/String;", "getSportType", "()Lcom/transsion/mbwidget/data/SportType;", "getTeam1Name", "getTeam1Logo", "getTeam2Name", "getTeam2Logo", "getMatchTime", "()J", "getDeeplink", "getStatus", "()Lcom/transsion/mbwidget/data/MatchStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "DeskWidget_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class SportMatch implements Serializable {
    private final String deeplink;
    private final String matchId;
    private final long matchTime;
    private final SportType sportType;
    private final MatchStatus status;
    private final String team1Logo;
    private final String team1Name;
    private final String team2Logo;
    private final String team2Name;

    public SportMatch(String str, SportType sportType, String str2, String str3, String str4, String str5, long j, String str6, MatchStatus matchStatus) {
        Intrinsics.h(str, "matchId");
        Intrinsics.h(sportType, "sportType");
        Intrinsics.h(str2, "team1Name");
        Intrinsics.h(str4, "team2Name");
        Intrinsics.h(matchStatus, "status");
        this.matchId = str;
        this.sportType = sportType;
        this.team1Name = str2;
        this.team1Logo = str3;
        this.team2Name = str4;
        this.team2Logo = str5;
        this.matchTime = j;
        this.deeplink = str6;
        this.status = matchStatus;
    }

    public /* synthetic */ SportMatch(String str, SportType sportType, String str2, String str3, String str4, String str5, long j, String str6, MatchStatus matchStatus, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, sportType, str2, (i & 8) != 0 ? null : str3, str4, (i & 32) != 0 ? null : str5, j, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? MatchStatus.UNKNOWN : matchStatus);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMatchId() {
        return this.matchId;
    }

    /* renamed from: component2, reason: from getter */
    public final SportType getSportType() {
        return this.sportType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTeam1Name() {
        return this.team1Name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTeam1Logo() {
        return this.team1Logo;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTeam2Name() {
        return this.team2Name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTeam2Logo() {
        return this.team2Logo;
    }

    /* renamed from: component7, reason: from getter */
    public final long getMatchTime() {
        return this.matchTime;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDeeplink() {
        return this.deeplink;
    }

    /* renamed from: component9, reason: from getter */
    public final MatchStatus getStatus() {
        return this.status;
    }

    public final SportMatch copy(String matchId, SportType sportType, String team1Name, String team1Logo, String team2Name, String team2Logo, long matchTime, String deeplink, MatchStatus status) {
        Intrinsics.h(matchId, "matchId");
        Intrinsics.h(sportType, "sportType");
        Intrinsics.h(team1Name, "team1Name");
        Intrinsics.h(team2Name, "team2Name");
        Intrinsics.h(status, "status");
        return new SportMatch(matchId, sportType, team1Name, team1Logo, team2Name, team2Logo, matchTime, deeplink, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportMatch)) {
            return false;
        }
        SportMatch sportMatch = (SportMatch) other;
        return Intrinsics.c(this.matchId, sportMatch.matchId) && this.sportType == sportMatch.sportType && Intrinsics.c(this.team1Name, sportMatch.team1Name) && Intrinsics.c(this.team1Logo, sportMatch.team1Logo) && Intrinsics.c(this.team2Name, sportMatch.team2Name) && Intrinsics.c(this.team2Logo, sportMatch.team2Logo) && this.matchTime == sportMatch.matchTime && Intrinsics.c(this.deeplink, sportMatch.deeplink) && this.status == sportMatch.status;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final String getMatchId() {
        return this.matchId;
    }

    public final long getMatchTime() {
        return this.matchTime;
    }

    public final SportType getSportType() {
        return this.sportType;
    }

    public final MatchStatus getStatus() {
        return this.status;
    }

    public final String getTeam1Logo() {
        return this.team1Logo;
    }

    public final String getTeam1Name() {
        return this.team1Name;
    }

    public final String getTeam2Logo() {
        return this.team2Logo;
    }

    public final String getTeam2Name() {
        return this.team2Name;
    }

    public int hashCode() {
        int hashCode = ((((this.matchId.hashCode() * 31) + this.sportType.hashCode()) * 31) + this.team1Name.hashCode()) * 31;
        String str = this.team1Logo;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.team2Name.hashCode()) * 31;
        String str2 = this.team2Logo;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + s.a(this.matchTime)) * 31;
        String str3 = this.deeplink;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "SportMatch(matchId=" + this.matchId + ", sportType=" + this.sportType + ", team1Name=" + this.team1Name + ", team1Logo=" + this.team1Logo + ", team2Name=" + this.team2Name + ", team2Logo=" + this.team2Logo + ", matchTime=" + this.matchTime + ", deeplink=" + this.deeplink + ", status=" + this.status + ")";
    }
}
