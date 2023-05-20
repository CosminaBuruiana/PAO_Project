package ro.pao.model.tool;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import ro.pao.model.administration.Appointment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ToolORL {
    private UUID id;
    private String name;
}
