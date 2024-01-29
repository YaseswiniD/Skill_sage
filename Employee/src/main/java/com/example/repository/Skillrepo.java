//package com.example.repository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.example.entity.Skills;
//
//
//public interface Skillrepo extends JpaRepository<Skills, Integer>{
//	
//	Optional<Skills> findBySkillname(String skillname);
//	
//	
//	List<Skills> findBySkillnameContaining(String searchName);
//
//
//	List<Skills> findBySkillidAndSkillnameAndDomainAndSubdomain(Integer skillid, String skillname, String domain,
//			String subdomain);
//
//	
//	@Query("SELECT DISTINCT s.domain FROM Skills s")
//    List<String> findDistinctDomains();
//
//    @Query("SELECT DISTINCT s.subdomain FROM Skills s WHERE s.domain = :domain")
//    List<String> findDistinctSubdomainsByDomain(String domain);
//    
//    @Query("SELECT DISTINCT s.domain FROM Skill s")
//    List<String> getAllDomains();
//
//    @Query("SELECT DISTINCT s.domain, s.subdomain FROM Skill s")
//    List<Object[]> getAllSubdomains();
//
//    default Map<String, List<String>> getAllSubdomainsByDomain() {
//        List<Object[]> subdomains = getAllSubdomains();
//        // Convert the list of Object arrays into a map
//        return subdomains.stream()
//            .collect(Collectors.groupingBy(
//                objArray -> (String) objArray[0], // Group by domain
//                Collectors.mapping(objArray -> (String) objArray[1], Collectors.toList()) // Collect subdomains
//            ));
//    }
//}


package com.example.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Skills;

public interface Skillrepo extends JpaRepository<Skills, Integer> {

    Optional<Skills> findBySkillname(String skillname);

    List<Skills> findBySkillnameContaining(String searchName);

    List<Skills> findBySkillidAndSkillnameAndDomainAndSubdomain(Integer skillid, String skillname, String domain,
            String subdomain);

    @Query("SELECT DISTINCT s.domain FROM Skills s")
    List<String> findDistinctDomains();
    
    @Query("SELECT DISTINCT s.subdomain FROM Skills s")
    List<String> findDistinctSubdomains();


    @Query("SELECT DISTINCT s.subdomain FROM Skills s WHERE s.domain = :domain")
    List<String> findDistinctSubdomainsByDomain(String domain);

    @Query("SELECT DISTINCT s.domain FROM Skills s")
    List<String> getAllDomains();

    @Query("SELECT DISTINCT s.domain, s.subdomain FROM Skills s")
    List<Object[]> getAllSubdomains();

    default Map<String, List<String>> getAllSubdomainsByDomain() {
        List<Object[]> subdomains = getAllSubdomains();
        // Convert the list of Object arrays into a map
        return subdomains.stream()
                .collect(Collectors.groupingBy(objArray -> (String) objArray[0], // Group by domain
                        Collectors.mapping(objArray -> (String) objArray[1], Collectors.toList()) // Collect subdomains
                ));
    }
}


