package com.example.projectc1023i1.service;

import com.example.projectc1023i1.Dto.EmployeeDTO;
import com.example.projectc1023i1.Exception.UserExepion;
import com.example.projectc1023i1.model.Users;
import com.example.projectc1023i1.repository.impl.IUserRepository;
import com.example.projectc1023i1.request.UpdateUserRequest;
import com.example.projectc1023i1.respone.UserRespone;
import com.example.projectc1023i1.service.impl.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Users> getAllUser(org.springframework.data.domain.Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Users updateUser(Integer userId, UpdateUserRequest updateUserRequest) throws UserExepion {
        Optional<Users> user = Optional.ofNullable(userRepository.findById(userId)
                .orElseThrow(() -> new UserExepion("User Not Found By Id: "+ userId)));

        return null;
    }

    @Override
    public List<Users> searchUsers(String value) {
        return List.of();
    }

    @Override
    public Users findUserById(Integer userId) throws UserExepion {
        Optional<Users> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } throw new UserExepion("User not found by id: "+ userId);
    }

    @Override
    public UserRespone convertUserToUserRespone(Users users) {
        return modelMapper.map(users, UserRespone.class);
    }

    @Override
    public Users ConvertEmployeeDtoToUser(EmployeeDTO employeeDto) {
        return modelMapper.map(employeeDto, Users.class);
    }

    @Override
    public Users saveUser(Users users) throws UserExepion {
        return userRepository.save(users);
    }

    @Override
    public Optional<Users> findByNumerphone(String phone) {
        return userRepository.findByNumberphone(phone);
    }

    @Override
    public void uploadImgEmployee(String url, String numberPhone) {
        userRepository.updateImage(url, numberPhone);
    }


}
