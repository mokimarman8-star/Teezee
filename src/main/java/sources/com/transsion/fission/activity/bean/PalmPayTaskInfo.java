package com.transsion.fission.activity.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0005J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006'"}, d2 = {"Lcom/transsion/fission/activity/bean/PalmPayTaskInfo;", "Landroid/os/Parcelable;", "taskId", BuildConfig.FLAVOR, "progress", BuildConfig.FLAVOR, "totalProgress", "status", "<init>", "(Ljava/lang/String;III)V", "getTaskId", "()Ljava/lang/String;", "setTaskId", "(Ljava/lang/String;)V", "getProgress", "()I", "setProgress", "(I)V", "getTotalProgress", "setTotalProgress", "getStatus", "setStatus", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "writeToParcel", BuildConfig.FLAVOR, "dest", "Landroid/os/Parcel;", "flags", "Fission_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class PalmPayTaskInfo implements Parcelable {
    public static final Parcelable.Creator<PalmPayTaskInfo> CREATOR = new a();
    private int progress;
    private int status;
    private String taskId;
    private int totalProgress;

    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PalmPayTaskInfo createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "parcel");
            return new PalmPayTaskInfo(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PalmPayTaskInfo[] newArray(int i) {
            return new PalmPayTaskInfo[i];
        }
    }

    public PalmPayTaskInfo(String str, int i, int i2, int i3) {
        Intrinsics.h(str, "taskId");
        this.taskId = str;
        this.progress = i;
        this.totalProgress = i2;
        this.status = i3;
    }

    public static /* synthetic */ PalmPayTaskInfo copy$default(PalmPayTaskInfo palmPayTaskInfo, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = palmPayTaskInfo.taskId;
        }
        if ((i4 & 2) != 0) {
            i = palmPayTaskInfo.progress;
        }
        if ((i4 & 4) != 0) {
            i2 = palmPayTaskInfo.totalProgress;
        }
        if ((i4 & 8) != 0) {
            i3 = palmPayTaskInfo.status;
        }
        return palmPayTaskInfo.copy(str, i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalProgress() {
        return this.totalProgress;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final PalmPayTaskInfo copy(String taskId, int progress, int totalProgress, int status) {
        Intrinsics.h(taskId, "taskId");
        return new PalmPayTaskInfo(taskId, progress, totalProgress, status);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PalmPayTaskInfo)) {
            return false;
        }
        PalmPayTaskInfo palmPayTaskInfo = (PalmPayTaskInfo) other;
        return Intrinsics.c(this.taskId, palmPayTaskInfo.taskId) && this.progress == palmPayTaskInfo.progress && this.totalProgress == palmPayTaskInfo.totalProgress && this.status == palmPayTaskInfo.status;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getTotalProgress() {
        return this.totalProgress;
    }

    public int hashCode() {
        return (((((this.taskId.hashCode() * 31) + this.progress) * 31) + this.totalProgress) * 31) + this.status;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTaskId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.taskId = str;
    }

    public final void setTotalProgress(int i) {
        this.totalProgress = i;
    }

    public String toString() {
        return "PalmPayTaskInfo(taskId=" + this.taskId + ", progress=" + this.progress + ", totalProgress=" + this.totalProgress + ", status=" + this.status + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeInt(this.progress);
        dest.writeInt(this.totalProgress);
        dest.writeInt(this.status);
    }
}
