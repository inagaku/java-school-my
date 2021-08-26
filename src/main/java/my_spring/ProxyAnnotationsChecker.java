package my_spring;

public interface ProxyAnnotationsChecker {
    public <T> T checkForAnnotation(T obj);
}
