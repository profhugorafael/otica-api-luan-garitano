package br.com.luan.gerenciamentootica.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private String title;
    private String brand;
    private double price;
    private int quantity;
}
