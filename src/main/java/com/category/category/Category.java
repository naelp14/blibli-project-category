package com.category.category;

import com.category.category.Validation.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "categories")
public class Category {
    @Id
    @NotBlank
    private String idCategory;

    @NotBlank
    @UniqueName
    private String nameCategory;

}
