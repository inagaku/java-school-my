package homework.devices;

public class RadioAlarm implements StandartAlarm, StandartRadio{
    @Override
    public void a() {
        System.out.println("Method A");
    }

    @Override
    public void b() {
        System.out.println("Method C");
    }

    @Override
    public void c() {
        System.out.println("Method C");
    }

    @Override
    public void d() {
        System.out.println("Method D");
    }
}
