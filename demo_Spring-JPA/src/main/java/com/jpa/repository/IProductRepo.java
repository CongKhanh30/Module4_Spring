package com.jpa.repository;

import com.jpa.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepo extends PagingAndSortingRepository<Product,Integer> {
    List<Product> findAllByCategoryId(int id);

    @Query(value = "select p from Product p where p.name like concat('%',:name,'%')")
    List<Product> getAllByNameHQL(@Param("name") String name);

    @Query(nativeQuery = true, value = "select * from product  where name like concat('%',:name,'%')")
    List<Product> getAllByNameSQL(@Param("name") String name);

}