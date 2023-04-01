package models.tool;
import java.time.LocalDate;
import java.util.List;

import models.administration.Appointment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ToolCardiologist {
    private String name;
}

