package org.mvel2.integration.impl;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.Function;
import org.mvel2.integration.VariableResolver;
import org.mvel2.integration.VariableResolverFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class FunctionVariableResolverFactory extends BaseVariableResolverFactory {
    private Function function;
    private boolean noTilt = false;

    public FunctionVariableResolverFactory(Function function, VariableResolverFactory variableResolverFactory, String[] strArr, Object[] objArr) {
        this.function = function;
        this.variableResolvers = new HashMap();
        this.nextFactory = variableResolverFactory;
        this.indexedVariableNames = strArr;
        this.indexedVariableResolvers = new VariableResolver[strArr.length];
        for (int i = 0; i < objArr.length; i++) {
            this.variableResolvers.put(this.indexedVariableNames[i], null);
            this.indexedVariableResolvers[i] = new SimpleValueResolver(objArr[i]);
        }
    }

    private int increaseRegisterTableSize() {
        String[] strArr = this.indexedVariableNames;
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        int length = strArr.length;
        int i = length + 1;
        this.indexedVariableNames = new String[i];
        this.indexedVariableResolvers = new VariableResolver[i];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.indexedVariableNames[i2] = strArr[i2];
            this.indexedVariableResolvers[i2] = variableResolverArr[i2];
        }
        return length;
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver createIndexedVariable(int i, String str, Object obj) {
        int i2 = i - this.indexOffset;
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        VariableResolver variableResolver = variableResolverArr[i2];
        if (variableResolver != null) {
            variableResolver.setValue(obj);
        } else {
            variableResolverArr[i2] = new SimpleValueResolver(obj);
        }
        this.variableResolvers.put(str, null);
        return this.indexedVariableResolvers[i2];
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver createIndexedVariable(int i, String str, Object obj, Class<?> cls) {
        int i2 = i - this.indexOffset;
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        VariableResolver variableResolver = variableResolverArr[i2];
        if (variableResolver != null) {
            variableResolver.setValue(obj);
        } else {
            variableResolverArr[i2] = new SimpleValueResolver(obj);
        }
        return this.indexedVariableResolvers[i2];
    }

    @Override // org.mvel2.integration.VariableResolverFactory
    public VariableResolver createVariable(String str, Object obj) {
        VariableResolver variableResolver = getVariableResolver(str);
        if (variableResolver != null) {
            variableResolver.setValue(obj);
            return variableResolver;
        }
        int increaseRegisterTableSize = increaseRegisterTableSize();
        this.indexedVariableNames[increaseRegisterTableSize] = str;
        this.indexedVariableResolvers[increaseRegisterTableSize] = new SimpleValueResolver(obj);
        this.variableResolvers.put(str, null);
        return this.indexedVariableResolvers[increaseRegisterTableSize];
    }

    @Override // org.mvel2.integration.VariableResolverFactory
    public VariableResolver createVariable(String str, Object obj, Class<?> cls) {
        Map<String, VariableResolver> map = this.variableResolvers;
        VariableResolver variableResolver = map != null ? map.get(str) : null;
        if (variableResolver == null || variableResolver.getType() == null) {
            return createIndexedVariable(variableIndexOf(str), str, obj);
        }
        throw new RuntimeException("variable already defined within scope: " + variableResolver.getType() + " " + str);
    }

    public Function getFunction() {
        return this.function;
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver getIndexedVariableResolver(int i) {
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        VariableResolver variableResolver = variableResolverArr[i];
        if (variableResolver != null) {
            return variableResolver;
        }
        VariableResolver variableResolver2 = super.getVariableResolver(this.indexedVariableNames[i]);
        variableResolverArr[i] = variableResolver2;
        return variableResolver2;
    }

    public VariableResolver[] getIndexedVariableResolvers() {
        return this.indexedVariableResolvers;
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public VariableResolver getVariableResolver(String str) {
        int variableIndexOf = variableIndexOf(str);
        if (variableIndexOf == -1) {
            return super.getVariableResolver(str);
        }
        VariableResolver[] variableResolverArr = this.indexedVariableResolvers;
        if (variableResolverArr[variableIndexOf] == null) {
            variableResolverArr[variableIndexOf] = new SimpleValueResolver(null);
        }
        this.variableResolvers.put(this.indexedVariableNames[variableIndexOf], null);
        return this.indexedVariableResolvers[variableIndexOf];
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public boolean isIndexedFactory() {
        return true;
    }

    @Override // org.mvel2.integration.VariableResolverFactory
    public boolean isResolveable(String str) {
        VariableResolverFactory variableResolverFactory;
        return this.variableResolvers.containsKey(str) || ((variableResolverFactory = this.nextFactory) != null && variableResolverFactory.isResolveable(str));
    }

    @Override // org.mvel2.integration.VariableResolverFactory
    public boolean isTarget(String str) {
        return this.variableResolvers.containsKey(str) || variableIndexOf(str) != -1;
    }

    public void setIndexOffset(int i) {
        this.indexOffset = i;
    }

    public void setIndexedVariableResolvers(VariableResolver[] variableResolverArr) {
        this.indexedVariableResolvers = variableResolverArr;
    }

    public VariableResolverFactory setNoTilt(boolean z) {
        this.noTilt = z;
        return this;
    }

    @Override // org.mvel2.integration.impl.BaseVariableResolverFactory, org.mvel2.integration.VariableResolverFactory
    public void setTiltFlag(boolean z) {
        if (this.noTilt) {
            return;
        }
        super.setTiltFlag(z);
    }

    public void updateParameters(Object[] objArr) {
        for (int i = 0; i < objArr.length; i++) {
            this.indexedVariableResolvers[i] = new SimpleValueResolver(objArr[i]);
        }
    }
}
