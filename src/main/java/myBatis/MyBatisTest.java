package myBatis;

import db.dao.CategoriesMapper;
import db.dao.ProductsMapper;
import db.model.Categories;
import db.model.CategoriesExample;
import db.model.Products;
import db.model.ProductsExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class MyBatisTest {

    public static void main(String[] args) {

        SqlSessionFactory sessionFactory =
                 new SqlSessionFactoryBuilder()
                         .build(MyBatisTest.class.getResourceAsStream("mybatis-config.xml"));

        SqlSession session = sessionFactory.openSession();
        ProductsMapper productsMapper = session.getMapper(ProductsMapper.class);

        Products product = productsMapper.selectByPrimaryKey(1L);
        ProductsExample example = new ProductsExample();

        CategoriesMapper categoriesMapper = session.getMapper(CategoriesMapper.class);
//        Categories category = new Categories();
//        category.setTitle("Ololo");
//        categoriesMapper.insert(category);
//        session.commit();

        List<Categories> categories = categoriesMapper.selectByExample(new CategoriesExample());
        System.out.println(categories);

        example.createCriteria()
                .andCategoryIdEqualTo(2L)
                .andPriceLessThan(30000);

        List<Products> products = productsMapper.selectByExample(example);

        System.out.println(product);
        System.out.println(products);

//        Products prod = new Products();
//        prod.setTitle("Ololo product");
//        prod.setPrice(100500);
//        prod.setCategoryId(8L);
//
//        productsMapper.insert(prod);

        products = productsMapper.selectByExample(new ProductsExample());
        System.out.println(products);
//        session.commit();

    }
}
