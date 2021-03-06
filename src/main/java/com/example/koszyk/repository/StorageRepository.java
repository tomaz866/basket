package com.example.koszyk.repository;

import com.example.koszyk.domain.Storage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<Storage,Long> {

    Storage getByName(String name);
}
