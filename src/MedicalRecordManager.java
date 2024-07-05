import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordManager {

    private Map<String, MedicalRecord> medicalRecordMap;

    public MedicalRecordManager() {
        this.medicalRecordMap = new HashMap<>();
    }
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMap.put(medicalRecord.getCode(),medicalRecord);
    }
    public void deleteMedicalRecord(MedicalRecord medicalRecord) {

        medicalRecordMap.remove(medicalRecord.getCode());
    }
    public MedicalRecord searchByCode (String code) {
        return medicalRecordMap.get(code);
    }
    public void showMedicalRecord() {
        if (medicalRecordMap.size() <= 0) {
            System.out.println("ko co");
            return;
        }
        for (MedicalRecord medicalRecord: medicalRecordMap.values()) {
            System.out.println(medicalRecord);
        }
    }
}
