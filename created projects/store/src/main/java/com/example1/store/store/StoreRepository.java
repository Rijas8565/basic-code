package com.example1.store.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

   @Query("from Store order by name asc")
    List<Store>findByIdSorted();

    @Query("from Store where id=1")
    List<Store>findByIdPredefined();

    @Query("from Store where id >(:id)order by number")
    List<Store>findByIdGreaterThan(@Param("id")Integer id);



}
