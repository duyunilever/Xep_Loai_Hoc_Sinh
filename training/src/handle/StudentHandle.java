package handle;

import entity.Student;

import java.util.Scanner;

public class StudentHandle {
    public Student creatStudent(Scanner scanner, int i) {
        System.out.println("Nhập tên student thứ " + (i + 1));
        String name = scanner.nextLine();
        double scoreMath;
        double scorePhysic;
        double scoreChemistry;
        do {
            System.out.println("Nhập điểm toán: ");
            scoreMath = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập điểm vật lý: ");
            scorePhysic = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập điểm hóa: ");
            scoreChemistry = Double.parseDouble(scanner.nextLine());
            if (0<=scoreMath && scoreMath<=10 && 0<=scorePhysic && scorePhysic<=10 && 0<=scoreChemistry && scoreChemistry<=10){
                break;
            }
            System.out.println("Điểm nhập vào không hợp lệ, mời nhập lại");
        } while (scoreMath<0 || scoreMath >10 || scorePhysic<0 || scorePhysic >10 || scoreChemistry<0 || scoreChemistry >10);

        Student student = new Student(name, scoreMath, scorePhysic, scoreChemistry);
        return student;
    }
    //Lấy giá trị từ student
    public double getAvgScore(Student student){
        return (student.getScoreMath()+student.getScorePhysic()+student.getScoreChemistry())/3;
    }
    //TO DO
    public String classify(double scoreAvg){
        if (scoreAvg>=8){
            return "A";
        } else if (8>scoreAvg && scoreAvg>=6.5) {
            return "B";
        } else if (scoreAvg<6.5) {
            return "C";
        }
        return "";
    }
    public void displayStudent(Student [] students){
        for (Student x:students) {
            System.out.println("ID: " + x.getId() +
                    " - Tên: " + x.getName() +
                    " - Điểm trung bình: " + getAvgScore(x) +
                    " - Xếp loại: " + classify(getAvgScore(x)));
        }
    }
    double sumA = 0;
    double sumB = 0;
    double sumC = 0;
    public void pecent(Student[]students){
        for (Student x : students) {
            {
                if (getAvgScore(x) >= 8) {
                    sumA++;
                } else if (8 > getAvgScore(x) && getAvgScore(x) >= 6.5) {
                    sumB++;
                } else if (getAvgScore(x) < 6.5) {
                    sumC++;
                }
            }
        }
        System.out.println(" - Phần trăm xếp loại A: " + sumA/ students.length*100 + "%" + "\n" +
                " - Phần trăm xếp loại B: " + sumB/ students.length*100 + " %" + "\n" +
                " - Phần trăm xếp loại C: " + sumC/ students.length*100 + " %");
    }
}
