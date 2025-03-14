package com.enviro.assessment.grad001.ThularePhillipThuto.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class DisposalGuideline {
    @Id // Marks this field as the primary key for the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies that the primary key should be automatically generated (auto-increment).
    private Long id; // The unique identifier for each DisposalGuideline entry.

    @Column(nullable = false) // Marks this field as non-nullable in the database.
    private String guideline; // The actual guideline text for disposal.

    @JsonBackReference
    // Prevents infinite recursion in JSON serialization by excluding the wasteCategory in the serialized output.
    @ManyToOne // Indicates that many DisposalGuideline entities can be associated with one WasteCategory entity.
    @JoinColumn(name = "category_id", nullable = false) // Specifies the foreign key column in the database table.
    private WasteCategory wasteCategory; // The associated WasteCategory to which the disposal guideline belongs.

    // Getter for 'wasteCategory'
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    // Setter for 'wasteCategory'
    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    // Getter for 'id'
    public Long getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for 'guideline'
    public String getGuideline() {
        return guideline;
    }

    // Setter for 'guideline'
    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }


}
