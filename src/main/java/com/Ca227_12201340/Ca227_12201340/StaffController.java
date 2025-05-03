package com.Ca227_12201340.Ca227_12201340;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final StaffService staffService;

    // ✅ Manual constructor
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping()
    public Collection<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }

    @PostMapping()
    public void addStaff(@RequestBody Staff newStaff) {
        staffService.createStaff(newStaff);
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @PutMapping("/{id}")
    public Staff updateStaffById(@PathVariable Long id, @RequestBody Staff newStaff) {
        return staffService.updateStaff(id, newStaff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
    }
}
