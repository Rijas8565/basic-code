package com.project.pagination.page;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    @Size(min = 3,max = 25)
    private String name;
    @Column(nullable = false)
    @Pattern(regexp = "[0-9a-zA-Z]{15}")
    private String registernumber;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate dob;
    @Column
    private Boolean status;
    @Column
    private Integer score;
    @Column(nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9[!#$%&'()+,/\\-_\\.\"]]+@[a-zA-Z0-9[!#$%&'()+,/\\-_\"]]+\\.[a-zA-Z0-9[!#$%&'()+,/\\-_\"]]")
    private String email;

    public void setDob(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        LocalDate dob = LocalDate.parse(date, formatter);
        this.dob = dob;
    }

    public void setStatus(String status) {

        if(status.equals("yes")||status.equals("YES")||status.equals("Yes"))
        this.status=true;
        else
            this.status=false;
    }
}
