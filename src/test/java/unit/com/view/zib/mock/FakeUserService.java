package com.view.zib.mock;

import com.view.zib.domain.user.entity.User;
import com.view.zib.domain.user.service.UserService;
import com.view.zib.global.exception.exceptions.ResourceNotFoundException;

import java.util.Optional;

public class FakeUserService implements UserService {

    private final FakeUserRepository userRepository;

    public FakeUserService(FakeUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getById(Long userId) {
        return findById(userId).orElseThrow(() -> new ResourceNotFoundException("Users", userId));
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }
}

