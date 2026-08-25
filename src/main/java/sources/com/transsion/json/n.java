package com.transsion.json;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class n extends Number {
    private final String a;
    final String b = "(\\p{Digit}+)";
    final String c = "(\\p{XDigit}+)";
    final String d = "[eE][+-]?(\\p{Digit}+)";
    final String e = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    public n(String str) {
        this.a = str;
    }

    private boolean f() {
        return this.a.startsWith("0x");
    }

    private boolean g() {
        return this.a.length() > 1 && this.a.charAt(0) == '0' && Character.isDigit(this.a.charAt(1));
    }

    public boolean a() {
        return this.a.matches("\\-?\\d+");
    }

    public Double b() {
        return Double.valueOf(Double.parseDouble(this.a));
    }

    public Float c() {
        return Float.valueOf(Float.parseFloat(this.a));
    }

    public Integer d() {
        return f() ? Integer.valueOf(Integer.parseInt(this.a.substring(2), 16)) : g() ? Integer.valueOf(Integer.parseInt(this.a.substring(1), 8)) : Integer.valueOf(Integer.parseInt(this.a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b().doubleValue();
    }

    public Long e() {
        return f() ? Long.valueOf(Long.parseLong(this.a.substring(2), 16)) : g() ? Long.valueOf(Long.parseLong(this.a.substring(1), 8)) : Long.valueOf(Long.parseLong(this.a));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return c().floatValue();
    }

    @Override // java.lang.Number
    public int intValue() {
        return d().intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return e().longValue();
    }
}
