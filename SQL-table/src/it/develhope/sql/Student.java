package it.develhope.sql;

public class Student {
    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static final class StudentBuilder {
        private String name;
        private String surname;

        private StudentBuilder() {
        }

        public static StudentBuilder aStudent() {
            return new StudentBuilder();
        }

        public StudentBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Student build() {
            return new Student(name, surname);
        }
    }
}
