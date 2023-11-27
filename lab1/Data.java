import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Data {
    String name;
    String author;
    float price;
    int edition;

    ///констуктор
    public Data(String name, String author, float price, int edition){
        this.name = name;
        this.author = author;
        this.price = price;
        this.edition = edition;
    }
    /// сортировка
    public static void SortData(List<Data>dataList, Comparator<Data> comparator){
        for (int i = 0; i < dataList.size() - 1; i++) {
            for (int j = 0; j < dataList.size() - i - 1; j++) {
                if (comparator.compare(dataList.get(j), dataList.get(j + 1)) > 0) {
                    Data temp = dataList.get(j);
                    dataList.set(j, dataList.get(j + 1));
                    dataList.set(j + 1, temp);
                }
            }
        }
    }
    ///сохрарнние в файл
    public static void saveToFile(List<Data> dataList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Data data : dataList) {
                writer.write(data.name +  ", "
                        + data.author + ", "
                        + data.price+ ", "
                        + data.edition);

                writer.write(System.lineSeparator()); // Пустая строка между объектами
            }
            writer.flush();
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных в файл " + fileName);
            e.printStackTrace();
        }
    }
    /// вывод на экран
    public static void printData(List<Data> dataList) {
        for (Data data : dataList) {
            System.out.printf("%40s %30s %10.2f %d\n", data.name, data.author, data.price, data.edition);
        }
    }

}
