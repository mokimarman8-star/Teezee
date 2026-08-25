package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import b5.z0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.time.Instant;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001,B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bB\u0011\b\u0017\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u001f\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010\u001b¨\u0006-"}, d2 = {"Lcom/google/firebase/Timestamp;", TtmlNode.ANONYMOUS_REGION_ID, "Landroid/os/Parcelable;", TtmlNode.ANONYMOUS_REGION_ID, "seconds", TtmlNode.ANONYMOUS_REGION_ID, "nanoseconds", "<init>", "(JI)V", "Ljava/util/Date;", "date", "(Ljava/util/Date;)V", "Ljava/time/Instant;", "time", "(Ljava/time/Instant;)V", "toDate", "()Ljava/util/Date;", "toInstant", "()Ljava/time/Instant;", "other", "compareTo", "(Lcom/google/firebase/Timestamp;)I", TtmlNode.ANONYMOUS_REGION_ID, TtmlNode.ANONYMOUS_REGION_ID, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", TtmlNode.ANONYMOUS_REGION_ID, "toString", "()Ljava/lang/String;", "describeContents", "Landroid/os/Parcel;", "dest", "flags", TtmlNode.ANONYMOUS_REGION_ID, "writeToParcel", "(Landroid/os/Parcel;I)V", "J", "getSeconds", "()J", "I", "getNanoseconds", "Companion", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "com.google.firebase-firebase-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    public static final Parcelable.Creator<Timestamp> CREATOR = new a();

    public static final class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Timestamp createFromParcel(Parcel parcel) {
            Intrinsics.h(parcel, "source");
            return new Timestamp(parcel.readLong(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Timestamp[] newArray(int i) {
            return new Timestamp[i];
        }
    }

    /* renamed from: com.google.firebase.Timestamp$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pair d(Date date) {
            long j = 1000;
            long time = date.getTime() / j;
            int time2 = (int) ((date.getTime() % j) * 1000000);
            return time2 < 0 ? TuplesKt.a(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000)) : TuplesKt.a(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(long j, int i) {
            if (i < 0 || i >= 1000000000) {
                throw new IllegalArgumentException(("Timestamp nanoseconds out of range: " + i).toString());
            }
            if (-62135596800L > j || j >= 253402300800L) {
                throw new IllegalArgumentException(("Timestamp seconds out of range: " + j).toString());
            }
        }

        public final Timestamp c() {
            return new Timestamp(new Date());
        }
    }

    public Timestamp(long j, int i) {
        INSTANCE.e(j, i);
        this.seconds = j;
        this.nanoseconds = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Timestamp(Instant instant) {
        this(r0, r3);
        long epochSecond;
        int nano;
        Intrinsics.h(instant, "time");
        epochSecond = instant.getEpochSecond();
        nano = instant.getNano();
    }

    public Timestamp(Date date) {
        Intrinsics.h(date, "date");
        Companion companion = INSTANCE;
        Pair d = companion.d(date);
        long longValue = ((Number) d.component1()).longValue();
        int intValue = ((Number) d.component2()).intValue();
        companion.e(longValue, intValue);
        this.seconds = longValue;
        this.nanoseconds = intValue;
    }

    @JvmStatic
    public static final Timestamp now() {
        return INSTANCE.c();
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp other) {
        Intrinsics.h(other, "other");
        return ComparisonsKt.e(this, other, new Function1[]{new PropertyReference1Impl() { // from class: com.google.firebase.Timestamp$compareTo$1
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new PropertyReference1Impl() { // from class: com.google.firebase.Timestamp$compareTo$2
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        }});
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        return other == this || ((other instanceof Timestamp) && compareTo((Timestamp) other) == 0);
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j = this.seconds;
        return (((((int) j) * 1369) + ((int) (j >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * 1000) + (this.nanoseconds / 1000000));
    }

    public final Instant toInstant() {
        Instant a2 = z0.a(this.seconds, this.nanoseconds);
        Intrinsics.g(a2, "ofEpochSecond(...)");
        return a2;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.h(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }
}
