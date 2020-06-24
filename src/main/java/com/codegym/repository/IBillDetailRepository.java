package com.codegym.repository;

import com.codegym.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillDetailRepository extends JpaRepository<BillDetail, Long> {
}
