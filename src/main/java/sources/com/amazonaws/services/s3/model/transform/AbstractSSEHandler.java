package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
abstract class AbstractSSEHandler extends AbstractHandler implements ServerSideEncryptionResult {
    AbstractSSEHandler() {
    }

    protected abstract ServerSideEncryptionResult f();

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void setSSEAlgorithm(String str) {
        ServerSideEncryptionResult f = f();
        if (f != null) {
            f.setSSEAlgorithm(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void setSSECustomerAlgorithm(String str) {
        ServerSideEncryptionResult f = f();
        if (f != null) {
            f.setSSECustomerAlgorithm(str);
        }
    }

    @Override // com.amazonaws.services.s3.internal.ServerSideEncryptionResult
    public final void setSSECustomerKeyMd5(String str) {
        ServerSideEncryptionResult f = f();
        if (f != null) {
            f.setSSECustomerKeyMd5(str);
        }
    }
}
