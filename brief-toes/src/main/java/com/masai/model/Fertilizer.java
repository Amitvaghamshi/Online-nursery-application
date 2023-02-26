package com.masai.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fertilizer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fertilizerId;

    @NotBlank
    private String commonName;

    @Enumerated(EnumType.STRING)
    private FertilizerType fertilizerType;

    @NotBlank
    private String brand;

    @NotBlank
    private String description;

    @Min(value = 10, message = "Fertilizer quantity can not be less than 10")
    private Double quantityPerPacket;

    @Min(value = 0, message = "Fertilizer's stock can't be negative")
    private Integer fertilizerStock;

//    @Size(min=0,max=2000, message = "Fertilisers are available between 100 to 2000")
    private Integer fertilizerCost;
}
