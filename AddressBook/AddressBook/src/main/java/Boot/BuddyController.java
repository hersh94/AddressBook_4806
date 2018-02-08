package Boot;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyController {

    @GetMapping("/buddies")
    public String buddyForm(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "buddies";
    }

    @PostMapping("/buddy")
    public String buddySubmit(@ModelAttribute BuddyInfo buddy) {
        return "result";
    }

}