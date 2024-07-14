package com.arturocode.springvalidations.controller.dto;


import com.arturocode.springvalidations.advise.validation.anotation.ValidName;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @ValidName
    private String name;

    @NotNull
    @Size(min = 3, max = 10)
    private String lastName;

    @NotBlank
    @Email
    private String email;
    private Long phone;

    @Min(18)
    @Max(60)
    private Byte age;

    @Digits(integer = 2, fraction = 3)
    private double height;
    private boolean married;

    @Past // Acepta fechas pasadas a la fecha actual y @Future acepta fechas posteriores a la fecha actual.
    private LocalDate dateOfBirth;

    @Valid
    private DepartmentDTO departmentDTO;

    //@NotEmpty se utiliza para garantizar que una lista no este vacia.
}
