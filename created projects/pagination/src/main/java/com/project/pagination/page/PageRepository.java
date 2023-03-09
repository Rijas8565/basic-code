package com.project.pagination.page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page,Long> {

    @Query(value = "select * from page where dob between ?1 and ?2",nativeQuery = true)
    List<Page>findByDob(LocalDate fromdate,LocalDate todate);
}
