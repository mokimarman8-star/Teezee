package com.cloud.tmc.kernel.datastructure.immutable;

import android.os.Bundle;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class ImmutableBundle implements Immutable<Bundle> {
    private Bundle immutable;

    public ImmutableBundle(Bundle bundle) {
        this.immutable = bundle;
    }

    public boolean containsKey(String str) {
        Bundle bundle = this.immutable;
        return bundle != null && bundle.containsKey(str);
    }

    public boolean getBoolean(String str, boolean z) {
        Bundle bundle = this.immutable;
        return bundle != null ? bundle.getBoolean(str, z) : z;
    }

    public double getDouble(String str, double d) {
        Bundle bundle = this.immutable;
        return bundle != null ? bundle.getDouble(str, d) : d;
    }

    public int getInt(String str, int i) {
        Bundle bundle = this.immutable;
        return bundle != null ? bundle.getInt(str, i) : i;
    }

    public long getLong(String str, long j) {
        Bundle bundle = this.immutable;
        return bundle != null ? bundle.getLong(str, j) : j;
    }

    public String getString(String str, String str2) {
        Bundle bundle = this.immutable;
        return bundle != null ? bundle.getString(str, str2) : str2;
    }

    public boolean isEmpty() {
        Bundle bundle = this.immutable;
        return bundle == null || bundle.isEmpty();
    }

    public ImmutableSet<String> keySet() {
        if (this.immutable != null) {
            return new ImmutableSet<>(this.immutable.keySet());
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.cloud.tmc.kernel.datastructure.immutable.Immutable
    public Bundle mutable() {
        return new Bundle(this.immutable);
    }

    public int size() {
        Bundle bundle = this.immutable;
        if (bundle != null) {
            return bundle.size();
        }
        return 0;
    }

    public String toString() {
        if (this.immutable == null) {
            return "ImmutableBundle{NULL}";
        }
        return "ImmutableBundle{" + this.immutable.toString() + "}";
    }
}
