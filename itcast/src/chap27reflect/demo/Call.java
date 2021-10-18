package chap27reflect.demo;

import java.io.Serializable;

public class Call implements Serializable {
    private static final long seriavalVersionUID = 5645645615615411554L;
    String className; // 类名或接口名
    String methodName; // 方法名
    Class[] paramTypes; // 方法参数类型
    Object[] params; // 方法参数值

    // 表示方法的执行结果, 如果正常则返回result, 如果方法跑出异常, 则result为该异常
    private Object result;

    public Call() {
    }

    public Call(String className, String methodName, Class[] paramTypes, Object[] params) {
        this.className = className;
        this.methodName = methodName;
        this.paramTypes = paramTypes;
        this.params = params;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Call{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
