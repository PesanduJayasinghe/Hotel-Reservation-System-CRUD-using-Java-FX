package model.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StaffInfoDTO {

    private String staffId;

    private String name;

    private String role;

    private String email;

    private String phoneNo;

    private String salary;
}
