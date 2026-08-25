package kotlin.random;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "bitCount", "nextBits", "(I)I", "nextInt", "()I", "until", HttpUrl.FRAGMENT_ENCODE_SET, "nextLong", "()J", HttpUrl.FRAGMENT_ENCODE_SET, "nextBoolean", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "nextDouble", "()D", HttpUrl.FRAGMENT_ENCODE_SET, "nextFloat", "()F", HttpUrl.FRAGMENT_ENCODE_SET, "array", "nextBytes", "([B)[B", "Ljava/util/Random;", "a", "()Ljava/util/Random;", "impl", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class AbstractPlatformRandom extends Random {
    public abstract Random a();

    public int nextBits(int bitCount) {
        return Random.g(a().nextInt(), bitCount);
    }

    public boolean nextBoolean() {
        return a().nextBoolean();
    }

    public byte[] nextBytes(byte[] array) {
        Intrinsics.h(array, "array");
        a().nextBytes(array);
        return array;
    }

    public double nextDouble() {
        return a().nextDouble();
    }

    public float nextFloat() {
        return a().nextFloat();
    }

    public int nextInt() {
        return a().nextInt();
    }

    public int nextInt(int until) {
        return a().nextInt(until);
    }

    public long nextLong() {
        return a().nextLong();
    }
}
