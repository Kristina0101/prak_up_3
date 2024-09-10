package com.example.prak_up_3.repository;

import com.example.prak_up_3.model.ToyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<ToyModel, Long> {
}