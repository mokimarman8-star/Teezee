package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodePath;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class DecodeJob$DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
    private final DataSource dataSource;
    final /* synthetic */ DecodeJob this$0;

    DecodeJob$DecodeCallback(DecodeJob decodeJob, DataSource dataSource) {
        this.this$0 = decodeJob;
        this.dataSource = dataSource;
    }

    @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
    @NonNull
    public Resource<Z> onResourceDecoded(@NonNull Resource<Z> resource) {
        return this.this$0.onResourceDecoded(this.dataSource, resource);
    }
}
