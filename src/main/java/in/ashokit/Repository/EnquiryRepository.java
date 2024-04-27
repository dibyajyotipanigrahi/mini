package in.ashokit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.Entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Integer> {

	@Query(value = "select count(*) from enquiry where councellor_id=:id", nativeQuery = true)
	public Long getEnquries(Integer id);

	@Query(value = "select count(*) from enquiry where councellor_id=:id and status=:status", nativeQuery = true)
	public Long getEnquries(Integer id, String status);

}
