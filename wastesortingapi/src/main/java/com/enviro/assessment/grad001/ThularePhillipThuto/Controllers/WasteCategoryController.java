package com.enviro.assessment.grad001.ThularePhillipThuto.Controllers;

import com.enviro.assessment.grad001.ThularePhillipThuto.Models.DisposalGuideline;
import com.enviro.assessment.grad001.ThularePhillipThuto.Models.RecyclingTip;
import com.enviro.assessment.grad001.ThularePhillipThuto.Models.WasteCategory;
import com.enviro.assessment.grad001.ThularePhillipThuto.Services.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5174")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return wasteCategoryService.getAllCategories();
    }

    @GetMapping("/guidelines")
    public List<DisposalGuideline> getAllDisposalGuideline() {
        return wasteCategoryService.getAllDisposalGuideline();
    }

    @GetMapping("/tips")
    public List<RecyclingTip> getAllRecyclingTip() {
        return wasteCategoryService.getAllRecyclingTip();
    }

    @PostMapping
    public ResponseEntity<WasteCategory> addWasteCategory(@RequestBody WasteCategory category) {
        WasteCategory createdCategory = wasteCategoryService.addWasteCategory(category);
        return ResponseEntity.ok(createdCategory);
    }

    @PostMapping("/{categoryId}/guidelines")
    public ResponseEntity<DisposalGuideline> addDisposalGuideline(@PathVariable Long categoryId, @RequestBody DisposalGuideline guideline) {
        try {
            DisposalGuideline addedGuideline = wasteCategoryService.addDisposalGuideline(categoryId, guideline);
            return ResponseEntity.ok(addedGuideline);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{categoryId}/tips")
    public ResponseEntity<RecyclingTip> addRecyclingTip(@PathVariable Long categoryId, @RequestBody RecyclingTip tip) {
        try {
            RecyclingTip addedTip = wasteCategoryService.addRecyclingTip(categoryId, tip);
            return ResponseEntity.ok(addedTip);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{disposalId}/guidelines")
    public ResponseEntity<DisposalGuideline> updateDisposal(@PathVariable Long disposalId, @RequestBody DisposalGuideline guideline) {
        try {
            DisposalGuideline updatedGuideline = wasteCategoryService.updateDisposalGuideline(disposalId, guideline);
            return ResponseEntity.ok(updatedGuideline);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{tipId}/tips")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long tipId, @RequestBody RecyclingTip tip) {
        try {
            RecyclingTip updatedTip = wasteCategoryService.updateRecyclingTip(tipId, tip);
            return ResponseEntity.ok(updatedTip);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/tip/delete/{tipId}")
    public ResponseEntity<String> deleteById(@PathVariable Long tipId) {
        wasteCategoryService.deleteRecyclingTip(tipId);
        return ResponseEntity.ok("Tip was successfully deleted!");
    }

    @DeleteMapping("/category/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        wasteCategoryService.deleteWasteCategory(categoryId);
        return ResponseEntity.ok("Category was successfully deleted!");
    }

    @DeleteMapping("/guideline/delete/{guidelineId}")
    public ResponseEntity<String> deleteGuideline(@PathVariable Long guidelineId) {
        wasteCategoryService.deleteGuideline(guidelineId);
        return ResponseEntity.ok("Guideline was successfully deleted!");
    }

    @GetMapping("/guidelines/{id}")
    public ResponseEntity<DisposalGuideline> getGuidelineById(@PathVariable Long id) {
        return wasteCategoryService.findGuidelineById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoryTips/{categoryId}")
    public ResponseEntity<List<RecyclingTip>> getRecyclingTipsByCategoryId(@PathVariable Long categoryId) {
        List<RecyclingTip> tips = wasteCategoryService.getRecyclingTipsByCategoryId(categoryId);
        return ResponseEntity.ok(tips);
    }
    @GetMapping("/categoryGuideline/{categoryId}")
    public ResponseEntity<List<DisposalGuideline>> getGuidelinesByCategoryId(@PathVariable Long categoryId) {
        List<DisposalGuideline> guidelines = wasteCategoryService.getGuidelinesByCategoryId(categoryId);
        return ResponseEntity.ok(guidelines);
    }
}
