package com.cloud.tmc.kernel.node;

import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface DataNode extends Node {
    @Nullable
    <T> T getData(Class<T> cls);

    <T> T getData(Class<T> cls, boolean z);

    <T> void setData(Class<T> cls, T t);
}
