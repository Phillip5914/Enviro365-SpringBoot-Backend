package com.enviro.assessment.grad001.ThularePhillipThuto.Services;

import com.enviro.assessment.grad001.ThularePhillipThuto.Models.*;
import com.enviro.assessment.grad001.ThularePhillipThuto.Repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.ThularePhillipThuto.Repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.ThularePhillipThuto.Repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    @Autowired
    private RecyclingTipRepository recyclingTipRepository;

    public WasteCategory addWasteCategory(WasteCategory category) {
        return wasteCategoryRepository.save(category);
    }

    public DisposalGuideline addDisposalGuideline(Long categoryId, DisposalGuideline guideline) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        guideline.setWasteCategory(category);
        return disposalGuidelineRepository.save(guideline);
    }

    public RecyclingTip addRecyclingTip(Long categoryId, RecyclingTip tip) {
        WasteCategory category = wasteCategoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        tip.setWasteCategory(category);
        return recyclingTipRepository.save(tip);
    }

    public DisposalGuideline updateDisposalGuideline(Long disposalId, DisposalGuideline updatedGuideline) {
        DisposalGuideline existingGuideline = disposalGuidelineRepository.findById(disposalId)
                .orElseThrow(() -> new RuntimeException("Guideline not found"));
        if (updatedGuideline.getGuideline() != null) {
            existingGuideline.setGuideline(updatedGuideline.getGuideline());
        }
        return disposalGuidelineRepository.save(existingGuideline);
    }

    public RecyclingTip updateRecyclingTip(Long recyclingId, RecyclingTip updateTip) {
        RecyclingTip existingRecyclingTip = recyclingTipRepository.findById(recyclingId)
                .orElseThrow(() -> new RuntimeException("Tip not found"));
        if (updateTip.getTip() != null) {
            existingRecyclingTip.setTip(updateTip.getTip());
        }
        return recyclingTipRepository.save(existingRecyclingTip);
    }

    public void deleteRecyclingTip(Long recyclingId) {
        recyclingTipRepository.deleteById(recyclingId);
    }

    public void deleteWasteCategory(Long categoryId) {
        wasteCategoryRepository.deleteById(categoryId);
    }

    public void deleteGuideline(Long guidelineId) {
        disposalGuidelineRepository.deleteById(guidelineId);
    }

    public List<WasteCategory> getAllCategories() {
        return wasteCategoryRepository.findAll();
    }

    public List<DisposalGuideline> getAllDisposalGuideline() {
        return disposalGuidelineRepository.findAll();
    }

    public List<RecyclingTip> getAllRecyclingTip() {
        return recyclingTipRepository.findAll();
    }

    public Optional<DisposalGuideline> findGuidelineById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    public List<RecyclingTip> getRecyclingTipsByCategoryId(Long categoryId) {
        return recyclingTipRepository.findByWasteCategoryId(categoryId);
    }
    public List<DisposalGuideline> getGuidelinesByCategoryId(Long categoryId) {
        return disposalGuidelineRepository.findByWasteCategoryId(categoryId);
    }
}
