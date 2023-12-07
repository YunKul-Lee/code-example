package com.jake.jdk21.amber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatternMatchController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name) {

        // arrow, inline : jdk 14 이상
        Loan loan = switch (name) {
            case "jake" -> new SecuredLoan();
            default -> new UnSecuredLoan(0.3f);
        };

        /*
         * pattern matching : jdk 21 이상
         */
        String message = switch (loan) {
            case SecuredLoan sl -> name + " 님은 무이자";
            case UnSecuredLoan(float interest) -> name + " 님은 이율이 " + interest + "%";
//            case UnSecuredLoan usl -> name + " 님은 이율이 " + usl.interest() + "%";
        };

        return message;
    }

    /**
     * switch 조건내에서 when 사용
     */
    private void when(Integer score) {

        String message = switch (score) {
            case 100 -> "Perfect";
            case Integer i when i >= 90 -> "Very Good";
            case Integer i when i >= 80 -> "Good";
            default -> "Not Good";
        };
    }

    /**
     * switch 문에 null 체크를 간단하게 적용
     *
     */
    private String nullCheck(Integer value) {

        return switch (value) {
            case 1 -> "One";
            case 2 -> "Two";
            case null, default -> "default";
        };
    }
}

/*
 * sealed 클래스/인터페이스는 상속(extends), 구현(implements) 대상 클래스를 지정해두고,
 * 해당 클래스들만 상속/구현이 가능하도록 제한하는 기능
 */
sealed interface Loan permits SecuredLoan, UnSecuredLoan {
}

// sealed 클래스 구현체는 final 로 선언되어야 함
final class SecuredLoan implements Loan {}

record UnSecuredLoan(float interest) implements Loan {}