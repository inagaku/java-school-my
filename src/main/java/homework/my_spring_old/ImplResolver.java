package homework.my_spring_old;

public interface ImplResolver {
    public <T> Class<T> resolveImpl(Class<T> type);
}
