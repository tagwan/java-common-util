package io.github.ai.behaviortree.node.condition;


import io.github.ai.behaviortree.abs.BaseCondition;
import io.github.ai.behaviortree.common.EStatus;
import io.github.ai.behaviortree.ifs.IBehaviour;

public class ConditionIsEnemyDead extends BaseCondition {

    public ConditionIsEnemyDead(boolean b) {
        setNegation(b);
    }

    @Override
    public EStatus update() {
        int random = getRandom();
        if (random < 60) {
            System.out.println("Enemy Is Dead");
            return !isNegation() ? EStatus.Success : EStatus.Failure;
        } else {
            System.out.println("Enemy is Not Dead");
            return !isNegation() ? EStatus.Failure : EStatus.Success;
        }

    }

    @Override
    public void addChild(IBehaviour child) {
    }

}