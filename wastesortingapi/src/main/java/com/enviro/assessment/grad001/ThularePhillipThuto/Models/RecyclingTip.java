package com.enviro.assessment.grad001.ThularePhillipThuto.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class RecyclingTip {
    @Id // This annotation marks the field as the primary key for the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // The value will be automatically generated (auto-incremented).
    private Long id; // Unique identifier for each RecyclingTip entry.

    @Column(nullable = false) // Specifies that this field cannot be null in the database.
    private String tip; // The recycling tip message.

    @JsonBackReference // Prevents infinite recursion during serialization, as this is a bidirectional relationship.
    @ManyToOne // Indicates that many RecyclingTip entities can be related to one WasteCategory.
    @JoinColumn(name = "category_id", nullable = false) // Specifies the foreign key column in the database table.
    private WasteCategory wasteCategory; // The related waste category to which the recycling tip belongs.

    // Getter for 'id'
    public Long getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for 'tip'
    public String getTip() {
        return tip;
    }

    // Setter for 'tip'
    public void setTip(String tip) {
        this.tip = tip;
    }

    // Getter for 'wasteCategory'
    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    // Setter for 'wasteCategory'
    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

}
