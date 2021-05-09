package itcast.chap26annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Roles.class)
@interface Role {
    String roleName();
}
