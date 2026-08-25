package org.chromium.net;

import androidx.annotation.Nullable;
import java.time.Duration;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DnsOptions {

    @Nullable
    private final Boolean mEnableStaleDns;

    @Nullable
    private final Boolean mPersistHostCache;

    @Nullable
    private final Long mPersistHostCachePeriodMillis;

    @Nullable
    private final Boolean mPreestablishConnectionsToStaleDnsResults;

    @Nullable
    private final StaleDnsOptions mStaleDnsOptions;

    @Nullable
    private final Boolean mUseBuiltInDnsResolver;

    public static final class Builder {

        @Nullable
        private Boolean mEnableStaleDns;

        @Nullable
        private Boolean mPersistHostCache;

        @Nullable
        private Long mPersistHostCachePeriodMillis;

        @Nullable
        private Boolean mPreestablishConnectionsToStaleDnsResults;

        @Nullable
        private StaleDnsOptions mStaleDnsOptions;

        @Nullable
        private Boolean mUseBuiltInDnsResolver;

        Builder() {
        }

        public DnsOptions build() {
            return new DnsOptions(this);
        }

        public Builder enableStaleDns(boolean z) {
            this.mEnableStaleDns = Boolean.valueOf(z);
            return this;
        }

        public Builder persistHostCache(boolean z) {
            this.mPersistHostCache = Boolean.valueOf(z);
            return this;
        }

        @Experimental
        public Builder preestablishConnectionsToStaleDnsResults(boolean z) {
            this.mPreestablishConnectionsToStaleDnsResults = Boolean.valueOf(z);
            return this;
        }

        public Builder setPersistDelay(Duration duration) {
            return setPersistHostCachePeriodMillis(com.google.android.gms.measurement.internal.b.a(duration));
        }

        public Builder setPersistHostCachePeriodMillis(long j) {
            this.mPersistHostCachePeriodMillis = Long.valueOf(j);
            return this;
        }

        @Experimental
        public Builder setStaleDnsOptions(StaleDnsOptions.Builder builder) {
            return setStaleDnsOptions(builder.build());
        }

        public Builder setStaleDnsOptions(StaleDnsOptions staleDnsOptions) {
            this.mStaleDnsOptions = staleDnsOptions;
            return this;
        }

        public Builder useBuiltInDnsResolver(boolean z) {
            this.mUseBuiltInDnsResolver = Boolean.valueOf(z);
            return this;
        }
    }

    public @interface Experimental {
    }

    public static class StaleDnsOptions {

        @Nullable
        private final Boolean mAllowCrossNetworkUsage;

        @Nullable
        private final Long mFreshLookupTimeoutMillis;

        @Nullable
        private final Long mMaxExpiredDelayMillis;

        @Nullable
        private final Boolean mUseStaleOnNameNotResolved;

        public static final class Builder {
            private Boolean mAllowCrossNetworkUsage;
            private Long mFreshLookupTimeoutMillis;
            private Long mMaxExpiredDelayMillis;
            private Boolean mUseStaleOnNameNotResolved;

            Builder() {
            }

            public Builder allowCrossNetworkUsage(boolean z) {
                this.mAllowCrossNetworkUsage = Boolean.valueOf(z);
                return this;
            }

            public StaleDnsOptions build() {
                return new StaleDnsOptions(this);
            }

            public Builder setFreshLookupTimeout(Duration duration) {
                return setFreshLookupTimeoutMillis(com.google.android.gms.measurement.internal.b.a(duration));
            }

            public Builder setFreshLookupTimeoutMillis(long j) {
                this.mFreshLookupTimeoutMillis = Long.valueOf(j);
                return this;
            }

            public Builder setMaxExpiredDelayMillis(long j) {
                this.mMaxExpiredDelayMillis = Long.valueOf(j);
                return this;
            }

            public Builder setMaxExpiredDelayMillis(Duration duration) {
                return setMaxExpiredDelayMillis(com.google.android.gms.measurement.internal.b.a(duration));
            }

            public Builder useStaleOnNameNotResolved(boolean z) {
                this.mUseStaleOnNameNotResolved = Boolean.valueOf(z);
                return this;
            }
        }

        StaleDnsOptions(Builder builder) {
            this.mFreshLookupTimeoutMillis = builder.mFreshLookupTimeoutMillis;
            this.mMaxExpiredDelayMillis = builder.mMaxExpiredDelayMillis;
            this.mAllowCrossNetworkUsage = builder.mAllowCrossNetworkUsage;
            this.mUseStaleOnNameNotResolved = builder.mUseStaleOnNameNotResolved;
        }

        public static Builder builder() {
            return new Builder();
        }

        @Nullable
        public Boolean getAllowCrossNetworkUsage() {
            return this.mAllowCrossNetworkUsage;
        }

        @Nullable
        public Long getFreshLookupTimeoutMillis() {
            return this.mFreshLookupTimeoutMillis;
        }

        @Nullable
        public Long getMaxExpiredDelayMillis() {
            return this.mMaxExpiredDelayMillis;
        }

        @Nullable
        public Boolean getUseStaleOnNameNotResolved() {
            return this.mUseStaleOnNameNotResolved;
        }
    }

    DnsOptions(Builder builder) {
        this.mEnableStaleDns = builder.mEnableStaleDns;
        this.mStaleDnsOptions = builder.mStaleDnsOptions;
        this.mPersistHostCachePeriodMillis = builder.mPersistHostCachePeriodMillis;
        this.mPreestablishConnectionsToStaleDnsResults = builder.mPreestablishConnectionsToStaleDnsResults;
        this.mUseBuiltInDnsResolver = builder.mUseBuiltInDnsResolver;
        this.mPersistHostCache = builder.mPersistHostCache;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public Boolean getEnableStaleDns() {
        return this.mEnableStaleDns;
    }

    @Nullable
    public Boolean getPersistHostCache() {
        return this.mPersistHostCache;
    }

    @Nullable
    public Long getPersistHostCachePeriodMillis() {
        return this.mPersistHostCachePeriodMillis;
    }

    @Nullable
    public Boolean getPreestablishConnectionsToStaleDnsResults() {
        return this.mPreestablishConnectionsToStaleDnsResults;
    }

    @Nullable
    public StaleDnsOptions getStaleDnsOptions() {
        return this.mStaleDnsOptions;
    }

    @Nullable
    public Boolean getUseBuiltInDnsResolver() {
        return this.mUseBuiltInDnsResolver;
    }
}
