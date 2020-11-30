package Accounts.Designation;

public class Designation {
    int salary;
    String desigName, desigType, desigID;

    public Designation(int salary, String desigName, String desigType, String desigID) {
        this.salary = salary;
        this.desigName = desigName;
        this.desigType = desigType;
        this.desigID = desigID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName = desigName;
    }

    public String getDesigType() {
        return desigType;
    }

    public void setDesigType(String desigType) {
        this.desigType = desigType;
    }

    public String getDesigID() {
        return desigID;
    }

    public void setDesigID(String desigID) {
        this.desigID = desigID;
    }
}
