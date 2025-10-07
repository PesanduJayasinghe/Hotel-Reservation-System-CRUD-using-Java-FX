package model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoominfoDTO {

    private String roomID;

    private String type;

    private String description;

    private double price;

}
