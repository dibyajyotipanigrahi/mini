package in.ashokit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.Entity.Councellor;
import in.ashokit.Service.CouncellorService;
import in.ashokit.Service.EnquiryService;
import in.ashokit.dto.Dashboard;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CouncellorController {
	@Autowired
	private CouncellorService councellorService;
	@Autowired
	private EnquiryService enqService;

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("councellor", new Councellor());
		return "registerView";

	}

	@PostMapping("/register")
	public String handleRegister(Councellor councellor, Model model) {
		boolean status = councellorService.saveCouncellor(councellor);
		if (status) {
			model.addAttribute("smsg", "councellor Saved");
		} else {
			model.addAttribute("emsg", "Failed to save");
		}
		model.addAttribute("councellor", new Councellor());

		return "registerView";
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("councellor", new Councellor());
		return "index";
	}

	@PostMapping("/login")
	public String handleLogin(Councellor councellor, HttpServletRequest req, Model model) {
		Councellor c = councellorService.getCouncellor(councellor.getEmail(), councellor.getPwd());
		if (c == null) {
			model.addAttribute("emsg", "invalid credential");
			return "index";
		} else {

			HttpSession session = req.getSession(true);// every time new request
			session.setAttribute("cid", c.getCouncellorId());

			Dashboard dashboardinfo = enqService.getDashboardinfo(c.getCouncellorId());
			model.addAttribute("dashboard", dashboardinfo);
			return "dashboard";
		}

	}
	
	
	
	@GetMapping("/dashboard")
	public String buildDashboard(HttpServletRequest req,Model model) {
		HttpSession session = req.getSession(false);
		Integer cid = (Integer) session.getAttribute("cid");

		Dashboard dashboardinfo = enqService.getDashboardinfo(cid);
		model.addAttribute("dashboard", dashboardinfo);
		return "dashboard";
	}

	@GetMapping("/logout")
	public String logOut(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		return "redirect:login";

	}

}
