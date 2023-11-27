import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        /// создание списка с типом Data
        List<Data> dataList = new ArrayList<>();
        dataList.add(new Data("To Kill a Mockingbird", "Harper Lee", 10.99f, 1));
        dataList.add(new Data("1984", "George Orwell", 9.99f, 1));
        dataList.add(new Data("Pride and Prejudice", "Jane Austen", 7.99f, 2));
        dataList.add(new Data("The Great Gatsby", "F. Scott Fitzgerald", 12.99f, 1));
        dataList.add(new Data("Moby-Dick", "Herman Melville", 11.99f, 1));
        dataList.add(new Data("The Catcher in the Rye", "J.D. Salinger", 8.99f, 1));
        dataList.add(new Data("To the Lighthouse", "Virginia Woolf", 9.99f, 2));
        dataList.add(new Data("Brave New World", "Aldous Huxley", 10.99f, 1));
        dataList.add(new Data("The Lord of the Rings", "J.R.R. Tolkien", 14.99f, 3));
        dataList.add(new Data("Crime and Punishment", "Fyodor Dostoevsky", 9.99f, 1));
        dataList.add(new Data("The Odyssey", "Homer", 8.99f, 2));
        dataList.add(new Data("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 11.99f, 1));
        dataList.add(new Data("The Hobbit", "J.R.R. Tolkien", 9.99f, 2));
        dataList.add(new Data("War and Peace", "Leo Tolstoy", 13.99f, 1));

        /// Наши компараторы для сравнения данных
        Comparator<Data> Authorcomp = (o1, o2) -> o1.author.compareTo(o2.author);
        Comparator<Data> Namecomp = (o1, o2) -> o1.name.compareTo(o2.name);
        Comparator<Data> Pricecomp = (o1, o2) -> Float.compare(o1.price, o2.price);
        Comparator<Data> Editcomp = (o1, o2) -> Integer.compare(o1.edition,o2.edition);

        Data.SortData(dataList, Namecomp);
        //Data.saveToFile(dataList,"Name.txt");
        Data.printData(dataList);
    }
}
