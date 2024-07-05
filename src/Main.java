import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalRecordManager medicalRecordManager = new MedicalRecordManager();
        while (true) {
            Menu.printMenu();

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    handleAdd(scanner, medicalRecordManager);
                    break;
                case 2:
                    delete(scanner,medicalRecordManager);
                    break;
                case 3:
                    medicalRecordManager.showMedicalRecord();
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("ko co lua chon phu hop");
                    break;
            }
        }
    }

    public static void handleAdd(Scanner scanner, MedicalRecordManager medicalRecordManager) {
        Menu.printMenuAdd();
        int chooseMedicalRecord = Integer.parseInt(scanner.nextLine());

        if (chooseMedicalRecord != 1 && chooseMedicalRecord != 2) {
            System.out.println("Nhap sai");
            return;
        }

        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập Code");
        String code = scanner.nextLine();
        System.out.println("Nhập tên bệnh án");
        String namePatient = scanner.nextLine();
        System.out.println("Nhập ngày nhập viện");
        String hospitalizedDay = scanner.nextLine();
        System.out.println("Nhập ngày ra viện");
        String hospitalDischargeDate = scanner.nextLine();
        System.out.println("Lý do nhập viện");
        String reasonForHospitalization = scanner.nextLine();

        if (chooseMedicalRecord == 1) {
            System.out.println("Nhap so tien phai tra");
            double hospitalFee = Double.parseDouble(scanner.nextLine());
            RegularMedicalRecord regularMedicalRecord = new RegularMedicalRecord(id, code, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization, hospitalFee);
            medicalRecordManager.addMedicalRecord(regularMedicalRecord);
            System.out.println("nhap benh an thuong thanh cong");
        } else {
            System.out.println("Nhap loai phong Vip(1/2/3)");
            int type = Integer.parseInt(scanner.nextLine());
            System.out.println("Thoi han Vip");
            int duration = Integer.parseInt(scanner.nextLine());
            VipMedicalRecord vipMedicalRecord = new VipMedicalRecord(id, code, namePatient, hospitalizedDay, hospitalDischargeDate, reasonForHospitalization, type, duration);
            medicalRecordManager.addMedicalRecord(vipMedicalRecord);
            System.out.println("Nhap benh an vip thanh cong");
        }
    }
    public static void delete(Scanner scanner,MedicalRecordManager medicalRecordManager) {
        System.out.println("nhap ma benh an muon xoa");
        String code=scanner.nextLine();
        MedicalRecord mr = medicalRecordManager.searchByCode(code);
        if(mr == null) {
            System.out.println("Loi");
        }else {
            medicalRecordManager.deleteMedicalRecord(mr);
        }
    }
}

