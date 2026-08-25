package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface b1 {
    Object parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    Object parseDelimitedFrom(InputStream inputStream, o oVar) throws InvalidProtocolBufferException;

    Object parseFrom(ByteString byteString) throws InvalidProtocolBufferException;

    Object parseFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException;

    Object parseFrom(i iVar) throws InvalidProtocolBufferException;

    Object parseFrom(i iVar, o oVar) throws InvalidProtocolBufferException;

    Object parseFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    Object parseFrom(InputStream inputStream, o oVar) throws InvalidProtocolBufferException;

    Object parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException;

    Object parseFrom(ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException;

    Object parseFrom(byte[] bArr) throws InvalidProtocolBufferException;

    Object parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

    Object parseFrom(byte[] bArr, int i, int i2, o oVar) throws InvalidProtocolBufferException;

    Object parseFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException;

    Object parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    Object parsePartialDelimitedFrom(InputStream inputStream, o oVar) throws InvalidProtocolBufferException;

    Object parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException;

    Object parsePartialFrom(ByteString byteString, o oVar) throws InvalidProtocolBufferException;

    Object parsePartialFrom(i iVar) throws InvalidProtocolBufferException;

    Object parsePartialFrom(i iVar, o oVar) throws InvalidProtocolBufferException;

    Object parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    Object parsePartialFrom(InputStream inputStream, o oVar) throws InvalidProtocolBufferException;

    Object parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException;

    Object parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

    Object parsePartialFrom(byte[] bArr, int i, int i2, o oVar) throws InvalidProtocolBufferException;

    Object parsePartialFrom(byte[] bArr, o oVar) throws InvalidProtocolBufferException;
}
