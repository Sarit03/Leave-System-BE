package com.example.Leave.System.BE.Controller;

import com.example.Leave.System.BE.Entity.LeaveRequestEntity;
import com.example.Leave.System.BE.Service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leave-requests")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    @Autowired
    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping
    public List<LeaveRequestEntity> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/{id}")
    public Optional<LeaveRequestEntity> getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.getLeaveRequestById(id);
    }

    @PostMapping
    public LeaveRequestEntity createLeaveRequest(@RequestBody LeaveRequestEntity leaveRequestEntity) {
        return leaveRequestService.createLeaveRequest(leaveRequestEntity);
    }

    @PutMapping("/{id}")
    public LeaveRequestEntity updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequestEntity leaveRequestEntity) {
        return leaveRequestService.updateLeaveRequest(id, leaveRequestEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteLeaveRequest(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
    }
}
