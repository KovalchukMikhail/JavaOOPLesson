package HomeWork003.Items;

public abstract class Person {
    int age;
    String firstname;
    String surname;

    public Person(int age, String firstname, String surname){
        this.age = age;
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "firstname:" + this.firstname + "surname:" + this.surname + "age:" + this.age;
    }
}
