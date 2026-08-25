package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class ImmutableAsList<E> extends ImmutableList<E> {

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableCollection<?> collection;

        SerializedForm(ImmutableCollection<?> immutableCollection) {
            this.collection = immutableCollection;
        }

        Object readResolve() {
            return this.collection.asList();
        }
    }

    ImmutableAsList() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    abstract ImmutableCollection<E> delegateCollection();

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    boolean isPartialView() {
        return delegateCollection().isPartialView();
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return delegateCollection().size();
    }

    @Override // com.google.common.collect.ImmutableList
    Object writeReplace() {
        return new SerializedForm(delegateCollection());
    }
}
