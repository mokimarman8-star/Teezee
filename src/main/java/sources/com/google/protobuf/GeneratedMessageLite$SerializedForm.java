package com.google.protobuf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: protected */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class GeneratedMessageLite$SerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] asBytes;
    private final Class<?> messageClass;
    private final String messageClassName;

    GeneratedMessageLite$SerializedForm(s0 s0Var) {
        this.messageClass = s0Var.getClass();
        this.messageClassName = s0Var.getClass().getName();
        this.asBytes = s0Var.toByteArray();
    }

    public static GeneratedMessageLite$SerializedForm of(s0 s0Var) {
        return new GeneratedMessageLite$SerializedForm(s0Var);
    }

    @Deprecated
    private Object readResolveFallback() throws ObjectStreamException {
        try {
            Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
            declaredField.setAccessible(true);
            return ((s0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).mo54buildPartial();
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException("Unable to understand proto buffer", e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Unable to call parsePartialFrom", e3);
        } catch (NoSuchFieldException e4) {
            throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e4);
        } catch (SecurityException e5) {
            throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e5);
        }
    }

    private Class<?> resolveMessageClass() throws ClassNotFoundException {
        Class<?> cls = this.messageClass;
        return cls != null ? cls : Class.forName(this.messageClassName);
    }

    protected Object readResolve() throws ObjectStreamException {
        try {
            Field declaredField = resolveMessageClass().getDeclaredField("DEFAULT_INSTANCE");
            declaredField.setAccessible(true);
            return ((s0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).mo54buildPartial();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Unable to call parsePartialFrom", e2);
        } catch (NoSuchFieldException unused) {
            return readResolveFallback();
        } catch (SecurityException e3) {
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e3);
        } catch (InvalidProtocolBufferException e4) {
            throw new RuntimeException("Unable to understand proto buffer", e4);
        }
    }
}
