package com.enviro.assessment.grad001.ThularePhillipThuto.Repository;

import com.enviro.assessment.grad001.ThularePhillipThuto.Models.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisposalGuidelineRepository  extends JpaRepository<DisposalGuideline, Long> {
    List<DisposalGuideline> findByWasteCategoryId(Long categoryId);
}
