package com.example.realmanclub.beacerank_be.completionList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletionListRepository extends JpaRepository<CompletionList, Integer> {
}
