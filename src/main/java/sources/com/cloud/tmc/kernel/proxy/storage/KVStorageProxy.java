package com.cloud.tmc.kernel.proxy.storage;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.proxy.Proxiable;

@DefaultImpl("com.cloud.tmc.integration.defaultImpl.TmcKVStorageImpl")
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface KVStorageProxy extends Proxiable {
    void clear(@NonNull Context context, @NonNull String str);

    String[] getAllKeys(@NonNull Context context, @NonNull String str);

    @Nullable
    boolean getBoolean(@NonNull Context context, @NonNull String str, @NonNull String str2, @Nullable boolean z);

    int getInt(@NonNull Context context, @NonNull String str, @NonNull String str2);

    long getKVSize(@NonNull Context context, @NonNull String str);

    long getLong(@NonNull Context context, @NonNull String str, @NonNull String str2);

    String[] getMMKVFileAllKeys(@NonNull Context context, @NonNull String str);

    @Nullable
    String getString(@NonNull Context context, @NonNull String str, @NonNull String str2);

    @Nullable
    void putBoolean(@NonNull Context context, @NonNull String str, @NonNull String str2, boolean z);

    void putInt(@NonNull Context context, @NonNull String str, @NonNull String str2, int i);

    void putLong(@NonNull Context context, @NonNull String str, @NonNull String str2, long j);

    void putString(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3);

    void remove(@NonNull Context context, @NonNull String str, @NonNull String str2);

    void warmUpMMKVFile(@NonNull Context context, @NonNull String str);
}
