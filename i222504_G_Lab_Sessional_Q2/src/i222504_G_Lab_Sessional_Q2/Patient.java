package i222504_G_Lab_Sessional_Q2;

public class Patient {
    private String name;
    private int age;
    private int contactInfo;
    private String symptoms;

    public Patient() {}
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(int ans) {
        this.contactInfo = ans;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", contactInfo='" + contactInfo + '\'' +
                ", symptoms='" + symptoms + '\'' +
                '}';
    }
}
