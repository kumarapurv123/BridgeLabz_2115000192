import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;
    private int age;
    private List<Doctor> doctors;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient Name: " + name + ", Age: " + age;
    }
}

class Doctor {
    private String name;
    private String specialty;
    private List<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        System.out.println(
                "Doctor " + name + " (" + specialty + ") consulting " + patient.getName() + ".");
        System.out.println("help");
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);
    }

    @Override
    public String toString() {
        return "Doctor Name: " + name + ", Specialty: " + specialty;
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showDoctors() {
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }

    public void showPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doctor1 = new Doctor("Dr. D1", "Cardiologist");
        Doctor doctor2 = new Doctor("Dr. D2", "Neurologist");

        Patient patient1 = new Patient("P1", 45);
        Patient patient2 = new Patient("P2", 35);

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        doctor1.addPatient(patient1);
        doctor2.addPatient(patient1);
        doctor2.addPatient(patient2);

        hospital.showDoctors();
        hospital.showPatients();

        doctor1.consult(patient1);
        doctor2.consult(patient2);
    }
}
