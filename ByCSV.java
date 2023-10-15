import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextToCSV {

    public static void main(String[] args) {
        // 텍스트 데이터
        String[] dataLines = {
            "0001,김강민,32.7,...", 
            "0002,김지호,39.1,...",
            "0003,문준호,70.5,..."
        };

        // 항목
        String[] headers = {
            "액터번호", "이름", "몸무게", "키(cm)"
        };

        // CSV 파일로 저장
        for (int i = 0; i < dataLines.length; i++) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataLines[i].split(",")[0] + "_신체데이터.csv") {
                // 헤더 쓰기
                for (int j = 0; j < headers.length; j++) {
                    writer.write(headers[j]);
                    if (j < headers.length - 1) {
                        writer.write(",");
                    } else {
                        writer.newLine();
                    }
                }

                // 데이터 쓰기
                writer.write(dataLines[i]);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CSV 파일 추출이 완료되었습니다.");
    }
}
