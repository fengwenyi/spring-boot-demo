package com.fengwenyi.demospringbootjpaspecification.service.impl;

import com.fengwenyi.demospringbootjpaspecification.entity.UserEntity;
import com.fengwenyi.demospringbootjpaspecification.repository.IUserRepository;
import com.fengwenyi.demospringbootjpaspecification.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-21
 */
@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void queryPage() {
        PageRequest pageRequest = PageRequest.of(1, 10);
        Specification<UserEntity> specification = (root, criteriaQuery, criteriaBuilder) -> {
            List<javax.persistence.criteria.Predicate> list = new ArrayList<>();

            UserEntity query = new UserEntity();
            if (Objects.nonNull(query)) {

                String organCode = query.getOrganCode();
                if (StringUtils.hasText(organCode)) {
                    list.add(criteriaBuilder.like(root.get("organCode"), organCode + "-%"));
                }
                String businessCode = query.getBusinessCode();
                if (StringUtils.hasText(businessCode)) {
                    list.add(criteriaBuilder.equal(root.get("businessCode"), businessCode));
                }
                String businessName = query.getBusinessName();
                if (StringUtils.hasText(businessName)) {
                    list.add(criteriaBuilder.like(root.get("businessName"), "%" + businessName + "%"));
                }
            }

            criteriaQuery.where(list.toArray(new Predicate[0]));
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
            return null;
        };
        Page<UserEntity> userPage = userRepository.findAll(specification, pageRequest);
    }

}
