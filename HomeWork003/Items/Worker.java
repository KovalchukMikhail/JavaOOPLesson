package HomeWork003.Items;

public class Worker extends Person{
    int id;
    int salary;

    public Worker(int age, int salary, String firstname, String surname){
        super(age, firstname, surname);
        this.id = CurrentId.getCurrentId();
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id:" + this.id + super.toString() +"salary:" + this.salary;
    }
}
