package org.mvel2.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class InternalNumber extends BigDecimal {
    public InternalNumber(double d) {
        super(d);
    }

    public InternalNumber(double d, MathContext mathContext) {
        super(d, mathContext);
    }

    public InternalNumber(int i) {
        super(i);
    }

    public InternalNumber(int i, MathContext mathContext) {
        super(i, mathContext);
    }

    public InternalNumber(long j) {
        super(j);
    }

    public InternalNumber(long j, MathContext mathContext) {
        super(j, mathContext);
    }

    public InternalNumber(String str) {
        super(str);
    }

    public InternalNumber(String str, MathContext mathContext) {
        super(str, mathContext);
    }

    public InternalNumber(BigInteger bigInteger) {
        super(bigInteger);
    }

    public InternalNumber(BigInteger bigInteger, int i) {
        super(bigInteger, i);
    }

    public InternalNumber(BigInteger bigInteger, int i, MathContext mathContext) {
        super(bigInteger, i, mathContext);
    }

    public InternalNumber(BigInteger bigInteger, MathContext mathContext) {
        super(bigInteger, mathContext);
    }

    public InternalNumber(char[] cArr) {
        super(cArr);
    }

    public InternalNumber(char[] cArr, int i, int i2) {
        super(cArr, i, i2);
    }

    public InternalNumber(char[] cArr, int i, int i2, MathContext mathContext) {
        super(cArr, i, i2, mathContext);
    }

    public InternalNumber(char[] cArr, MathContext mathContext) {
        super(cArr, mathContext);
    }
}
