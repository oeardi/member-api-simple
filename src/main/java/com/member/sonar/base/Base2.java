package com.member.sonar.base;

import lombok.Data;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

/**
 * @author 冷枫红舞
 */
@Data
public class Base2 {

    public String getString() {
        String string = randomNumeric(2);
        return string;
    }
}
