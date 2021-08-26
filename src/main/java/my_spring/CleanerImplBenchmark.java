package my_spring;

public class CleanerImplBenchmark implements Cleaner{
    private Cleaner cleaner;

    CleanerImplBenchmark() {
        cleaner = ObjectFactory.getInstance().createObject(CleanerImpl.class);
    }

    @Override
    public void clean() {
        long from = System.nanoTime();
        cleaner.clean();
        System.out.println(System.nanoTime() - from);
    }
}
