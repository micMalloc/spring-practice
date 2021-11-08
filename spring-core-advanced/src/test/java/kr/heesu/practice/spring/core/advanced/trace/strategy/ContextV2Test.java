package kr.heesu.practice.spring.core.advanced.trace.strategy;

import kr.heesu.practice.spring.core.advanced.trace.strategy.code.strategy.ContextV2;
import kr.heesu.practice.spring.core.advanced.trace.strategy.code.strategy.Strategy;
import kr.heesu.practice.spring.core.advanced.trace.strategy.code.strategy.StrategyLogic1;
import kr.heesu.practice.spring.core.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ContextV2Test {

    @DisplayName("전략 패턴 사용")
    @Test
    void strategyV1() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());
    }

    @DisplayName("전략 패턴 익명 내부 클래스")
    @Test
    void strategyV2() {
        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
    }

    @DisplayName("전략 패턴 람다")
    @Test
    void strategyV3() {
        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(() -> log.info("비즈니스 로직1 실행"));
        contextV2.execute(() -> log.info("비즈니스 로직1 실행"));
    }
}
