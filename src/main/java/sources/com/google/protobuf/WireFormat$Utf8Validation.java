package com.google.protobuf;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
enum WireFormat$Utf8Validation {
    LOOSE { // from class: com.google.protobuf.WireFormat$Utf8Validation.1
        @Override // com.google.protobuf.WireFormat$Utf8Validation
        Object readString(i iVar) throws IOException {
            return iVar.readString();
        }
    },
    STRICT { // from class: com.google.protobuf.WireFormat$Utf8Validation.2
        @Override // com.google.protobuf.WireFormat$Utf8Validation
        Object readString(i iVar) throws IOException {
            return iVar.readStringRequireUtf8();
        }
    },
    LAZY { // from class: com.google.protobuf.WireFormat$Utf8Validation.3
        @Override // com.google.protobuf.WireFormat$Utf8Validation
        Object readString(i iVar) throws IOException {
            return iVar.readBytes();
        }
    };

    /* synthetic */ WireFormat$Utf8Validation(WireFormat$a wireFormat$a) {
        this();
    }

    abstract Object readString(i iVar) throws IOException;
}
