package com.example.Leave.System.BE.Repository;

import com.example.Leave.System.BE.Entity.LeaveRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequestEntity, Long> {
}
