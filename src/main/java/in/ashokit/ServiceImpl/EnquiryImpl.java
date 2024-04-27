package in.ashokit.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.Entity.Councellor;
import in.ashokit.Entity.Enquiry;
import in.ashokit.Repository.CouncellorRepository;
import in.ashokit.Repository.EnquiryRepository;
import in.ashokit.Service.EnquiryService;
import in.ashokit.dto.Dashboard;

@Service
public class EnquiryImpl implements EnquiryService {

	@Autowired
	private EnquiryRepository enqRepo;
	@Autowired
	private CouncellorRepository councellorRepo;

	@Override

	public Dashboard getDashboardinfo(Integer councellorId) {
		Long totalEnq = enqRepo.getEnquries(councellorId);
		Long openEnq = enqRepo.getEnquries(councellorId, "Open");
		Long lostEnq = enqRepo.getEnquries(councellorId, "Lost");
		Long enrolledEnq = enqRepo.getEnquries(councellorId, "Enrolled");

		Dashboard d = new Dashboard();
		d.setTotalEnqs(totalEnq);
		d.setLostEnqs(lostEnq);
		d.setOpenEnqs(openEnq);
		d.setEnrolledEnqs(enrolledEnq);
		return d;
	}

	@Override
	public boolean addEnquiry(Enquiry enquiry, Integer councellorId) {
		Councellor councellor = councellorRepo.findById(councellorId).orElseThrow();
		enquiry.setCouncellor(councellor);

		Enquiry save = enqRepo.save(enquiry);
		return save.getEnqID() != null;
	}

	@Override
	public List<Enquiry> getEnquiries(Enquiry enquiry, Integer councellorId) {
		Councellor councellor = new Councellor();
		councellor.setCouncellorId(councellorId);

		Enquiry searchCriteria = new Enquiry();
		searchCriteria.setCouncellor(councellor);

		if ( null!=enquiry.getCourse() && !"".equals(enquiry.getCourse())) {
			searchCriteria.setCourse(enquiry.getCourse());
		}

		if (  null!=enquiry.getMode() && !"".equals(enquiry.getMode())) {
			searchCriteria.setMode(enquiry.getMode());
		}
		if ( null!=enquiry.getStatus() && !"".equals(enquiry.getStatus())) {
			searchCriteria.setStatus(enquiry.getStatus());
		}

		Example<Enquiry> of = Example.of(searchCriteria);

		return enqRepo.findAll(of);
	}

	@Override
	public Enquiry getEnquiry(Integer enqId) {
		return enqRepo.findById(enqId).orElseThrow();

	}

}
