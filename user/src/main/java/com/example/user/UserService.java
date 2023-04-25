package com.example.user;

import com.example.user.domain.User;
import com.example.user.domain.UserRepository;
import com.example.user.domain.dto.UserCreateData;
import com.example.user.domain.dto.UserResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * 사용자를 저장한다
     *
     * @param userCreateData 저장하려는 사용자 이름
     * @return 저장된 사용자
     */
    public UserResponseData save(UserCreateData userCreateData) {
        User user = User.builder()
                .username(userCreateData.getUsername())
                .build();
        user = userRepository.save(user);

        return UserResponseData.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .team(null)
                .build();
    }

    /**
     * 사용자를 조회한다.
     *
     * @param id 사용자 id
     * @return 저장된 사용자와 팀 정보
     * @throws RuntimeException
     */
    public UserResponseData getUserById(Long id) {
        User userOptional = userRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        // Rest Template or Feign Client 작업 처리

        return UserResponseData.builder()
                .userId(userOptional.getId())
                .username(userOptional.getUsername())
                .team(null)
                .build();
    }

}
