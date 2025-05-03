package com.Ca227_12201340.Ca227_12201340;



import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StaffService {
    private final Map<Long, Staff> staffs = new ConcurrentHashMap<>();
    private final AtomicLong autoId = new AtomicLong();

    public Collection<Staff> getAllStaffs() {
        return staffs.values();
    }

    public Staff getStaffById(Long id) {
        return staffs.get(id);
    }

    public Staff createStaff(@NotNull Staff newStaff) {
        Long staffId = newStaff.getId() != null
                ? newStaff.getId()
                : autoId.incrementAndGet();
        Staff staffToSave = new Staff(staffId, newStaff.getName(), newStaff.getRole());
        staffs.put(staffId, staffToSave);
        return staffToSave;
    }

    public Staff updateStaff(Long id, Staff newStaff) {
        return staffs.computeIfPresent(id, (key, oldStaff) -> {
            oldStaff.setName(newStaff.getName());
            oldStaff.setRole(newStaff.getRole());
            return oldStaff;
        });
    }

    public boolean deleteStaff(Long id) {
        return staffs.remove(id) != null;
    }

}
