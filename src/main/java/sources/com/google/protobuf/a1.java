package com.google.protobuf;

import java.lang.reflect.Field;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a1 {
    private final Field caseField;

    /* renamed from: id, reason: collision with root package name */
    private final int f1id;
    private final Field valueField;

    public a1(int i, Field field, Field field2) {
        this.f1id = i;
        this.caseField = field;
        this.valueField = field2;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public int getId() {
        return this.f1id;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
