package com.enviro.assessment.grad001.ThularePhillipThuto.Repository;

import com.enviro.assessment.grad001.ThularePhillipThuto.Models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}
