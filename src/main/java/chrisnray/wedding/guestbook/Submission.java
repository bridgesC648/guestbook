package chrisnray.wedding.guestbook;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    @Id
    private String name;

    private String title;

    @Lob
    private String song;

    @Lob
    private String comment;

    private String instrument;

    private LocalDateTime timestamp;
}
