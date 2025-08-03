public class Student implements Comparable<Student> {
    private String name;
    private String address;
    private double GPA;

    public Student(String name, String address, double GPA) {
        this.name = name;
        this.address = address;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address + ", GPA: " + GPA;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}
