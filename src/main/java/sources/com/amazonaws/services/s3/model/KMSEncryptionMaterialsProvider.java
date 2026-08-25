package com.amazonaws.services.s3.model;

import java.io.Serializable;

@Deprecated
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class KMSEncryptionMaterialsProvider extends StaticEncryptionMaterialsProvider implements Serializable {
    public KMSEncryptionMaterialsProvider(KMSEncryptionMaterials kMSEncryptionMaterials) {
        super(kMSEncryptionMaterials);
    }

    public KMSEncryptionMaterialsProvider(String str) {
        this(new KMSEncryptionMaterials(str));
    }
}
