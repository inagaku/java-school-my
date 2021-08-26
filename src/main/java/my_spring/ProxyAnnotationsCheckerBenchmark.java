package my_spring;

import java.util.Arrays;

public class ProxyAnnotationsCheckerBenchmark implements ProxyAnnotationsChecker {
    @Override
    public <T> T checkForAnnotation(T obj) {
        if (obj.getClass().isAnnotationPresent(Benchmark.class)) {
            ProxyObjectCreator proxyBenchmarkCreator = new ProxyBenchmarkCreator();
            return proxyBenchmarkCreator.createProxy(obj, false);
        }
        if (Arrays.stream(obj.getClass().getMethods())
                .anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {

            ProxyObjectCreator proxyBenchmarkCreator = new ProxyBenchmarkCreator();
            return proxyBenchmarkCreator.createProxy(obj, true);
        }
        return obj;
    }
}
