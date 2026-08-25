package androidx.datastore.preferences.protobuf;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface n0 extends o0 {

    public interface a extends o0, Cloneable {
        n0 buildPartial();

        a mergeFrom(byte[] bArr);
    }

    void a(CodedOutputStream codedOutputStream);

    v0 getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    byte[] toByteArray();

    ByteString toByteString();
}
