package com.product.convertor.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConvertorRepository extends JpaRepository<Convertor,Long> {


}
