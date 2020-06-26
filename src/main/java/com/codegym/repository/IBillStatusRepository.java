package com.codegym.repository;

import com.codegym.model.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillStatusRepository extends JpaRepository<BillStatus, Long> {

}
