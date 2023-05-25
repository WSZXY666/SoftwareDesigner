package DesignPatterns.JieG.Facade;

interface Patient {
    String getName(); // (1)
}

interface Disposer {
    void dispose(Patient patient);  // (2)
}

class Registry implements Disposer { // 挂号
    public void dispose(Patient patient) {
        System.out.println(patient.getName() + " is registering...");
    }
}

class Doctor implements Disposer { // 医生门诊
    public void dispose(Patient patient) {
        System.out.println(patient.getName() + " is diagnosing...");
    }
}

class Pharmacy implements Disposer { // 取药
    public void dispose(Patient patient) {
        System.out.println(patient.getName() + " is medicine... ");
    }
}

class Facade2 {
    private final Patient patient;

    public Facade2(Patient patient) {
        this.patient = patient;
    }

    void dispose() {
        Registry registry = new Registry();
        Doctor doctor = new Doctor();
        Pharmacy pharmacy = new Pharmacy();

        registry.dispose(patient);
        doctor.dispose(patient);
        pharmacy.dispose(patient);
    }
}

class ConcretePatient implements Patient {
    private final String name;

    public ConcretePatient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class FacadeTest {
    public static void main(String[] args) {
        Patient patient = new ConcretePatient("Wsz"); // (3)
        Facade2 f = new Facade2(patient); // (4) (5)

        f.dispose(); // (6)
    }
}
