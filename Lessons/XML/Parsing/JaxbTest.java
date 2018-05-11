package by.lesson20;

import by.lesson19.Book;
import by.lesson19.Library;
import by.lesson19.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class JaxbTest {
    public static void main(String [] args){
        try (FileOutputStream fos = new FileOutputStream("d:/librarium.xml");
             FileInputStream fis = new FileInputStream("d:/librarium2.xml")/* тот  же файл только продублированный*/) {
            JAXBContext context = JAXBContext.newInstance("by.lesson19"); //только так делаем
            Marshaller marshaller =context.createMarshaller();
        

            //запиливаем наш скелет всякими пропертями, пользуясь созданными в уроке 19 классами/методами

            ObjectFactory objectFactory = new ObjectFactory();
            Library library = objectFactory.createLibrary();
            library.setAddress("Lenina 19");
            library.setOwner("Vasya Pupkin");

            Book book = objectFactory.createBook();
            book.setAuthor("Karl Marx");
            book.setTitle("The Capital");
            book.setPages(new BigInteger("100500"));  //BigInteger жи!



            Book book2=objectFactory.createBook();
            book2.setAuthor("E-R");
            book2.setTitle("Opal");
            book2.setPages(new BigInteger("30"));


            Library.Bookcase.Shelf shelf = objectFactory.createLibraryBookcaseShelf();
            shelf.getBook().add(book);
            shelf.getBook().add(book2);

            Library.Bookcase bookcase = objectFactory.createLibraryBookcase();
            bookcase.setAddress(library.getAddress());
            bookcase.setOwner("Helen A");

            //доб полочку
            bookcase.getShelf().add(shelf);

            //доб шкаф в библиотеку
            library.getBookcase().add(bookcase);

            marshaller.marshal(library, fos);
            //собираем в xml

            //
            //
            //
            //


            //а теперь наоборотъ - из XML соберем объекты

            Unmarshaller unmarshaller = context.createUnmarshaller();
            Library library2 = (Library)unmarshaller.unmarshal(fis);
            System.out.println(library2.getBookcase().get(0).getShelf().get(0).getBook().get(0).getAuthor());  //пока тольк 1 эл-т
            System.out.println(library2.getBookcase().get(0).getShelf().get(0).getBook().get(0).getTitle());

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
