package my_spring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyBenchmarkCreator implements ProxyObjectCreator {
    @Override
    public <T> T createProxy(T obj, boolean methodBenchmarkFlag) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader()
                , obj.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object retVal = null;
                        if (!methodBenchmarkFlag || methodBenchmarkFlag && obj.getClass().getMethod(method.getName()).isAnnotationPresent(Benchmark.class)) {
                            System.out.println("********BENCHMARK STARTED FOR METHOD " + method.getName() + " **********");
                            long start = System.nanoTime();
                            retVal = method.invoke(obj, args);
                            long end = System.nanoTime();
                            System.out.println(end - start);

                            System.out.println("********BENCHMARK ENDED FOR METHOD " + method.getName() + " **********");
                        } else {
                            retVal = method.invoke(obj, args);
                        }

                        return retVal;
                    }
                }
        );
    }
}
