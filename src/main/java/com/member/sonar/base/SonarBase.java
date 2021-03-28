package com.member.sonar.base;

import lombok.Data;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

/**
 * @author Administrator
 */
@Data
public class SonarBase {
    public String getString() {
        String string = randomNumeric(2);
        return string;
    }
}
