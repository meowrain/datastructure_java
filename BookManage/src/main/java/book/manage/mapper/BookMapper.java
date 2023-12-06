package book.manage.mapper;

import book.manage.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    @Insert("insert into book(title,description,price) values (#{title},#{description},#{price})")
    @Results({
            @Result(property = "title",column = "title"),
            @Result(property = "description",column = "description"),
            @Result(property = "price",column = "price")
    })
    int addBook(Book book);

    @Select("select bid, title, description, price from book")
    List<Book> getAllBooks();


}
