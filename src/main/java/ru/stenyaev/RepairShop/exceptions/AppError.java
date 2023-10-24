package ru.stenyaev.RepairShop.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppError {
    private int status;
    private String message;
    private Date date;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.date = new Date();
    }
}
