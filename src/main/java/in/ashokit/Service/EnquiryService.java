package in.ashokit.Service;

import java.util.List;

import in.ashokit.Entity.Enquiry;
import in.ashokit.dto.Dashboard;

public interface EnquiryService {

	public Dashboard getDashboardinfo(Integer councellorId);

	public boolean addEnquiry(Enquiry enquiry,Integer councellorId);

	public List<Enquiry> getEnquiries(Enquiry enquiry, Integer councellorId);

	public Enquiry getEnquiry(Integer enqId);
}
