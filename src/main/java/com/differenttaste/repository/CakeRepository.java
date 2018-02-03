package com.differenttaste.repository;

import com.differenttaste.bean.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CakeRepository extends JpaRepository<Cake, Integer> {

    List<Cake> findByIdBetween(int from, int to);

    List<Cake> findByChangeStatus(String ChangeStatus);

}
