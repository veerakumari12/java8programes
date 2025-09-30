import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employees{
    private int id;
    private String name;
    private int age;
    private String gender;
    private String department;
    private int yearOfJoining;
    private double salary;



    public Employees(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employeess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        List<Employees> EmployeesList = new ArrayList<>();

        EmployeesList.add(new Employees(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
        EmployeesList.add(new Employees(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
        EmployeesList.add(new Employees(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
        EmployeesList.add(new Employees(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
        EmployeesList.add(new Employees(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
        EmployeesList.add(new Employees(6, "Cathy", 43, "Female", "Security", 2016, 10500.0));
        EmployeesList.add(new Employees(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
        EmployeesList.add(new Employees(8, "Suresh", 31, "Male", "Development", 2012, 34500.0));
        EmployeesList.add(new Employees(9, "Priya", 26, "Female", "Sales", 2017, 15000.0));
        EmployeesList.add(new Employees(10, "Anjali", 30, "Female", "Development", 2014, 28500.0));
        EmployeesList.add(new Employees(11, "Krishna", 39, "Male", "Infrastructure", 2009, 32000.0));
        EmployeesList.add(new Employees(12, "Vijay", 24, "Male", "Development", 2018, 14000.0));
        EmployeesList.add(new Employees(13, "Meena", 29, "Female", "HR", 2016, 21000.0));
        EmployeesList.add(new Employees(14, "Ravi", 34, "Male", "Finance", 2011, 29500.0));
        EmployeesList.add(new Employees(15, "Divya", 28, "Female", "Development", 2015, 31000.0));


        //How many male and female employees are there in the organization

        Long maile=EmployeesList.stream().filter(e->e.getGender().equalsIgnoreCase("Male")).count();
        System.out.println(maile); // only mail ,we need femail cjust chage the filter condition
        EmployeesList.stream().collect(Collectors.groupingBy(Employees::getGender,Collectors.counting()) );
        System.out.println(EmployeesList.stream().collect(Collectors.groupingBy(Employees::getGender,Collectors.counting()) ));

        //print the name of all department in the organization
        EmployeesList.stream().map(e->e.getDepartment()).distinct().forEach(x->System.out.println(x));


        // what is the average age of male and female employees?
        EmployeesList.stream().collect(Collectors.groupingBy(Employees::getGender,Collectors.averagingDouble(Employees::getAge)));
        System.out.println(EmployeesList.stream().collect(Collectors.groupingBy(Employees::getGender,Collectors.averagingDouble(Employees::getAge))));

        //Get the details of highest paid empployee in the organization
        EmployeesList.stream().sorted(Comparator.comparing(Employees::getSalary).reversed());
        System.out.println(EmployeesList.stream().sorted(Comparator.comparing(Employees::getSalary).reversed()).findFirst().get());
        //2nd higest
        System.out.println(EmployeesList.stream().sorted(Comparator.comparing(Employees::getSalary).reversed()).skip(1).findFirst().get());
        System.out.println(EmployeesList.stream().sorted(Comparator.comparing(Employees::getSalary)).findFirst().get());

        //get the names of all the employees who have joined after 2015
        EmployeesList.stream().filter(e->e.getYearOfJoining()>2015).map(Employees::getName).collect(Collectors.toList());
        System.out.println(EmployeesList.stream().filter(e->e.getYearOfJoining()<2015).map(Employees::getName).collect(Collectors.toList()));
        // count the number of employees in each department
        EmployeesList.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.counting()));
        System.out.println(EmployeesList.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.counting())));
        // what is the avage salary of each dept
        System.out.println(EmployeesList.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.averagingDouble(Employees::getSalary))));
//get the details of yougest male empolyee in the development department

        EmployeesList.stream().sorted(Comparator.comparing(Employees::getAge))
                .filter(e->e.getGender().equalsIgnoreCase("Male"))
                .filter(e->e.getDepartment().equalsIgnoreCase("Development")).collect(Collectors.toList());
        System.out.println( EmployeesList.stream().sorted(Comparator.comparing(Employees::getAge))
                .filter(e->e.getGender().equalsIgnoreCase("Male"))
                .filter(e->e.getDepartment().equalsIgnoreCase("Development")).findFirst().get());

        //who has the most working experience in the orgnization
        EmployeesList.stream().sorted(Comparator.comparing(Employees::getYearOfJoining)).findFirst().get();
        System.out.println(EmployeesList.stream().sorted(Comparator.comparing(Employees::getYearOfJoining)).findFirst().get());

        //how many male and female employees in the slaes team;

        EmployeesList.stream().filter(e->e.getDepartment().equalsIgnoreCase("Sales"))
                .collect(Collectors.groupingBy(Employees::getGender,Collectors.counting()));

        System.out.println(EmployeesList.stream().filter(e->e.getDepartment().equalsIgnoreCase("Sales"))
                .collect(Collectors.groupingBy(Employees::getGender,Collectors.counting())));

        //what is the average salry of male and female employees
        EmployeesList.stream().collect(Collectors.groupingBy(Employees::getGender,Collectors.averagingDouble(Employees::getSalary)));
        System.out.println( EmployeesList.stream().collect(Collectors.groupingBy(Employees::getGender,Collectors.averagingDouble(Employees::getSalary))));

//List down the name of all employee in each dept

        EmployeesList.stream().collect(Collectors.groupingBy(Employees::getDepartment,Collectors.mapping(Employees::getName,Collectors.toList())));







    }


}