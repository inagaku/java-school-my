package homework.lab2;

import lombok.ToString;

@ToString
public class Client {
    private final int debt;
    private final int bonus;
    private final String name;
    private final int salary;

    public static class Builder {
        private int debt;
        private int bonus;
        private String name;
        private int salary;

        public Client clientBuild() {
            return new Client(this);
        }

        public Builder setDebt(int debt) {
            this.debt = debt;
            return this;
        }

        public Builder setBonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSalary(int salary) {
            this.salary = salary;
            return this;
        }
    }

    Client(Builder builder) {
        this.debt = builder.debt;
        this.bonus = builder.bonus;
        this.name = builder.name;
        this.salary = builder.salary;
    }

    public static Builder build() {
        return new Builder();
    }
}