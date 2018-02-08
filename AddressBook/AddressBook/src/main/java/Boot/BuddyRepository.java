package Boot;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buddyInfo", path = "buddyInfo")
public interface BuddyRepository extends PagingAndSortingRepository<BuddyInfo, String> {

    List<BuddyInfo> findByPhoneNumber(String phoneNumber);
}