package com.google.protobuf;

import com.google.protobuf.WireFormat;
import com.google.protobuf.a;
import com.google.protobuf.e;
import com.google.protobuf.y;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class GeneratedMessageLite extends a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, GeneratedMessageLite> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected p1 unknownFields = p1.getDefaultInstance();

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends d, BuilderType, T> g checkIsLite(m mVar) {
        if (mVar.isLite()) {
            return (g) mVar;
        }
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    private static <T extends GeneratedMessageLite> T checkMessageInitialized(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.newUninitializedMessageException().asInvalidProtocolBufferException().setUnfinishedMessage(t);
    }

    private int computeSerializedSize(i1 i1Var) {
        return i1Var == null ? d1.getInstance().schemaFor(this).getSerializedSize(this) : i1Var.getSerializedSize(this);
    }

    protected static y.a emptyBooleanList() {
        return f.emptyList();
    }

    protected static y.b emptyDoubleList() {
        return l.emptyList();
    }

    protected static y.f emptyFloatList() {
        return u.emptyList();
    }

    protected static y.g emptyIntList() {
        return w.emptyList();
    }

    protected static y.i emptyLongList() {
        return k0.emptyList();
    }

    protected static <E> y.j emptyProtobufList() {
        return e1.emptyList();
    }

    private void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == p1.getDefaultInstance()) {
            this.unknownFields = p1.newInstance();
        }
    }

    static <T extends GeneratedMessageLite> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) s1.allocateInstance(cls)).m27getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends GeneratedMessageLite> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = d1.getInstance().schemaFor(t).isInitialized(t);
        if (z) {
            t.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? t : null);
        }
        return isInitialized;
    }

    protected static y.a mutableCopy(y.a aVar) {
        int size = aVar.size();
        return aVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.b mutableCopy(y.b bVar) {
        int size = bVar.size();
        return bVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.f mutableCopy(y.f fVar) {
        int size = fVar.size();
        return fVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.g mutableCopy(y.g gVar) {
        int size = gVar.size();
        return gVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static y.i mutableCopy(y.i iVar) {
        int size = iVar.size();
        return iVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static <E> y.j mutableCopy(y.j jVar) {
        int size = jVar.size();
        return jVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    protected static Object newMessageInfo(s0 s0Var, String str, Object[] objArr) {
        return new g1(s0Var, str, objArr);
    }

    public static <ContainingType extends s0, Type> g newRepeatedGeneratedExtension(ContainingType containingtype, s0 s0Var, y.d dVar, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new g(containingtype, Collections.emptyList(), s0Var, new f(dVar, i, fieldType, true, z), cls);
    }

    public static <ContainingType extends s0, Type> g newSingularGeneratedExtension(ContainingType containingtype, Type type, s0 s0Var, y.d dVar, int i, WireFormat.FieldType fieldType, Class cls) {
        return new g(containingtype, type, s0Var, new f(dVar, i, fieldType, false, false), cls);
    }

    protected static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, o.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite> T parseDelimitedFrom(T t, InputStream inputStream, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, oVar));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t, byteString, o.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, byteString, oVar));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, i iVar) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, iVar, o.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, i iVar, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, iVar, oVar));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, i.newInstance(inputStream), o.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, InputStream inputStream, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, i.newInstance(inputStream), oVar));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, byteBuffer, o.getEmptyRegistry());
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, ByteBuffer byteBuffer, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t, i.newInstance(byteBuffer), oVar));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, o.getEmptyRegistry()));
    }

    protected static <T extends GeneratedMessageLite> T parseFrom(T t, byte[] bArr, o oVar) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, oVar));
    }

    private static <T extends GeneratedMessageLite> T parsePartialDelimitedFrom(T t, InputStream inputStream, o oVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            i newInstance = i.newInstance(new a.a.a(inputStream, i.readRawVarint32(read, inputStream)));
            s0 parsePartialFrom = parsePartialFrom(t, newInstance, oVar);
            try {
                newInstance.checkLastTagWas(0);
                return parsePartialFrom;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(parsePartialFrom);
            }
        } catch (InvalidProtocolBufferException e3) {
            if (e3.getThrownFromInputStream()) {
                throw new InvalidProtocolBufferException((IOException) e3);
            }
            throw e3;
        } catch (IOException e4) {
            throw new InvalidProtocolBufferException(e4);
        }
    }

    private static <T extends GeneratedMessageLite> T parsePartialFrom(T t, ByteString byteString, o oVar) throws InvalidProtocolBufferException {
        i newCodedInput = byteString.newCodedInput();
        s0 parsePartialFrom = parsePartialFrom(t, newCodedInput, oVar);
        try {
            newCodedInput.checkLastTagWas(0);
            return parsePartialFrom;
        } catch (InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(parsePartialFrom);
        }
    }

    protected static <T extends GeneratedMessageLite> T parsePartialFrom(T t, i iVar) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t, iVar, o.getEmptyRegistry());
    }

    static <T extends GeneratedMessageLite> T parsePartialFrom(T t, i iVar, o oVar) throws InvalidProtocolBufferException {
        s0 newMutableInstance = t.newMutableInstance();
        try {
            i1 schemaFor = d1.getInstance().schemaFor(newMutableInstance);
            schemaFor.mergeFrom(newMutableInstance, j.forCodedInput(iVar), oVar);
            schemaFor.makeImmutable(newMutableInstance);
            return newMutableInstance;
        } catch (InvalidProtocolBufferException e) {
            e = e;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(newMutableInstance);
        } catch (IOException e3) {
            if (e3.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e3.getCause());
            }
            throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(newMutableInstance);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw e4;
        } catch (UninitializedMessageException e5) {
            throw e5.asInvalidProtocolBufferException().setUnfinishedMessage(newMutableInstance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends GeneratedMessageLite> T parsePartialFrom(T t, byte[] bArr, int i, int i2, o oVar) throws InvalidProtocolBufferException {
        s0 newMutableInstance = t.newMutableInstance();
        try {
            i1 schemaFor = d1.getInstance().schemaFor(newMutableInstance);
            schemaFor.mergeFrom(newMutableInstance, bArr, i, i + i2, new e.b(oVar));
            schemaFor.makeImmutable(newMutableInstance);
            return newMutableInstance;
        } catch (UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(newMutableInstance);
        } catch (InvalidProtocolBufferException e3) {
            e = e3;
            if (e.getThrownFromInputStream()) {
                e = new InvalidProtocolBufferException((IOException) e);
            }
            throw e.setUnfinishedMessage(newMutableInstance);
        } catch (IOException e4) {
            if (e4.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e4.getCause());
            }
            throw new InvalidProtocolBufferException(e4).setUnfinishedMessage(newMutableInstance);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.truncatedMessage().setUnfinishedMessage(newMutableInstance);
        }
    }

    protected static <T extends GeneratedMessageLite> void registerDefaultInstance(Class<T> cls, T t) {
        t.markImmutable();
        defaultInstanceMap.put(cls, t);
    }

    Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    void clearMemoizedHashCode() {
        ((a) this).memoizedHashCode = 0;
    }

    void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    int computeHashCode() {
        return d1.getInstance().schemaFor(this).hashCode(this);
    }

    protected final <MessageType extends GeneratedMessageLite, BuilderType extends b> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    protected final <MessageType extends GeneratedMessageLite, BuilderType extends b> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom(messagetype);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return d1.getInstance().schemaFor(this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    /* renamed from: getDefaultInstanceForType, reason: merged with bridge method [inline-methods] */
    public final GeneratedMessageLite m27getDefaultInstanceForType() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    int getMemoizedHashCode() {
        return ((a) this).memoizedHashCode;
    }

    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public final b1 getParserForType() {
        return (b1) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    int getSerializedSize(i1 i1Var) {
        if (!isMutable()) {
            if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
                return getMemoizedSerializedSize();
            }
            int computeSerializedSize = computeSerializedSize(i1Var);
            setMemoizedSerializedSize(computeSerializedSize);
            return computeSerializedSize;
        }
        int computeSerializedSize2 = computeSerializedSize(i1Var);
        if (computeSerializedSize2 >= 0) {
            return computeSerializedSize2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + computeSerializedSize2);
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    boolean isMutable() {
        return (this.memoizedSerializedSize & Integer.MIN_VALUE) != 0;
    }

    protected void makeImmutable() {
        d1.getInstance().schemaFor(this).makeImmutable(this);
        markImmutable();
    }

    void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    protected void mergeLengthDelimitedField(int i, ByteString byteString) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeLengthDelimitedField(i, byteString);
    }

    protected final void mergeUnknownFields(p1 p1Var) {
        this.unknownFields = p1.mutableCopyOf(this.unknownFields, p1Var);
    }

    protected void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        this.unknownFields.mergeVarintField(i, i2);
    }

    /* renamed from: newBuilderForType, reason: merged with bridge method [inline-methods] */
    public final b m28newBuilderForType() {
        return (b) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    GeneratedMessageLite newMutableInstance() {
        return (GeneratedMessageLite) dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
    }

    protected boolean parseUnknownField(int i, i iVar) throws IOException {
        if (WireFormat.getTagWireType(i) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.mergeFieldFrom(i, iVar);
    }

    void setMemoizedHashCode(int i) {
        ((a) this).memoizedHashCode = i;
    }

    void setMemoizedSerializedSize(int i) {
        if (i >= 0) {
            this.memoizedSerializedSize = (i & Integer.MAX_VALUE) | (this.memoizedSerializedSize & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i);
        }
    }

    /* renamed from: toBuilder, reason: merged with bridge method [inline-methods] */
    public final b m29toBuilder() {
        return ((b) dynamicMethod(MethodToInvoke.NEW_BUILDER)).mergeFrom(this);
    }

    public String toString() {
        return u0.toString(this, super/*java.lang.Object*/.toString());
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        d1.getInstance().schemaFor(this).writeTo(this, k.forCodedOutput(codedOutputStream));
    }
}
