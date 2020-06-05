package com.example.demo.repository;

import com.example.demo.entity.Hamburger;
import com.example.demo.entity.type.HamburgerType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HamburgerRepository extends CrudRepository<Hamburger, Long> {
    List<Hamburger> findByHamburgerTypeIs(HamburgerType hamburgerType);

}
