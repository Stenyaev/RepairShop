package ru.stenyaev.RepairShop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producer;

    @Column(length = 8000)
    private String defectDescr;
    private String date;
    private String time;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
