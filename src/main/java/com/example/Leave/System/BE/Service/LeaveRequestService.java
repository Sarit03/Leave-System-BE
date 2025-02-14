package com.example.Leave.System.BE.Service;

import com.example.Leave.System.BE.Entity.LeaveRequestEntity;
import com.example.Leave.System.BE.Repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    @Autowired
    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public List<LeaveRequestEntity> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public Optional<LeaveRequestEntity> getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    public LeaveRequestEntity createLeaveRequest(LeaveRequestEntity leaveRequestEntity) {
        return leaveRequestRepository.save(leaveRequestEntity);
    }

    public LeaveRequestEntity updateLeaveRequest(Long id, LeaveRequestEntity leaveRequestDetails) {
        LeaveRequestEntity leaveRequestEntity = leaveRequestRepository.findById(id).orElseThrow();
        leaveRequestEntity.setLeaveType(leaveRequestDetails.getLeaveType());
        leaveRequestEntity.setStartDate(leaveRequestDetails.getStartDate());
        leaveRequestEntity.setEndDate(leaveRequestDetails.getEndDate());
        leaveRequestEntity.setReason(leaveRequestDetails.getReason());
        leaveRequestEntity.setStatus(leaveRequestDetails.getStatus());
        return leaveRequestRepository.save(leaveRequestEntity);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
