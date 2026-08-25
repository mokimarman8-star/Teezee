package org.chromium.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.net.CronetEngine;
import org.chromium.net.DnsOptions;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class e extends ICronetEngineBuilder {
    private static final Set d = Collections.unmodifiableSet(new HashSet(Arrays.asList(1, 2, 3)));
    private JSONObject a;
    private final List b = new ArrayList();
    private final ICronetEngineBuilder c;

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        void a(JSONObject jSONObject);
    }

    e(ICronetEngineBuilder iCronetEngineBuilder) {
        this.c = iCronetEngineBuilder;
    }

    private static JSONObject d(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                jSONObject.put(str, optJSONObject);
            } catch (JSONException e) {
                throw new IllegalArgumentException("Failed adding a default object for key [" + str + "]", e);
            }
        }
        return optJSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ConnectionMigrationOptions connectionMigrationOptions, JSONObject jSONObject) {
        JSONObject d2 = d(jSONObject, "QUIC");
        if (connectionMigrationOptions.getEnableDefaultNetworkMigration() != null) {
            d2.put("migrate_sessions_on_network_change_v2", connectionMigrationOptions.getEnableDefaultNetworkMigration());
        }
        if (connectionMigrationOptions.getAllowServerMigration() != null) {
            d2.put("allow_server_migration", connectionMigrationOptions.getAllowServerMigration());
        }
        if (connectionMigrationOptions.getMigrateIdleConnections() != null) {
            d2.put("migrate_idle_sessions", connectionMigrationOptions.getMigrateIdleConnections());
        }
        if (connectionMigrationOptions.getIdleMigrationPeriodSeconds() != null) {
            d2.put("idle_session_migration_period_seconds", connectionMigrationOptions.getIdleMigrationPeriodSeconds());
        }
        if (connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork() != null) {
            d2.put("retry_on_alternate_network_before_handshake", connectionMigrationOptions.getRetryPreHandshakeErrorsOnAlternateNetwork());
        }
        if (connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds() != null) {
            d2.put("max_time_on_non_default_network_seconds", connectionMigrationOptions.getMaxTimeOnNonDefaultNetworkSeconds());
        }
        if (connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount() != null) {
            d2.put("max_migrations_to_non_default_network_on_path_degrading", connectionMigrationOptions.getMaxPathDegradingEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount() != null) {
            d2.put("max_migrations_to_non_default_network_on_write_error", connectionMigrationOptions.getMaxWriteErrorEagerMigrationsCount());
        }
        if (connectionMigrationOptions.getEnablePathDegradationMigration() != null) {
            boolean booleanValue = connectionMigrationOptions.getEnablePathDegradationMigration().booleanValue();
            if (connectionMigrationOptions.getAllowNonDefaultNetworkUsage() != null) {
                boolean booleanValue2 = connectionMigrationOptions.getAllowNonDefaultNetworkUsage().booleanValue();
                if (!booleanValue && booleanValue2) {
                    throw new IllegalArgumentException("Unable to turn on non-default network usage without path degradation migration!");
                }
                if (booleanValue && booleanValue2) {
                    d2.put("migrate_sessions_early_v2", true);
                    return;
                }
                d2.put("migrate_sessions_early_v2", false);
            }
            d2.put("allow_port_migration", booleanValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(DnsOptions dnsOptions, JSONObject jSONObject) {
        JSONObject d2 = d(jSONObject, "AsyncDNS");
        if (dnsOptions.getUseBuiltInDnsResolver() != null) {
            d2.put("enable", dnsOptions.getUseBuiltInDnsResolver());
        }
        JSONObject d3 = d(jSONObject, "StaleDNS");
        if (dnsOptions.getEnableStaleDns() != null) {
            d3.put("enable", dnsOptions.getEnableStaleDns());
        }
        if (dnsOptions.getPersistHostCache() != null) {
            d3.put("persist_to_disk", dnsOptions.getPersistHostCache());
        }
        if (dnsOptions.getPersistHostCachePeriodMillis() != null) {
            d3.put("persist_delay_ms", dnsOptions.getPersistHostCachePeriodMillis());
        }
        if (dnsOptions.getStaleDnsOptions() != null) {
            DnsOptions.StaleDnsOptions staleDnsOptions = dnsOptions.getStaleDnsOptions();
            if (staleDnsOptions.getAllowCrossNetworkUsage() != null) {
                d3.put("allow_other_network", staleDnsOptions.getAllowCrossNetworkUsage());
            }
            if (staleDnsOptions.getFreshLookupTimeoutMillis() != null) {
                d3.put("delay_ms", staleDnsOptions.getFreshLookupTimeoutMillis());
            }
            if (staleDnsOptions.getUseStaleOnNameNotResolved() != null) {
                d3.put("use_stale_on_name_not_resolved", staleDnsOptions.getUseStaleOnNameNotResolved());
            }
            if (staleDnsOptions.getMaxExpiredDelayMillis() != null) {
                d3.put("max_expired_time_ms", staleDnsOptions.getMaxExpiredDelayMillis());
            }
        }
        JSONObject d4 = d(jSONObject, "QUIC");
        if (dnsOptions.getPreestablishConnectionsToStaleDnsResults() != null) {
            d4.put("race_stale_dns_on_connection", dnsOptions.getPreestablishConnectionsToStaleDnsResults());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(QuicOptions quicOptions, JSONObject jSONObject) {
        JSONObject d2 = d(jSONObject, "QUIC");
        if (!quicOptions.getQuicHostAllowlist().isEmpty()) {
            d2.put("host_whitelist", org.chromium.net.a.a(",", quicOptions.getQuicHostAllowlist()));
        }
        if (!quicOptions.getEnabledQuicVersions().isEmpty()) {
            d2.put("quic_version", org.chromium.net.a.a(",", quicOptions.getEnabledQuicVersions()));
        }
        if (!quicOptions.getConnectionOptions().isEmpty()) {
            d2.put("connection_options", org.chromium.net.a.a(",", quicOptions.getConnectionOptions()));
        }
        if (!quicOptions.getClientConnectionOptions().isEmpty()) {
            d2.put("client_connection_options", org.chromium.net.a.a(",", quicOptions.getClientConnectionOptions()));
        }
        if (!quicOptions.getExtraQuicheFlags().isEmpty()) {
            d2.put("set_quic_flags", org.chromium.net.a.a(",", quicOptions.getExtraQuicheFlags()));
        }
        if (quicOptions.getInMemoryServerConfigsCacheSize() != null) {
            d2.put("max_server_configs_stored_in_properties", quicOptions.getInMemoryServerConfigsCacheSize());
        }
        if (quicOptions.getHandshakeUserAgent() != null) {
            d2.put("user_agent_id", quicOptions.getHandshakeUserAgent());
        }
        if (quicOptions.getRetryWithoutAltSvcOnQuicErrors() != null) {
            d2.put("retry_without_alt_svc_on_quic_errors", quicOptions.getRetryWithoutAltSvcOnQuicErrors());
        }
        if (quicOptions.getEnableTlsZeroRtt() != null) {
            d2.put("disable_tls_zero_rtt", !quicOptions.getEnableTlsZeroRtt().booleanValue());
        }
        if (quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds() != null) {
            d2.put("max_idle_time_before_crypto_handshake_seconds", quicOptions.getPreCryptoHandshakeIdleTimeoutSeconds());
        }
        if (quicOptions.getCryptoHandshakeTimeoutSeconds() != null) {
            d2.put("max_time_before_crypto_handshake_seconds", quicOptions.getCryptoHandshakeTimeoutSeconds());
        }
        if (quicOptions.getIdleConnectionTimeoutSeconds() != null) {
            d2.put("idle_connection_timeout_seconds", quicOptions.getIdleConnectionTimeoutSeconds());
        }
        if (quicOptions.getRetransmittableOnWireTimeoutMillis() != null) {
            d2.put("retransmittable_on_wire_timeout_milliseconds", quicOptions.getRetransmittableOnWireTimeoutMillis());
        }
        if (quicOptions.getCloseSessionsOnIpChange() != null) {
            d2.put("close_sessions_on_ip_change", quicOptions.getCloseSessionsOnIpChange());
        }
        if (quicOptions.getGoawaySessionsOnIpChange() != null) {
            d2.put("goaway_sessions_on_ip_change", quicOptions.getGoawaySessionsOnIpChange());
        }
        if (quicOptions.getInitialBrokenServicePeriodSeconds() != null) {
            d2.put("initial_delay_for_broken_alternative_service_seconds", quicOptions.getInitialBrokenServicePeriodSeconds());
        }
        if (quicOptions.getIncreaseBrokenServicePeriodExponentially() != null) {
            d2.put("exponential_backoff_on_initial_delay", quicOptions.getIncreaseBrokenServicePeriodExponentially());
        }
        if (quicOptions.getDelayJobsWithAvailableSpdySession() != null) {
            d2.put("delay_main_job_with_available_spdy_session", quicOptions.getDelayJobsWithAvailableSpdySession());
        }
    }

    private static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Experimental options parsing failed", e);
        }
    }

    public ICronetEngineBuilder addPublicKeyPins(String str, Set set, boolean z, Date date) {
        this.c.addPublicKeyPins(str, set, z, date);
        return this;
    }

    public ICronetEngineBuilder addQuicHint(String str, int i, int i2) {
        this.c.addQuicHint(str, i, i2);
        return this;
    }

    public ExperimentalCronetEngine build() {
        if (this.a == null && this.b.isEmpty()) {
            return this.c.build();
        }
        if (this.a == null) {
            this.a = new JSONObject();
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).a(this.a);
            } catch (JSONException e) {
                throw new IllegalStateException("Unable to apply JSON patch!", e);
            }
        }
        this.c.setExperimentalOptions(this.a.toString());
        return this.c.build();
    }

    public ICronetEngineBuilder enableBrotli(boolean z) {
        this.c.enableBrotli(z);
        return this;
    }

    public ICronetEngineBuilder enableHttp2(boolean z) {
        this.c.enableHttp2(z);
        return this;
    }

    public ICronetEngineBuilder enableHttpCache(int i, long j) {
        this.c.enableHttpCache(i, j);
        return this;
    }

    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z) {
        this.c.enableNetworkQualityEstimator(z);
        return this;
    }

    public ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z) {
        this.c.enablePublicKeyPinningBypassForLocalTrustAnchors(z);
        return this;
    }

    public ICronetEngineBuilder enableQuic(boolean z) {
        this.c.enableQuic(z);
        return this;
    }

    public ICronetEngineBuilder enableSdch(boolean z) {
        this.c.enableSdch(z);
        return this;
    }

    public String getDefaultUserAgent() {
        return this.c.getDefaultUserAgent();
    }

    protected Set getSupportedConfigOptions() {
        return d;
    }

    public ICronetEngineBuilder setConnectionMigrationOptions(final ConnectionMigrationOptions connectionMigrationOptions) {
        if (this.c.getSupportedConfigOptions().contains(1)) {
            this.c.setConnectionMigrationOptions(connectionMigrationOptions);
            return this;
        }
        this.b.add(new a() { // from class: org.chromium.net.c
            @Override // org.chromium.net.e.a
            public final void a(JSONObject jSONObject) {
                e.e(ConnectionMigrationOptions.this, jSONObject);
            }
        });
        return this;
    }

    public ICronetEngineBuilder setDnsOptions(final DnsOptions dnsOptions) {
        if (this.c.getSupportedConfigOptions().contains(2)) {
            this.c.setDnsOptions(dnsOptions);
            return this;
        }
        this.b.add(new a() { // from class: org.chromium.net.b
            @Override // org.chromium.net.e.a
            public final void a(JSONObject jSONObject) {
                e.f(DnsOptions.this, jSONObject);
            }
        });
        return this;
    }

    public ICronetEngineBuilder setExperimentalOptions(String str) {
        if (str == null || str.isEmpty()) {
            this.a = null;
        } else {
            this.a = h(str);
        }
        return this;
    }

    public ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader) {
        this.c.setLibraryLoader(libraryLoader);
        return this;
    }

    public ICronetEngineBuilder setQuicOptions(final QuicOptions quicOptions) {
        if (this.c.getSupportedConfigOptions().contains(3)) {
            this.c.setQuicOptions(quicOptions);
            return this;
        }
        this.b.add(new a() { // from class: org.chromium.net.d
            @Override // org.chromium.net.e.a
            public final void a(JSONObject jSONObject) {
                e.g(QuicOptions.this, jSONObject);
            }
        });
        return this;
    }

    public ICronetEngineBuilder setStoragePath(String str) {
        this.c.setStoragePath(str);
        return this;
    }

    public ICronetEngineBuilder setThreadPriority(int i) {
        this.c.setThreadPriority(i);
        return this;
    }

    public ICronetEngineBuilder setUserAgent(String str) {
        this.c.setUserAgent(str);
        return this;
    }
}
