package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface i0 extends f1 {
    void add(ByteString byteString);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends ByteString> collection);

    List<byte[]> asByteArrayList();

    @Override // com.google.protobuf.f1
    /* synthetic */ List asByteStringList();

    byte[] getByteArray(int i);

    ByteString getByteString(int i);

    Object getRaw(int i);

    List<?> getUnderlyingElements();

    i0 getUnmodifiableView();

    void mergeFrom(i0 i0Var);

    void set(int i, ByteString byteString);

    void set(int i, byte[] bArr);
}
