package j4;

import android.net.Uri;
import android.os.Build;
import androidx.coroutines.C0209b;
import androidx.coroutines.WorkInfo;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f15878a = new b0();

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15879a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15880b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f15881c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f15882d;

        static {
            int[] iArr = new int[WorkInfo.State.values().length];
            try {
                iArr[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f15879a = iArr;
            int[] iArr2 = new int[BackoffPolicy.values().length];
            try {
                iArr2[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f15880b = iArr2;
            int[] iArr3 = new int[NetworkType.values().length];
            try {
                iArr3[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            f15881c = iArr3;
            int[] iArr4 = new int[OutOfQuotaPolicy.values().length];
            try {
                iArr4[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            f15882d = iArr4;
        }
    }

    private b0() {
    }

    public static final int a(BackoffPolicy backoffPolicy) {
        Intrinsics.h(backoffPolicy, "backoffPolicy");
        int i5 = a.f15880b[backoffPolicy.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Set b(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Intrinsics.h(bArr, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                int readInt = objectInputStream.readInt();
                for (int i5 = 0; i5 < readInt; i5++) {
                    Uri parse = Uri.parse(objectInputStream.readUTF());
                    boolean readBoolean = objectInputStream.readBoolean();
                    Intrinsics.g(parse, "uri");
                    linkedHashSet.add(new C0209b.c(parse, readBoolean));
                }
                Unit unit = Unit.a;
                CloseableKt.a(objectInputStream, (Throwable) null);
                Unit unit2 = Unit.a;
                CloseableKt.a(byteArrayInputStream, (Throwable) null);
                return linkedHashSet;
            } finally {
            }
        } finally {
        }
    }

    public static final BackoffPolicy c(int i5) {
        if (i5 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i5 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i5 + " to BackoffPolicy");
    }

    public static final NetworkType d(int i5) {
        if (i5 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i5 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i5 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i5 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i5 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i5 == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i5 + " to NetworkType");
    }

    public static final OutOfQuotaPolicy e(int i5) {
        if (i5 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i5 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i5 + " to OutOfQuotaPolicy");
    }

    public static final WorkInfo.State f(int i5) {
        if (i5 == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i5 == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i5 == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i5 == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i5 == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i5 == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i5 + " to State");
    }

    public static final int g(NetworkType networkType) {
        Intrinsics.h(networkType, "networkType");
        int i5 = a.f15881c[networkType.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        int i6 = 2;
        if (i5 == 2) {
            return 1;
        }
        if (i5 != 3) {
            i6 = 4;
            if (i5 == 4) {
                return 3;
            }
            if (i5 != 5) {
                if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
                    return 5;
                }
                throw new IllegalArgumentException("Could not convert " + networkType + " to int");
            }
        }
        return i6;
    }

    public static final int h(OutOfQuotaPolicy outOfQuotaPolicy) {
        Intrinsics.h(outOfQuotaPolicy, "policy");
        int i5 = a.f15882d[outOfQuotaPolicy.ordinal()];
        if (i5 == 1) {
            return 0;
        }
        if (i5 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final byte[] i(Set set) {
        Intrinsics.h(set, "triggers");
        if (set.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(set.size());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    C0209b.c cVar = (C0209b.c) it.next();
                    objectOutputStream.writeUTF(cVar.a().toString());
                    objectOutputStream.writeBoolean(cVar.b());
                }
                Unit unit = Unit.a;
                CloseableKt.a(objectOutputStream, (Throwable) null);
                CloseableKt.a(byteArrayOutputStream, (Throwable) null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.g(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static final int j(WorkInfo.State state) {
        Intrinsics.h(state, "state");
        switch (a.f15879a[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
