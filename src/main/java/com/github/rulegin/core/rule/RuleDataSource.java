package com.github.rulegin.core.rule;


import com.github.rulegin.common.component.ConfigurableComponent;


public interface RuleDataSource<T> extends ConfigurableComponent<T>, RuleLifecycleComponent {

    boolean some();
    
}
