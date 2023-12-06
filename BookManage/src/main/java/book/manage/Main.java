package book.manage;

import book.manage.entity.Book;
import book.manage.entity.Student;
import book.manage.mapper.BookMapper;
import book.manage.mapper.StudentMapper;
import book.manage.utils.GetMapper;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static void isSuccess(String method, int result) {
        if (result == 1) {
            System.out.println(method + " 操作成功！");
        } else {
            System.out.println(method + " 操作失败！");
        }
    }

    private static void addStudent(Scanner sc, StudentMapper studentMapper) {
        System.out.println("请输入学生名字：");
        String studentName = sc.nextLine();
        System.out.println("输入学生性别（男/女）:");
        String sex = sc.nextLine();
        System.out.println("输入学生年级：");
        int grade = sc.nextInt();
        sc.nextLine();
        Student student = new Student(studentName, sex, grade);
        isSuccess("插入学生", studentMapper.addStudent(student));
    }

    private static void addBook(Scanner sc, BookMapper bookMapper) {
        System.out.println("请输入书籍名字：");
        String bookName = sc.nextLine();
        System.out.println("请输入书籍描述：");
        String description = sc.nextLine();
        System.out.println("请输入书籍价格:");
        double price = sc.nextDouble();
        sc.nextLine();
        Book book = new Book(bookName, description, price);
        isSuccess("插入书籍", bookMapper.addBook(book));
    }

    private static void getAllBooks(BookMapper bookMapper) {
        List<Book> list = bookMapper.getAllBooks();
        for (Book book: list) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("=========================");
                System.out.println("1. 录入学生信息");
                System.out.println("2. 录入书籍信息");
                System.out.println("3. 查询所有学生信息");
                System.out.println("4. 查询所有书籍信息");
                System.out.println("输入你想要执行的操作，按其他任意键退出");
                System.out.println("=========================");
                int inputNum;
                try {
                    inputNum = sc.nextInt();
                } catch (Exception e) {
                    return;
                }
                sc.nextLine();
                switch (inputNum) {
                    case 1 -> {
                        StudentMapper studentMapper = GetMapper.getMapper(StudentMapper.class);
                        addStudent(sc, studentMapper);
                        break;
                    }
                    case 2 -> {
                        BookMapper bookMapper = GetMapper.getMapper(BookMapper.class);
                        addBook(sc, bookMapper);
                        break;
                    }
                    case 3 -> {
                        BookMapper bookMapper = GetMapper.getMapper(BookMapper.class);
                        getAllBooks(bookMapper);
                    }
                    default -> {
                        return;
                    }
                }
            }
        }
    }
}
