package book.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
    int bid;
    final String title;
    final String description;
    final double price;
}
