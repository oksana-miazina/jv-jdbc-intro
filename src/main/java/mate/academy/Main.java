package mate.academy;

import mate.academy.dao.BookDao;
import mate.academy.lib.Injector;
import mate.academy.model.Book;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.academy");

    public static void main(String[] args) {
        BookDao bookDao = (BookDao) injector.getInstance(BookDao.class);
        Book book = new Book();
        book.setTitle("Test");

        bookDao.create(book);

        book.setTitle("Greystok");
        bookDao.update(book);

        System.out.println(bookDao.findById(1L));

        bookDao.findAll().forEach(System.out::println);

        bookDao.deleteById(1L);
    }
}
