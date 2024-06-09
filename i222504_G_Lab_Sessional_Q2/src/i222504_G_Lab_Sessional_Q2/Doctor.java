package i222504_G_Lab_Sessional_Q2;

public class Doctor {
    private String name;
    private String speciality;
    private String contactInfo;
    private boolean availability;

    public Doctor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", availability=" + availability +
                '}';
    }
}
