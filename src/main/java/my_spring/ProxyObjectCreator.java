package my_spring;

public interface ProxyObjectCreator {
    public <T> T createProxy(T obj, boolean filterMethods);
}
