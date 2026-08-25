package com.transsion.baselib.db.video;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCVideoDetailPlayDao$DefaultImpls$getTypeHistoryDataOffset$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.d(Long.valueOf(((UGCVideoDetailPlayBean) t2).getTimeStamp()), Long.valueOf(((UGCVideoDetailPlayBean) t).getTimeStamp()));
    }
}
