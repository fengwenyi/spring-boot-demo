package com.fengwenyi.demospringbootdruid.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Erwin Feng
 * @since 2019/8/26 09:43
 */
//@Data
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_user")
public class UserModel implements Serializable {

    private static final long serialVersionUID = -5343083463187654115L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String username;

    private int age;

}
