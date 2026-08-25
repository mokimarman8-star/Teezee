package com.transsion.lib_web.download_render.utils;

import androidx.annotation.Keep;
import androidx.collection.s;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003Jc\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0007HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001b¨\u00067"}, d2 = {"Lcom/transsion/lib_web/download_render/utils/FileScoreData;", BuildConfig.FLAVOR, "stageFinished", BuildConfig.FLAVOR, "renderTime", BuildConfig.FLAVOR, "score", BuildConfig.FLAVOR, "fileDataNull", "fileOperateStatusAbort", "fileUnExist", "exception", "versionUnSame", "htmlFromRemote", "<init>", "(ZJIIIIIII)V", "getStageFinished", "()Z", "setStageFinished", "(Z)V", "getRenderTime", "()J", "setRenderTime", "(J)V", "getScore", "()I", "setScore", "(I)V", "getFileDataNull", "setFileDataNull", "getFileOperateStatusAbort", "setFileOperateStatusAbort", "getFileUnExist", "setFileUnExist", "getException", "setException", "getVersionUnSame", "setVersionUnSame", "getHtmlFromRemote", "setHtmlFromRemote", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", BuildConfig.FLAVOR, "lib_web_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class FileScoreData {
    private int exception;
    private int fileDataNull;
    private int fileOperateStatusAbort;
    private int fileUnExist;
    private int htmlFromRemote;
    private long renderTime;
    private int score;
    private boolean stageFinished;
    private int versionUnSame;

    public FileScoreData() {
        this(false, 0L, 0, 0, 0, 0, 0, 0, 0, DownloadException.EXCEPTION_IO_SSL_KEY, null);
    }

    public FileScoreData(boolean z, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.stageFinished = z;
        this.renderTime = j;
        this.score = i;
        this.fileDataNull = i2;
        this.fileOperateStatusAbort = i3;
        this.fileUnExist = i4;
        this.exception = i5;
        this.versionUnSame = i6;
        this.htmlFromRemote = i7;
    }

    public /* synthetic */ FileScoreData(boolean z, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z, (i8 & 2) != 0 ? 0L : j, (i8 & 4) != 0 ? 0 : i, (i8 & 8) != 0 ? 0 : i2, (i8 & 16) != 0 ? 0 : i3, (i8 & 32) != 0 ? 0 : i4, (i8 & 64) != 0 ? 0 : i5, (i8 & 128) != 0 ? 0 : i6, (i8 & 256) == 0 ? i7 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getStageFinished() {
        return this.stageFinished;
    }

    /* renamed from: component2, reason: from getter */
    public final long getRenderTime() {
        return this.renderTime;
    }

    /* renamed from: component3, reason: from getter */
    public final int getScore() {
        return this.score;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFileDataNull() {
        return this.fileDataNull;
    }

    /* renamed from: component5, reason: from getter */
    public final int getFileOperateStatusAbort() {
        return this.fileOperateStatusAbort;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFileUnExist() {
        return this.fileUnExist;
    }

    /* renamed from: component7, reason: from getter */
    public final int getException() {
        return this.exception;
    }

    /* renamed from: component8, reason: from getter */
    public final int getVersionUnSame() {
        return this.versionUnSame;
    }

    /* renamed from: component9, reason: from getter */
    public final int getHtmlFromRemote() {
        return this.htmlFromRemote;
    }

    public final FileScoreData copy(boolean stageFinished, long renderTime, int score, int fileDataNull, int fileOperateStatusAbort, int fileUnExist, int exception, int versionUnSame, int htmlFromRemote) {
        return new FileScoreData(stageFinished, renderTime, score, fileDataNull, fileOperateStatusAbort, fileUnExist, exception, versionUnSame, htmlFromRemote);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileScoreData)) {
            return false;
        }
        FileScoreData fileScoreData = (FileScoreData) other;
        return this.stageFinished == fileScoreData.stageFinished && this.renderTime == fileScoreData.renderTime && this.score == fileScoreData.score && this.fileDataNull == fileScoreData.fileDataNull && this.fileOperateStatusAbort == fileScoreData.fileOperateStatusAbort && this.fileUnExist == fileScoreData.fileUnExist && this.exception == fileScoreData.exception && this.versionUnSame == fileScoreData.versionUnSame && this.htmlFromRemote == fileScoreData.htmlFromRemote;
    }

    public final int getException() {
        return this.exception;
    }

    public final int getFileDataNull() {
        return this.fileDataNull;
    }

    public final int getFileOperateStatusAbort() {
        return this.fileOperateStatusAbort;
    }

    public final int getFileUnExist() {
        return this.fileUnExist;
    }

    public final int getHtmlFromRemote() {
        return this.htmlFromRemote;
    }

    public final long getRenderTime() {
        return this.renderTime;
    }

    public final int getScore() {
        return this.score;
    }

    public final boolean getStageFinished() {
        return this.stageFinished;
    }

    public final int getVersionUnSame() {
        return this.versionUnSame;
    }

    public int hashCode() {
        return (((((((((((((((androidx.compose.foundation.e.a(this.stageFinished) * 31) + s.a(this.renderTime)) * 31) + this.score) * 31) + this.fileDataNull) * 31) + this.fileOperateStatusAbort) * 31) + this.fileUnExist) * 31) + this.exception) * 31) + this.versionUnSame) * 31) + this.htmlFromRemote;
    }

    public final void setException(int i) {
        this.exception = i;
    }

    public final void setFileDataNull(int i) {
        this.fileDataNull = i;
    }

    public final void setFileOperateStatusAbort(int i) {
        this.fileOperateStatusAbort = i;
    }

    public final void setFileUnExist(int i) {
        this.fileUnExist = i;
    }

    public final void setHtmlFromRemote(int i) {
        this.htmlFromRemote = i;
    }

    public final void setRenderTime(long j) {
        this.renderTime = j;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setStageFinished(boolean z) {
        this.stageFinished = z;
    }

    public final void setVersionUnSame(int i) {
        this.versionUnSame = i;
    }

    public String toString() {
        return "FileScoreData(stageFinished=" + this.stageFinished + ", renderTime=" + this.renderTime + ", score=" + this.score + ", fileDataNull=" + this.fileDataNull + ", fileOperateStatusAbort=" + this.fileOperateStatusAbort + ", fileUnExist=" + this.fileUnExist + ", exception=" + this.exception + ", versionUnSame=" + this.versionUnSame + ", htmlFromRemote=" + this.htmlFromRemote + ")";
    }
}
