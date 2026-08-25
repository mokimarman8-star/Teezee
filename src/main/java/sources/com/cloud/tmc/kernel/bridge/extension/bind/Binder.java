package com.cloud.tmc.kernel.bridge.extension.bind;

import java.lang.annotation.Annotation;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface Binder<A extends Annotation, T> {
    T bind(Class<T> cls, A a) throws BindException;
}
