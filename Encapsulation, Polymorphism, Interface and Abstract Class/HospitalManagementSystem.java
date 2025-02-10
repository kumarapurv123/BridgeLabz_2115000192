import java.util.*;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int numberOfDays;
    private List<String> medicalRecords;

    public InPatient(String patientId, String name, int age, double dailyRate, int numberOfDays) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.numberOfDays = numberOfDays;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return dailyRate * numberOfDays;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalRecords;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.medicalRecords = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalRecords;
    }
}

interface MedicalRecord {
    void addRecord(String record);

    List<String> viewRecords();
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("P001", "Patientin", 45, 2000, 5);
        OutPatient outPatient = new OutPatient("P002", "Patientout", 30, 500);

        patients.add(inPatient);
        patients.add(outPatient);

        processPatientDetails(patients);
    }

    public static void processPatientDetails(List<Patient> patients) {
        for (Patient patient : patients) {
            patient.getPatientDetails();
            double bill = patient.calculateBill();
            System.out.println("Total Bill: " + bill);

            MedicalRecord medicalRecord = (MedicalRecord) patient;
            medicalRecord.addRecord("Initial diagnosis");
            medicalRecord.addRecord("Follow-up visit");

            System.out.println("Medical Records: " + medicalRecord.viewRecords());
            System.out.println();
        }
    }
}
