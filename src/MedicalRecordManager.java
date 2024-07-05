import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalRecordManager {

    Map<String, MedicalRecord> medicalRecordMap;

    public MedicalRecordManager() {
        this.medicalRecordMap = new HashMap<>();
    }
    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMap.put(medicalRecord.getCode(),medicalRecord);
    }
    public void deleteMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecordMap.remove(medicalRecord.getCode());
    }
    public void showMedicalRecord() {
        for (MedicalRecord medicalRecord: medicalRecordMap.values()) {
            System.out.println(medicalRecord);
        }
    }
}
