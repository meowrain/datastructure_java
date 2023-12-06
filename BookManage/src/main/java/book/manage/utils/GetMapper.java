package book.manage.utils;

import org.apache.ibatis.session.SqlSession;

public class GetMapper<T> {
    public static <T> T getMapper(Class<T> mapperType) {
        SqlSession session = MyBatisUtil.getSqlSession();
        return session.getMapper(mapperType);
    }
}
