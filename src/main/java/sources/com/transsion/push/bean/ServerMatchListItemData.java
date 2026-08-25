package com.transsion.push.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bk\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bï\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b&\u0010'J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010w\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u0012\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u001dHÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u0086\u0001\u001a\u00020\"HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\"HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jò\u0002\u0010\u008a\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0007\u0010\u008b\u0001\u001a\u00020\u001dJ\u0016\u0010\u008c\u0001\u001a\u00020\"2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001HÖ\u0003J\n\u0010\u008f\u0001\u001a\u00020\u001dHÖ\u0001J\n\u0010\u0090\u0001\u001a\u00020\u0003HÖ\u0001J\u001b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u001dR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010)\"\u0004\b;\u0010+R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010)\"\u0004\b=\u0010+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010)\"\u0004\bE\u0010+R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010K\"\u0004\bO\u0010MR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010)\"\u0004\bQ\u0010+R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010)\"\u0004\bS\u0010+R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010A\"\u0004\bU\u0010CR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010A\"\u0004\bW\u0010CR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010)\"\u0004\bY\u0010+R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010)\"\u0004\ba\u0010+R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010d\"\u0004\be\u0010fR\u001a\u0010#\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010d\"\u0004\bh\u0010fR\u001c\u0010$\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010)\"\u0004\bj\u0010+R\u001c\u0010%\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010)\"\u0004\bl\u0010+¨\u0006\u0096\u0001"}, d2 = {"Lcom/transsion/push/bean/ServerMatchListItemData;", "Landroid/os/Parcelable;", "id", BuildConfig.FLAVOR, "team1", "Lcom/transsion/push/bean/TeamInfoMatch;", "team2", "status", "playType", "playPath", "startTime", "endTime", "type", "timeDesc", "playSource", BuildConfig.FLAVOR, "Lcom/transsion/push/bean/PlaySourceMatchMatch;", "statusLive", "league", "liveDeviceId", "teamMatchInfo1", "Lcom/transsion/push/bean/TeamMatchInfoMatch;", "teamMatchInfo2", "matchResult", "matchRound", "replay", "highlights", "extCountryCode", "score", BuildConfig.FLAVOR, "liveType", "liveRegion", "leagueId", "isSub", BuildConfig.FLAVOR, "startTimeTbd", "leagueType", "season", "<init>", "(Ljava/lang/String;Lcom/transsion/push/bean/TeamInfoMatch;Lcom/transsion/push/bean/TeamInfoMatch;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/push/bean/TeamMatchInfoMatch;Lcom/transsion/push/bean/TeamMatchInfoMatch;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getTeam1", "()Lcom/transsion/push/bean/TeamInfoMatch;", "setTeam1", "(Lcom/transsion/push/bean/TeamInfoMatch;)V", "getTeam2", "setTeam2", "getStatus", "setStatus", "getPlayType", "setPlayType", "getPlayPath", "setPlayPath", "getStartTime", "setStartTime", "getEndTime", "setEndTime", "getType", "setType", "getTimeDesc", "setTimeDesc", "getPlaySource", "()Ljava/util/List;", "setPlaySource", "(Ljava/util/List;)V", "getStatusLive", "setStatusLive", "getLeague", "setLeague", "getLiveDeviceId", "setLiveDeviceId", "getTeamMatchInfo1", "()Lcom/transsion/push/bean/TeamMatchInfoMatch;", "setTeamMatchInfo1", "(Lcom/transsion/push/bean/TeamMatchInfoMatch;)V", "getTeamMatchInfo2", "setTeamMatchInfo2", "getMatchResult", "setMatchResult", "getMatchRound", "setMatchRound", "getReplay", "setReplay", "getHighlights", "setHighlights", "getExtCountryCode", "setExtCountryCode", "getScore", "()I", "setScore", "(I)V", "getLiveType", "setLiveType", "getLiveRegion", "setLiveRegion", "getLeagueId", "setLeagueId", "()Z", "setSub", "(Z)V", "getStartTimeTbd", "setStartTimeTbd", "getLeagueType", "setLeagueType", "getSeason", "setSeason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "describeContents", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class ServerMatchListItemData implements Parcelable {
    public static final Parcelable.Creator<ServerMatchListItemData> CREATOR = new Creator();
    private String endTime;
    private String extCountryCode;
    private List<PlaySourceMatchMatch> highlights;
    private String id;
    private boolean isSub;
    private String league;
    private String leagueId;
    private String leagueType;
    private String liveDeviceId;
    private String liveRegion;
    private String liveType;
    private String matchResult;
    private String matchRound;
    private String playPath;
    private List<PlaySourceMatchMatch> playSource;
    private String playType;
    private List<PlaySourceMatchMatch> replay;
    private int score;
    private String season;
    private String startTime;
    private boolean startTimeTbd;
    private String status;
    private String statusLive;
    private TeamInfoMatch team1;
    private TeamInfoMatch team2;
    private TeamMatchInfoMatch teamMatchInfo1;
    private TeamMatchInfoMatch teamMatchInfo2;
    private String timeDesc;
    private String type;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ServerMatchListItemData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServerMatchListItemData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String str;
            ArrayList arrayList2;
            ArrayList arrayList3;
            Intrinsics.h(parcel, "parcel");
            String readString = parcel.readString();
            TeamInfoMatch createFromParcel = parcel.readInt() == 0 ? null : TeamInfoMatch.CREATOR.createFromParcel(parcel);
            TeamInfoMatch createFromParcel2 = parcel.readInt() == 0 ? null : TeamInfoMatch.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(PlaySourceMatchMatch.CREATOR.createFromParcel(parcel));
                }
            }
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            TeamMatchInfoMatch createFromParcel3 = parcel.readInt() == 0 ? null : TeamMatchInfoMatch.CREATOR.createFromParcel(parcel);
            TeamMatchInfoMatch createFromParcel4 = parcel.readInt() == 0 ? null : TeamMatchInfoMatch.CREATOR.createFromParcel(parcel);
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            if (parcel.readInt() == 0) {
                str = readString10;
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList4 = new ArrayList(readInt2);
                str = readString10;
                int i2 = 0;
                while (i2 != readInt2) {
                    arrayList4.add(PlaySourceMatchMatch.CREATOR.createFromParcel(parcel));
                    i2++;
                    readInt2 = readInt2;
                }
                arrayList2 = arrayList4;
            }
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList5 = new ArrayList(readInt3);
                int i3 = 0;
                while (i3 != readInt3) {
                    arrayList5.add(PlaySourceMatchMatch.CREATOR.createFromParcel(parcel));
                    i3++;
                    readInt3 = readInt3;
                }
                arrayList3 = arrayList5;
            }
            return new ServerMatchListItemData(readString, createFromParcel, createFromParcel2, readString2, readString3, readString4, readString5, readString6, readString7, readString8, arrayList, readString9, str, readString11, createFromParcel3, createFromParcel4, readString12, readString13, arrayList2, arrayList3, parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ServerMatchListItemData[] newArray(int i) {
            return new ServerMatchListItemData[i];
        }
    }

    public ServerMatchListItemData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, false, false, null, null, 536870911, null);
    }

    public ServerMatchListItemData(String str, TeamInfoMatch teamInfoMatch, TeamInfoMatch teamInfoMatch2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List<PlaySourceMatchMatch> list, String str9, String str10, String str11, TeamMatchInfoMatch teamMatchInfoMatch, TeamMatchInfoMatch teamMatchInfoMatch2, String str12, String str13, List<PlaySourceMatchMatch> list2, List<PlaySourceMatchMatch> list3, String str14, int i, String str15, String str16, String str17, boolean z, boolean z2, String str18, String str19) {
        this.id = str;
        this.team1 = teamInfoMatch;
        this.team2 = teamInfoMatch2;
        this.status = str2;
        this.playType = str3;
        this.playPath = str4;
        this.startTime = str5;
        this.endTime = str6;
        this.type = str7;
        this.timeDesc = str8;
        this.playSource = list;
        this.statusLive = str9;
        this.league = str10;
        this.liveDeviceId = str11;
        this.teamMatchInfo1 = teamMatchInfoMatch;
        this.teamMatchInfo2 = teamMatchInfoMatch2;
        this.matchResult = str12;
        this.matchRound = str13;
        this.replay = list2;
        this.highlights = list3;
        this.extCountryCode = str14;
        this.score = i;
        this.liveType = str15;
        this.liveRegion = str16;
        this.leagueId = str17;
        this.isSub = z;
        this.startTimeTbd = z2;
        this.leagueType = str18;
        this.season = str19;
    }

    public /* synthetic */ ServerMatchListItemData(String str, TeamInfoMatch teamInfoMatch, TeamInfoMatch teamInfoMatch2, String str2, String str3, String str4, String str5, String str6, String str7, String str8, List list, String str9, String str10, String str11, TeamMatchInfoMatch teamMatchInfoMatch, TeamMatchInfoMatch teamMatchInfoMatch2, String str12, String str13, List list2, List list3, String str14, int i, String str15, String str16, String str17, boolean z, boolean z2, String str18, String str19, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : teamInfoMatch, (i2 & 4) != 0 ? null : teamInfoMatch2, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? null : str4, (i2 & 64) != 0 ? null : str5, (i2 & 128) != 0 ? null : str6, (i2 & 256) != 0 ? null : str7, (i2 & DownloadException.EXCEPTION_IO_SSL_PEER_UNVERIFIED) != 0 ? null : str8, (i2 & 1024) != 0 ? null : list, (i2 & 2048) != 0 ? null : str9, (i2 & 4096) != 0 ? null : str10, (i2 & 8192) != 0 ? null : str11, (i2 & 16384) != 0 ? null : teamMatchInfoMatch, (i2 & 32768) != 0 ? null : teamMatchInfoMatch2, (i2 & 65536) != 0 ? null : str12, (i2 & 131072) != 0 ? null : str13, (i2 & 262144) != 0 ? null : list2, (i2 & 524288) != 0 ? null : list3, (i2 & 1048576) != 0 ? null : str14, (i2 & 2097152) != 0 ? 0 : i, (i2 & 4194304) != 0 ? null : str15, (i2 & 8388608) != 0 ? null : str16, (i2 & 16777216) != 0 ? null : str17, (i2 & 33554432) != 0 ? false : z, (i2 & 67108864) == 0 ? z2 : false, (i2 & 134217728) != 0 ? null : str18, (i2 & 268435456) != 0 ? null : str19);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final List<PlaySourceMatchMatch> component11() {
        return this.playSource;
    }

    /* renamed from: component12, reason: from getter */
    public final String getStatusLive() {
        return this.statusLive;
    }

    /* renamed from: component13, reason: from getter */
    public final String getLeague() {
        return this.league;
    }

    /* renamed from: component14, reason: from getter */
    public final String getLiveDeviceId() {
        return this.liveDeviceId;
    }

    /* renamed from: component15, reason: from getter */
    public final TeamMatchInfoMatch getTeamMatchInfo1() {
        return this.teamMatchInfo1;
    }

    /* renamed from: component16, reason: from getter */
    public final TeamMatchInfoMatch getTeamMatchInfo2() {
        return this.teamMatchInfo2;
    }

    /* renamed from: component17, reason: from getter */
    public final String getMatchResult() {
        return this.matchResult;
    }

    /* renamed from: component18, reason: from getter */
    public final String getMatchRound() {
        return this.matchRound;
    }

    public final List<PlaySourceMatchMatch> component19() {
        return this.replay;
    }

    /* renamed from: component2, reason: from getter */
    public final TeamInfoMatch getTeam1() {
        return this.team1;
    }

    public final List<PlaySourceMatchMatch> component20() {
        return this.highlights;
    }

    /* renamed from: component21, reason: from getter */
    public final String getExtCountryCode() {
        return this.extCountryCode;
    }

    /* renamed from: component22, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component23, reason: from getter */
    public final String getLiveType() {
        return this.liveType;
    }

    /* renamed from: component24, reason: from getter */
    public final String getLiveRegion() {
        return this.liveRegion;
    }

    /* renamed from: component25, reason: from getter */
    public final String getLeagueId() {
        return this.leagueId;
    }

    /* renamed from: component26, reason: from getter */
    public final boolean getIsSub() {
        return this.isSub;
    }

    /* renamed from: component27, reason: from getter */
    public final boolean getStartTimeTbd() {
        return this.startTimeTbd;
    }

    /* renamed from: component28, reason: from getter */
    public final String getLeagueType() {
        return this.leagueType;
    }

    /* renamed from: component29, reason: from getter */
    public final String getSeason() {
        return this.season;
    }

    /* renamed from: component3, reason: from getter */
    public final TeamInfoMatch getTeam2() {
        return this.team2;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPlayType() {
        return this.playType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPlayPath() {
        return this.playPath;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component8, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: component9, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final ServerMatchListItemData copy(String id, TeamInfoMatch team1, TeamInfoMatch team2, String status, String playType, String playPath, String startTime, String endTime, String type, String timeDesc, List<PlaySourceMatchMatch> playSource, String statusLive, String league, String liveDeviceId, TeamMatchInfoMatch teamMatchInfo1, TeamMatchInfoMatch teamMatchInfo2, String matchResult, String matchRound, List<PlaySourceMatchMatch> replay, List<PlaySourceMatchMatch> highlights, String extCountryCode, int score, String liveType, String liveRegion, String leagueId, boolean isSub, boolean startTimeTbd, String leagueType, String season) {
        return new ServerMatchListItemData(id, team1, team2, status, playType, playPath, startTime, endTime, type, timeDesc, playSource, statusLive, league, liveDeviceId, teamMatchInfo1, teamMatchInfo2, matchResult, matchRound, replay, highlights, extCountryCode, score, liveType, liveRegion, leagueId, isSub, startTimeTbd, leagueType, season);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ServerMatchListItemData)) {
            return false;
        }
        ServerMatchListItemData serverMatchListItemData = (ServerMatchListItemData) other;
        return Intrinsics.c(this.id, serverMatchListItemData.id) && Intrinsics.c(this.team1, serverMatchListItemData.team1) && Intrinsics.c(this.team2, serverMatchListItemData.team2) && Intrinsics.c(this.status, serverMatchListItemData.status) && Intrinsics.c(this.playType, serverMatchListItemData.playType) && Intrinsics.c(this.playPath, serverMatchListItemData.playPath) && Intrinsics.c(this.startTime, serverMatchListItemData.startTime) && Intrinsics.c(this.endTime, serverMatchListItemData.endTime) && Intrinsics.c(this.type, serverMatchListItemData.type) && Intrinsics.c(this.timeDesc, serverMatchListItemData.timeDesc) && Intrinsics.c(this.playSource, serverMatchListItemData.playSource) && Intrinsics.c(this.statusLive, serverMatchListItemData.statusLive) && Intrinsics.c(this.league, serverMatchListItemData.league) && Intrinsics.c(this.liveDeviceId, serverMatchListItemData.liveDeviceId) && Intrinsics.c(this.teamMatchInfo1, serverMatchListItemData.teamMatchInfo1) && Intrinsics.c(this.teamMatchInfo2, serverMatchListItemData.teamMatchInfo2) && Intrinsics.c(this.matchResult, serverMatchListItemData.matchResult) && Intrinsics.c(this.matchRound, serverMatchListItemData.matchRound) && Intrinsics.c(this.replay, serverMatchListItemData.replay) && Intrinsics.c(this.highlights, serverMatchListItemData.highlights) && Intrinsics.c(this.extCountryCode, serverMatchListItemData.extCountryCode) && this.score == serverMatchListItemData.score && Intrinsics.c(this.liveType, serverMatchListItemData.liveType) && Intrinsics.c(this.liveRegion, serverMatchListItemData.liveRegion) && Intrinsics.c(this.leagueId, serverMatchListItemData.leagueId) && this.isSub == serverMatchListItemData.isSub && this.startTimeTbd == serverMatchListItemData.startTimeTbd && Intrinsics.c(this.leagueType, serverMatchListItemData.leagueType) && Intrinsics.c(this.season, serverMatchListItemData.season);
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getExtCountryCode() {
        return this.extCountryCode;
    }

    public final List<PlaySourceMatchMatch> getHighlights() {
        return this.highlights;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLeague() {
        return this.league;
    }

    public final String getLeagueId() {
        return this.leagueId;
    }

    public final String getLeagueType() {
        return this.leagueType;
    }

    public final String getLiveDeviceId() {
        return this.liveDeviceId;
    }

    public final String getLiveRegion() {
        return this.liveRegion;
    }

    public final String getLiveType() {
        return this.liveType;
    }

    public final String getMatchResult() {
        return this.matchResult;
    }

    public final String getMatchRound() {
        return this.matchRound;
    }

    public final String getPlayPath() {
        return this.playPath;
    }

    public final List<PlaySourceMatchMatch> getPlaySource() {
        return this.playSource;
    }

    public final String getPlayType() {
        return this.playType;
    }

    public final List<PlaySourceMatchMatch> getReplay() {
        return this.replay;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getSeason() {
        return this.season;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean getStartTimeTbd() {
        return this.startTimeTbd;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStatusLive() {
        return this.statusLive;
    }

    public final TeamInfoMatch getTeam1() {
        return this.team1;
    }

    public final TeamInfoMatch getTeam2() {
        return this.team2;
    }

    public final TeamMatchInfoMatch getTeamMatchInfo1() {
        return this.teamMatchInfo1;
    }

    public final TeamMatchInfoMatch getTeamMatchInfo2() {
        return this.teamMatchInfo2;
    }

    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        TeamInfoMatch teamInfoMatch = this.team1;
        int hashCode2 = (hashCode + (teamInfoMatch == null ? 0 : teamInfoMatch.hashCode())) * 31;
        TeamInfoMatch teamInfoMatch2 = this.team2;
        int hashCode3 = (hashCode2 + (teamInfoMatch2 == null ? 0 : teamInfoMatch2.hashCode())) * 31;
        String str2 = this.status;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.playType;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.playPath;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.startTime;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.endTime;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.type;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.timeDesc;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<PlaySourceMatchMatch> list = this.playSource;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str9 = this.statusLive;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.league;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.liveDeviceId;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        TeamMatchInfoMatch teamMatchInfoMatch = this.teamMatchInfo1;
        int hashCode15 = (hashCode14 + (teamMatchInfoMatch == null ? 0 : teamMatchInfoMatch.hashCode())) * 31;
        TeamMatchInfoMatch teamMatchInfoMatch2 = this.teamMatchInfo2;
        int hashCode16 = (hashCode15 + (teamMatchInfoMatch2 == null ? 0 : teamMatchInfoMatch2.hashCode())) * 31;
        String str12 = this.matchResult;
        int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.matchRound;
        int hashCode18 = (hashCode17 + (str13 == null ? 0 : str13.hashCode())) * 31;
        List<PlaySourceMatchMatch> list2 = this.replay;
        int hashCode19 = (hashCode18 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<PlaySourceMatchMatch> list3 = this.highlights;
        int hashCode20 = (hashCode19 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str14 = this.extCountryCode;
        int hashCode21 = (((hashCode20 + (str14 == null ? 0 : str14.hashCode())) * 31) + this.score) * 31;
        String str15 = this.liveType;
        int hashCode22 = (hashCode21 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.liveRegion;
        int hashCode23 = (hashCode22 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.leagueId;
        int hashCode24 = (((((hashCode23 + (str17 == null ? 0 : str17.hashCode())) * 31) + e.a(this.isSub)) * 31) + e.a(this.startTimeTbd)) * 31;
        String str18 = this.leagueType;
        int hashCode25 = (hashCode24 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.season;
        return hashCode25 + (str19 != null ? str19.hashCode() : 0);
    }

    public final boolean isSub() {
        return this.isSub;
    }

    public final void setEndTime(String str) {
        this.endTime = str;
    }

    public final void setExtCountryCode(String str) {
        this.extCountryCode = str;
    }

    public final void setHighlights(List<PlaySourceMatchMatch> list) {
        this.highlights = list;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLeague(String str) {
        this.league = str;
    }

    public final void setLeagueId(String str) {
        this.leagueId = str;
    }

    public final void setLeagueType(String str) {
        this.leagueType = str;
    }

    public final void setLiveDeviceId(String str) {
        this.liveDeviceId = str;
    }

    public final void setLiveRegion(String str) {
        this.liveRegion = str;
    }

    public final void setLiveType(String str) {
        this.liveType = str;
    }

    public final void setMatchResult(String str) {
        this.matchResult = str;
    }

    public final void setMatchRound(String str) {
        this.matchRound = str;
    }

    public final void setPlayPath(String str) {
        this.playPath = str;
    }

    public final void setPlaySource(List<PlaySourceMatchMatch> list) {
        this.playSource = list;
    }

    public final void setPlayType(String str) {
        this.playType = str;
    }

    public final void setReplay(List<PlaySourceMatchMatch> list) {
        this.replay = list;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setSeason(String str) {
        this.season = str;
    }

    public final void setStartTime(String str) {
        this.startTime = str;
    }

    public final void setStartTimeTbd(boolean z) {
        this.startTimeTbd = z;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void setStatusLive(String str) {
        this.statusLive = str;
    }

    public final void setSub(boolean z) {
        this.isSub = z;
    }

    public final void setTeam1(TeamInfoMatch teamInfoMatch) {
        this.team1 = teamInfoMatch;
    }

    public final void setTeam2(TeamInfoMatch teamInfoMatch) {
        this.team2 = teamInfoMatch;
    }

    public final void setTeamMatchInfo1(TeamMatchInfoMatch teamMatchInfoMatch) {
        this.teamMatchInfo1 = teamMatchInfoMatch;
    }

    public final void setTeamMatchInfo2(TeamMatchInfoMatch teamMatchInfoMatch) {
        this.teamMatchInfo2 = teamMatchInfoMatch;
    }

    public final void setTimeDesc(String str) {
        this.timeDesc = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "ServerMatchListItemData(id=" + this.id + ", team1=" + this.team1 + ", team2=" + this.team2 + ", status=" + this.status + ", playType=" + this.playType + ", playPath=" + this.playPath + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ", timeDesc=" + this.timeDesc + ", playSource=" + this.playSource + ", statusLive=" + this.statusLive + ", league=" + this.league + ", liveDeviceId=" + this.liveDeviceId + ", teamMatchInfo1=" + this.teamMatchInfo1 + ", teamMatchInfo2=" + this.teamMatchInfo2 + ", matchResult=" + this.matchResult + ", matchRound=" + this.matchRound + ", replay=" + this.replay + ", highlights=" + this.highlights + ", extCountryCode=" + this.extCountryCode + ", score=" + this.score + ", liveType=" + this.liveType + ", liveRegion=" + this.liveRegion + ", leagueId=" + this.leagueId + ", isSub=" + this.isSub + ", startTimeTbd=" + this.startTimeTbd + ", leagueType=" + this.leagueType + ", season=" + this.season + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.id);
        TeamInfoMatch teamInfoMatch = this.team1;
        if (teamInfoMatch == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            teamInfoMatch.writeToParcel(dest, flags);
        }
        TeamInfoMatch teamInfoMatch2 = this.team2;
        if (teamInfoMatch2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            teamInfoMatch2.writeToParcel(dest, flags);
        }
        dest.writeString(this.status);
        dest.writeString(this.playType);
        dest.writeString(this.playPath);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.type);
        dest.writeString(this.timeDesc);
        List<PlaySourceMatchMatch> list = this.playSource;
        if (list == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list.size());
            Iterator<PlaySourceMatchMatch> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.statusLive);
        dest.writeString(this.league);
        dest.writeString(this.liveDeviceId);
        TeamMatchInfoMatch teamMatchInfoMatch = this.teamMatchInfo1;
        if (teamMatchInfoMatch == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            teamMatchInfoMatch.writeToParcel(dest, flags);
        }
        TeamMatchInfoMatch teamMatchInfoMatch2 = this.teamMatchInfo2;
        if (teamMatchInfoMatch2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            teamMatchInfoMatch2.writeToParcel(dest, flags);
        }
        dest.writeString(this.matchResult);
        dest.writeString(this.matchRound);
        List<PlaySourceMatchMatch> list2 = this.replay;
        if (list2 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list2.size());
            Iterator<PlaySourceMatchMatch> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(dest, flags);
            }
        }
        List<PlaySourceMatchMatch> list3 = this.highlights;
        if (list3 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeInt(list3.size());
            Iterator<PlaySourceMatchMatch> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(dest, flags);
            }
        }
        dest.writeString(this.extCountryCode);
        dest.writeInt(this.score);
        dest.writeString(this.liveType);
        dest.writeString(this.liveRegion);
        dest.writeString(this.leagueId);
        dest.writeInt(this.isSub ? 1 : 0);
        dest.writeInt(this.startTimeTbd ? 1 : 0);
        dest.writeString(this.leagueType);
        dest.writeString(this.season);
    }
}
