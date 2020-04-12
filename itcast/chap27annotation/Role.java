package itcast.chap27annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Roles.class)
@interface Role {
    String roleName();
}
