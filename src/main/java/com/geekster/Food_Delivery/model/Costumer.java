package com.geekster.Food_Delivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@Entity
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long costumerId;
    @Email
    private String costumerEmailId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Length(min =6)
    private String costumerPassword;
    @NotBlank
    private  String costumerFirstName;
    @NotBlank
    private String costumerLastName;
    @NotBlank
    private String costumerAddress;

   @Digits(integer = 10,fraction = 0)
   @Size(min = 10,max = 12)
    private  String costumerContact;

    public Costumer(String costumerEmailId, String costumerPassword, String costumerFirstName, String costumerLastName, String costumerAddress, String costumerContact) {
        this.costumerEmailId = costumerEmailId;
        this.costumerPassword = costumerPassword;
        this.costumerFirstName = costumerFirstName;
        this.costumerLastName = costumerLastName;
        this.costumerAddress = costumerAddress;
        this.costumerContact = costumerContact;
    }

}
