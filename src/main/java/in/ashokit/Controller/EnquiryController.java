package in.ashokit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.Entity.Enquiry;
import in.ashokit.Service.EnquiryService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enqService;

	@GetMapping("/enquiry")
	public String addEnquiry(Model model) {
		model.addAttribute("Enquiry", new Enquiry());
		return "addEnq";
	}

	@PostMapping("/save")
	public String saveEnquiry(Enquiry enq, HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");

		boolean status = enqService.addEnquiry(enq, cid);
		if (status) {
			model.addAttribute("smsg", "Enquiry saved successfully");
		} else {
			model.addAttribute("emsg", "Enquiry not saved successfully");
		}
		model.addAttribute("Enquiry", new Enquiry());

		return "addEnq";
	}

	@GetMapping("/enquiries")
	public String getEnquiries(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");
		List<Enquiry> list = enqService.getEnquiries(new Enquiry(), cid);
		model.addAttribute("enqs", list);
		model.addAttribute("Enquiry", new Enquiry());
		return "viewEnquiries";
	}

	@PostMapping("/filter")
	public String filterEnqs(Enquiry enq, HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");

		List<Enquiry> list = enqService.getEnquiries(enq, cid);
		model.addAttribute("enqs", list);
		model.addAttribute("Enquiry", new Enquiry());

		return "viewEnquiries";

	}

	@GetMapping("/edit/{enqId}")
	public String editEnquiry(@PathVariable(name="enqId") Integer enqId, Model model) {
		Enquiry enquiry = enqService.getEnquiry(enqId);
		model.addAttribute("Enquiry", enquiry);

		return "addEnq";

	}

}
