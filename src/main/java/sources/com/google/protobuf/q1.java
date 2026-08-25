package com.google.protobuf;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class q1 extends o1 {
    q1() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void addFixed32(p1 p1Var, int i, int i2) {
        p1Var.storeField(WireFormat.makeTag(i, 5), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void addFixed64(p1 p1Var, int i, long j) {
        p1Var.storeField(WireFormat.makeTag(i, 1), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void addGroup(p1 p1Var, int i, p1 p1Var2) {
        p1Var.storeField(WireFormat.makeTag(i, 3), p1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void addLengthDelimited(p1 p1Var, int i, ByteString byteString) {
        p1Var.storeField(WireFormat.makeTag(i, 2), byteString);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void addVarint(p1 p1Var, int i, long j) {
        p1Var.storeField(WireFormat.makeTag(i, 0), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public p1 getBuilderFromMessage(Object obj) {
        p1 fromMessage = getFromMessage(obj);
        if (fromMessage != p1.getDefaultInstance()) {
            return fromMessage;
        }
        p1 newInstance = p1.newInstance();
        setToMessage(obj, newInstance);
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public p1 getFromMessage(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public int getSerializedSize(p1 p1Var) {
        return p1Var.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public int getSerializedSizeAsMessageSet(p1 p1Var) {
        return p1Var.getSerializedSizeAsMessageSet();
    }

    @Override // com.google.protobuf.o1
    void makeImmutable(Object obj) {
        getFromMessage(obj).makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public p1 merge(p1 p1Var, p1 p1Var2) {
        return p1.getDefaultInstance().equals(p1Var2) ? p1Var : p1.getDefaultInstance().equals(p1Var) ? p1.mutableCopyOf(p1Var, p1Var2) : p1Var.mergeFrom(p1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public p1 newBuilder() {
        return p1.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void setBuilderToMessage(Object obj, p1 p1Var) {
        setToMessage(obj, p1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void setToMessage(Object obj, p1 p1Var) {
        ((GeneratedMessageLite) obj).unknownFields = p1Var;
    }

    @Override // com.google.protobuf.o1
    boolean shouldDiscardUnknownFields(h1 h1Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public p1 toImmutable(p1 p1Var) {
        p1Var.makeImmutable();
        return p1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void writeAsMessageSetTo(p1 p1Var, Writer writer) throws IOException {
        p1Var.writeAsMessageSetTo(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.o1
    public void writeTo(p1 p1Var, Writer writer) throws IOException {
        p1Var.writeTo(writer);
    }
}
