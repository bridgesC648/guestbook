package chrisnray.wedding.guestbook;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionRepository repository;

    @GetMapping
    public Page<Submission> getSubmissions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("timestamp").descending()));
    }

    @PutMapping("/{name}")
    public Submission updateSubmission(@PathVariable String name, @RequestBody Submission submission) {
        if (repository.existsById(name)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Submission with the same guest name already exists.");
        }
        submission.setTimestamp(LocalDateTime.now());
        return repository.save(submission);
    }
}
