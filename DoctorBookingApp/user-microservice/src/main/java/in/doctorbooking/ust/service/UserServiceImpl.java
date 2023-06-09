package in.doctorbooking.ust.service;

import in.doctorbooking.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
}
